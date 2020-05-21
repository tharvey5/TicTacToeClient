package edu.saddleback.cs4b.UI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class DeactivateAccountController
{
    @FXML
    Button yesButton;

    @FXML
    Button noButton;

    @FXML
    public void handleYesAction()
    {

    }

    @FXML
    public void handleNoAction()
    {

    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'YES' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightYes()
    {
        yesButton.setOnMouseEntered(mouseEvent -> yesButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'YES' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetYes()
    {
        yesButton.setOnMouseExited(mouseEvent -> yesButton.setTextFill(Color.BLACK));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'NO' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightNo()
    {
        noButton.setOnMouseEntered(mouseEvent -> noButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'NO' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetNo()
    {
        noButton.setOnMouseExited(mouseEvent -> noButton.setTextFill(Color.BLACK));
    }


}
