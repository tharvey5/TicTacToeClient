package edu.saddleback.cs4b.UI;

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

public class SinglePlayerController implements Initializable
{
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
    private RadioButton selectModeImpossible;
    @FXML
    private ToggleGroup difficultyGroup;

    @FXML
    private RadioButton selectTurnPlayer;
    @FXML
    private RadioButton selectTurnComputer;
    @FXML
    private ToggleGroup turnGroup;

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
        this.selectModeImpossible.setToggleGroup(difficultyGroup);
        noDifficultySelection.setText("");
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'PLAY GAME' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightPlayGame()
    {
        playGameButton.setOnMouseEntered(mouseEvent -> playGameButton.setTextFill(Color.YELLOW));
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
            Parent parent = FXMLLoader.load(getClass().getResource("/edu/saddleback/cs4b/UI/GameBoard.fxml"));
            Scene scene  = new Scene(parent);

            // This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
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



}
