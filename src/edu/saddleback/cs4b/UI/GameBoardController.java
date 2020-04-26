package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
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
    private final int IMG_MSG_BANNER_HEIGHT = 30;
    private final int IMG_MGS_BANNER_WIDTH = 30;

    private Map<String, String> userTokens = generateUserTokens();
    private Map<String, GameTiles> tileMapping = makeTileMapping();

    private String[] gameTokens = {Tokens.DEFAULT_X.getLocation(), Tokens.DEFAULT_O.getLocation()};
    private String currToken = gameTokens[0];


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





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @Override
    public void update(SystemEvent e)
    {

    }

    @FXML
    void boardElementClicked(Event e)
    {
        GameTiles tile = tileMapping.get(GridPane.getRowIndex((Node)e.getSource()) + ", " + GridPane.getColumnIndex((Node)e.getSource()));
        // logTileClicked(tile);
        setToken((Node)e.getSource(), currToken);
        currToken = swapToken(currToken);
        updateMessageBanner(currToken);
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

    String swapToken(String token)
    {
        return token == gameTokens[0] ? gameTokens[1] : gameTokens[0];
    }

    void updateMessageBanner(String token)
    {
        ImageView img = new ImageView();
        img.setFitHeight(IMG_MSG_BANNER_HEIGHT);
        img.setFitWidth(IMG_MGS_BANNER_WIDTH);
        try
        {
            if(token.equals(gameTokens[0]))
            {
                outputGameMessagesLabel.setText("Player 1 Turn!");
                img.setImage(new Image(new FileInputStream(gameTokens[0])));
                outputGameMessagesLabel.setGraphic(img);
            }
            else
            {
                outputGameMessagesLabel.setText("Player 2 Turn!");
                img.setImage(new Image(new FileInputStream(gameTokens[1])));
                outputGameMessagesLabel.setGraphic(img);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleRematchAction()
    {
        ObservableList<Node> boardTiles = gameBoard.getChildren();

        // for each pane -> take their one child ImageView -> set the image to null
        for(Node n : boardTiles)
        {
            Pane tile = (Pane)n;
            ImageView imgView = (ImageView)tile.getChildren().get(0);
            imgView.setImage(null);
        }

        gameTokens[0] = Tokens.DEFAULT_X.getLocation();
        gameTokens[1] = Tokens.DEFAULT_O.getLocation();
        currToken = gameTokens[0];
        updateMessageBanner(gameTokens[0]);
    }

    @FXML
    public void handleLeaveGameAction()
    {

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
