package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.ClientPackage.ClientUser;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.Objects.Coordinate;
import edu.saddleback.cs4b.Backend.Objects.TTTPosition;
import edu.saddleback.cs4b.Backend.PubSub.EventType;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.Utilitys.TTTProfile;
import edu.saddleback.cs4b.Backend.Utilitys.User;
import edu.saddleback.cs4b.UI.Util.GameManager;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import java.util.ResourceBundle;

public class GameBoardController implements Observer, Initializable
{
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.GAME_FACT.getTypes());
    private User user = ClientUser.getInstanceOf();
    private GameManager gameManager = GameManager.getInstance();

    private Map<String, String> userTokens = generateUserTokens();
    private Map<String, GameTiles> tileMapping = makeTileMapping();

    @FXML
    private Label player1Label;

    @FXML
    private Label player1ScoreLabel;

    @FXML
    private Label player2Label;

    @FXML
    private Label player2ScoreLabel;

    @FXML
    private Button leaveGameButton;

    @FXML
    private Button rematchButton;

    @FXML
    private Label outputGameMessagesLabel;

    @FXML
    private GridPane gameBoard;

    //private String gameId = "";  // todo change this
    private boolean isTurn;

    public GameBoardController() {
        ClientEventLog.getInstance().addObserver(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Platform.runLater(()-> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player1ScoreLabel.setText("0");
            player2ScoreLabel.setText("0");
            if (gameManager.isCreator()) {
                outputGameMessagesLabel.setText("YOU START!");
                isTurn = true;
            } else if (gameManager.isPlayer()) {
                outputGameMessagesLabel.setText("WAITING FOR PLAYER 1 TO MOVE");
                isTurn = false;
            } else {
                outputGameMessagesLabel.setText("YOU ARE VIEWING GAME " + gameManager.getId());
                isTurn = false;
            }
        });
    }

    @Override
    public void update(SystemEvent e)
    {
        if (e.getEvent().getType().equals(EventType.MESSAGE_EVENT.getType()))
        {
            BaseMessage message = ((MessageEvent)e.getEvent()).getMessage();
            try
            {
                handleMessageEvents(message);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private void handleMessageEvents(BaseMessage message) throws IOException
    {
        if (message instanceof ValidMoveMessage)
        {
            ValidMoveMessage move = (ValidMoveMessage) message;
            setToken(findTile(move.getCoordinate()), userTokens.get(move.getToken().getTokenID()));

            if (gameManager.isPlayer()) {
                if (move.getUser().equals(user.getUsername())) {
                    isTurn = false;
                    Platform.runLater(() -> {
                        outputGameMessagesLabel.setText("Waiting...");
                    });
                } else {
                    isTurn = true;
                    Platform.runLater(() -> {
                        outputGameMessagesLabel.setText("Make a Move");
                    });
                }
            }
        }
        else if (message instanceof InvalidMoveMessage && gameManager.isPlayer())
        {
            Platform.runLater(()-> {
                outputGameMessagesLabel.setText("Invalid Placement Spot Taken");
            });
            isTurn = true;
        }
        else if (message instanceof GameResultMessage)
        {
            GameResultMessage resMsg = (GameResultMessage)message;

            // clears the data about the previous game in the manager
            // makes room for a new game
            gameManager.clear();
            if (resMsg.getWinner() == null) {
                Platform.runLater(()-> {
                    outputGameMessagesLabel.setText("Game has ended in a tie");
                });
            } else {
                Platform.runLater(()->{
                    outputGameMessagesLabel.setText(resMsg.getWinner() + " has won the game");
                    updateScoreboard(resMsg.getWinner());
                });
            }
        }
    }

    private void updateScoreboard(String winner) {
        //todo -- gonna hold off for possibly better information
        // regarding the winner than doing it based on name
    }

    @FXML
    void boardElementClicked(Event e)
    {
        if (isTurn && gameManager.isPlayer()) {
            GameTiles tile = tileMapping.get(GridPane.getRowIndex((Node) e.getSource()) + ", " + GridPane.getColumnIndex((Node) e.getSource()));
            MoveMessage moveMessage = (MoveMessage) factory.createMessage(MsgTypes.MOVE.getType());
            moveMessage.setCoordinate(new TTTPosition(tile.getTileRow(), tile.getTileColumn()));
            moveMessage.setGameId(gameManager.getId());
            uilog.notifyObservers(new MessageEvent(moveMessage));
        }
    }

    // could make this more efficient by mapping the coordinate to its index vs a search
    private Node findTile(Coordinate coordinate) {
        Node node = null;
        ObservableList<Node> children = gameBoard.getChildren();
        for (Node n : children) {
            GameTiles tile = tileMapping.get(GridPane.getRowIndex(n) + ", " + GridPane.getColumnIndex(n));
            if (tile.getTileRow() == (Integer)coordinate.getXCoord() &&
                    tile.getTileColumn() == (Integer)(coordinate.getYCoord())) {
                node = n;
                break;
            }
        }
        return node;
    }

    void setToken(Node src, String token)
    {
        try
        {
            Pane paneClicked = (Pane) src;
            ImageView imageView = (ImageView) (paneClicked.getChildren().get(0));
            if(imageView.getImage() == null)
            {
                imageView.setImage(new Image(new FileInputStream(token)));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    void updateMessageBanner(String token)
    {

    }

    @FXML
    public void handleRematchAction()
    {

    }

    @FXML
    public void handleLeaveGameAction() throws IOException
    {
        swapHomeMainMenu("/edu/saddleback/cs4b/UI/ClientHome.fxml", leaveGameButton);
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'LEAVE GAME' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightLeaveGame()
    {
        leaveGameButton.setOnMouseEntered(mouseEvent -> leaveGameButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'LEAVE GAME' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetLeaveGame()
    {
        leaveGameButton.setOnMouseExited(mouseEvent -> leaveGameButton.setTextFill(Color.BLACK));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'LEAVE GAME' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightRematch()
    {
        rematchButton.setOnMouseEntered(mouseEvent -> rematchButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'LEAVE GAME' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetRematch()
    {
        rematchButton.setOnMouseExited(mouseEvent -> rematchButton.setTextFill(Color.BLACK));
    }

    public void swapHomeMainMenu(String sceneLocation, Button button) throws IOException
    {
        ClientEventLog.getInstance().removeObserver(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneLocation));
        Parent root = loader.load();
        Scene scene  = new Scene(root);
        Stage window = (Stage)(button).getScene().getWindow();

        ClientHomeController crtl = loader.getController();
        crtl.handleMainMenuAction();


        Platform.runLater(()->
        {
            window.setScene(scene);
            window.show();
        });
    }

    /**
     * FACTORY FUNCTIONS:
     *
     * Factory function creates mapping of ordered pair to game tiles
     * NOTE: GridPane's static functions return null for 0th index
     */
    private Map<String, GameTiles> makeTileMapping()
    {
        Map<String, GameTiles> tiles = new Hashtable<>();

        tiles.put("null, null", GameTiles.TOP_LEFT);
        tiles.put("null, 1", GameTiles.TOP_CENTER);
        tiles.put("null, 2", GameTiles.TOP_RIGHT);
        tiles.put("1, null", GameTiles.MIDDLE_LEFT);
        tiles.put("1, 1", GameTiles.CENTER);
        tiles.put("1, 2", GameTiles.MIDDLE_RIGHT);
        tiles.put("2, null", GameTiles.BOTTOM_LEFT);
        tiles.put("2, 1", GameTiles.BOTTOM_CENTER);
        tiles.put("2, 2", GameTiles.BOTTOM_RIGHT);
        return tiles;
    }

    /**
     * Factor function creates a mapping of token id to the location of the token image
     */
    private Map<String, String> generateUserTokens()
    {
        Map<String, String> tokens = new Hashtable<>();

        tokens.put(Tokens.DEFAULT_X.getId(), Tokens.DEFAULT_X.getLocation());
        tokens.put(Tokens.DEFAULT_O.getId(), Tokens.DEFAULT_O.getLocation());
        tokens.put(Tokens.RED_X.getId(), Tokens.RED_X.getLocation());
        tokens.put(Tokens.BLUE_O.getId(), Tokens.BLUE_O.getLocation());

        return tokens;
    }
}
