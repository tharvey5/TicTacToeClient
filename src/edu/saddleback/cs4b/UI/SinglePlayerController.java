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
    @FXML
    private Label noTokenSelection;
    @FXML
    private Label noTurnSelection;
    @FXML
    private Label noDifficultySelection;

    @FXML
    private RadioButton token_1_XO;
    @FXML
    private RadioButton token_2_XO;
    @FXML
    private ToggleGroup tokenGroup;

    @FXML
    private RadioButton selectModeEasy;
    @FXML
    private RadioButton selectModeNormal;
    @FXML
    private RadioButton selectModeHard;
    @FXML
    private ToggleGroup difficultyGroup;

    @FXML
    private RadioButton selectTurnPlayer;
    @FXML
    private RadioButton selectTurnComputer;
    @FXML
    private ToggleGroup turnGroup;

    public SinglePlayerController()
    {
        ClientEventLog.getInstance().addObserver(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        // Assigns token RadioButtons to ToggleGroup 'tokenGroup'
        tokenGroup = new ToggleGroup();
        this.token_1_XO.setToggleGroup(tokenGroup);
        this.token_2_XO.setToggleGroup(tokenGroup);
        noTokenSelection.setText("");

        // Assigns turn RadioButtons to ToggleGroup 'turnGroup'
        turnGroup = new ToggleGroup();
        this.selectTurnPlayer.setToggleGroup(turnGroup);
        this.selectTurnComputer.setToggleGroup(turnGroup);
        noTurnSelection.setText("");

        // Assigns difficulty RadioButtons to ToggleGroup 'difficultyGroup'
        difficultyGroup = new ToggleGroup();
        this.selectModeEasy.setToggleGroup(difficultyGroup);
        this.selectModeNormal.setToggleGroup(difficultyGroup);
        this.selectModeHard.setToggleGroup(difficultyGroup);
        noDifficultySelection.setText("");
    }

    @Override
    public void update(SystemEvent e)
    {
        if (e.getEvent().getType().equals(EventType.MESSAGE_EVENT.getType()))
        {
            BaseMessage message = ((MessageEvent)e.getEvent()).getMessage();
            if (message instanceof GameSuccessfullyCreatedMessage)
            {
                swapScene("/edu/saddleback/cs4b/UI/GameBoard.fxml", playGameButton);
                gameManager.setCreator(true);
                gameManager.setPlayer(true);
                gameManager.setSinglePlayer(true);
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
        if(missingToken() & missingTurn() & missingDifficulty())
        {
            //todo send the request for a new game to go here
            CreateGameMessage createMsg = new CreateGameMessage();
            uilog.notifyObservers(new MessageEvent(createMsg));
//            Parent parent = FXMLLoader.load(getClass().getResource("/edu/saddleback/cs4b/UI/GameBoard.fxml"));
//            Scene scene  = new Scene(parent);
//            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//
//            window.setScene(scene);
//            window.show();
        }
    }

    @FXML
    public boolean missingToken()
    {
        boolean selected = true;

        try
        {
            noTokenSelection.setText("");
            tokenGroup.getSelectedToggle().isSelected();
        }
        catch(Exception e)
        {
            noTokenSelection.setText("* Please select your tokens *");
            selected = false;
        }
        return selected;
    }

    @FXML
    public boolean missingTurn()
    {
        boolean selected = true;

        try
        {
            noTurnSelection.setText("");
            turnGroup.getSelectedToggle().isSelected();
        }
        catch(Exception e)
        {
            noTurnSelection.setText("* Please select who goes first *");
            selected = false;
        }
        return selected;
    }

    @FXML
    public boolean missingDifficulty()
    {
        boolean selected = true;

        try
        {
            noDifficultySelection.setText("");
            difficultyGroup.getSelectedToggle().isSelected();
        }
        catch(Exception e)
        {
            noDifficultySelection.setText("* Please select a difficulty *");
            selected = false;
        }
        return selected;
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
