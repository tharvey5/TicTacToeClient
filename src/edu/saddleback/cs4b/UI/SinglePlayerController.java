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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SinglePlayerController implements Initializable, Observer
{
    private GameManager gameManager = GameManager.getInstance();
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.GAME_FACT.getTypes());
    private User user = ClientUser.getInstanceOf();

    @FXML
    private Button playGameButton;

    public SinglePlayerController()
    {
        ClientEventLog.getInstance().addObserver(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @Override
    public void update(SystemEvent e)
    {
        if (e.getEvent().getType().equals(EventType.MESSAGE_EVENT.getType()))
        {
            BaseMessage message = ((MessageEvent)e.getEvent()).getMessage();
            if (message instanceof GameSuccessfullyCreatedMessage)
            {
                gameManager.setCreator(true);
                gameManager.setPlayer(true);
                gameManager.setSinglePlayer(true);
                System.out.println(((GameSuccessfullyCreatedMessage) message).getGameId());
                gameManager.setId(((GameSuccessfullyCreatedMessage) message).getGameId());
                System.out.println("Player has joined");
                swapScene("/edu/saddleback/cs4b/UI/GameBoard.fxml", playGameButton);
            }
        }
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'PLAY GAME' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightPlayGame()
    {
        playGameButton.setOnMouseEntered(mouseEvent -> playGameButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'PLAY GAME' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE
     * MOUSE IS NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetPlayGame()
    {
        playGameButton.setOnMouseExited(mouseEvent -> playGameButton.setTextFill(Color.WHITE));
    }

    @FXML
    public void handlePlayGameAction(MouseEvent event) throws IOException
    {
        //todo send the request for a new game to go here
        CreateGameMessage createMsg = new CreateGameMessage();
        uilog.notifyObservers(new MessageEvent(createMsg));
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
