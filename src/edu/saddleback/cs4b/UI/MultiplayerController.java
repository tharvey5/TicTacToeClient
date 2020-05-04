package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.ClientPackage.ClientUser;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.EventType;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.Utilitys.User;
import edu.saddleback.cs4b.UI.Util.GameManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MultiplayerController implements Observer, Initializable
{
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.GAME_FACT.getTypes());
    private User user = ClientUser.getInstanceOf();
    private GameManager gameManager = GameManager.getInstance();

    @FXML
    Button refreshButton;

    @FXML
    Button joinButton;

    @FXML
    Button spectateButton;

    @FXML
    Button createGameButton;

    @FXML
    ListView gameMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public MultiplayerController()
    {
        ClientEventLog.getInstance().addObserver(this);
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
//        if(message instanceof GameSuccessfullyCreatedMessage ||
//           message instanceof AvailableGameMessage ||
//           message instanceof SuccessfulViewGameMessage)
//        {
//            swapScene("/edu/saddleback/cs4b/UI/GameBoard.fxml", createGameButton);
//
//        }
        if (message instanceof GameSuccessfullyCreatedMessage)
        {
            swapScene("/edu/saddleback/cs4b/UI/GameBoard.fxml", createGameButton);
            gameManager.setCreator(true);
            gameManager.setPlayer(true);
            gameManager.setId(((GameSuccessfullyCreatedMessage) message).getGameId());
        }
        else if (message instanceof AvailableGameMessage)
        {
            swapScene("/edu/saddleback/cs4b/UI/GameBoard.fxml", createGameButton);
            gameManager.setPlayer(true);
            gameManager.setCreator(false);
            gameManager.setId(((AvailableGameMessage) message).getGameId());
        }
        else if (message instanceof SuccessfulViewGameMessage)
        {
            swapScene("/edu/saddleback/cs4b/UI/GameBoard.fxml", createGameButton);
            gameManager.setCreator(false);
            gameManager.setPlayer(false);
            gameManager.setId(((SuccessfulViewGameMessage) message).getGameID());
        }
    }

    @FXML
    public void handleJoinAction()
    {
        JoinGameRequestMessage joinMessage = (JoinGameRequestMessage) factory.createMessage(MsgTypes.JOIN_GAME_REQUEST.getType());

        // this needs to be based on the options on the menu
        //joinMessage.setGameID("1");
        uilog.notifyObservers(new MessageEvent(joinMessage));
    }

    @FXML
    public void handleCreateGameAction()
    {
        CreateGameMessage createMessage = (CreateGameMessage) factory.createMessage(MsgTypes.CREATE_GAME.getType());
        uilog.notifyObservers(new MessageEvent(createMessage));
        //swapScene("/edu/saddleback/cs4b/UI/GameBoard.fxml", createGameButton);
    }

    @FXML
    public void handleSpectateAction()
    {
        ViewGameRequestMessage viewGame = (ViewGameRequestMessage) factory.createMessage(MsgTypes.VIEW_GAME_REQUEST.getType());
        viewGame.setGameID("1");
        uilog.notifyObservers(new MessageEvent(viewGame));
    }

    @FXML
    public void handleRefreshAction()
    {

    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'EDIT PROFILE' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightRefresh()
    {
        refreshButton.setOnMouseEntered(mouseEvent -> refreshButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'EDIT PROFILE' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetRefresh()
    {
        refreshButton.setOnMouseExited(mouseEvent -> refreshButton.setTextFill(Color.BLACK));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'JOIN' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightJoin()
    {
        joinButton.setOnMouseEntered(mouseEvent -> joinButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'JOIN' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetJoin()
    {
        joinButton.setOnMouseExited(mouseEvent -> joinButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'SPECTATE' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightSpectate()
    {
        spectateButton.setOnMouseEntered(mouseEvent -> spectateButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'SPECTATE' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetSpectate()
    {
        spectateButton.setOnMouseExited(mouseEvent -> spectateButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CREATE GAME' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightCreateGame()
    {
        createGameButton.setOnMouseEntered(mouseEvent -> createGameButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CREATE GAME' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetCreateGame()
    {
        createGameButton.setOnMouseExited(mouseEvent -> createGameButton.setTextFill(Color.BLACK));
    }

    public void swapScene(String sceneLocation, Button button)
    {
        Parent parent = null;
        ClientEventLog.getInstance().removeObserver(this);
        try
        {
            parent = FXMLLoader.load(getClass().getResource(sceneLocation));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Scene scene  = new Scene(parent);
        Stage window = (Stage)(button).getScene().getWindow();

        Platform.runLater(()->
        {
            window.setScene(scene);
            window.show();
        });
    }

}
