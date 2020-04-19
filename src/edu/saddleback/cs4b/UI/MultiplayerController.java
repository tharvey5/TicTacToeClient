package edu.saddleback.cs4b.UI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MultiplayerController
{
    @FXML
    Button refreshButton;
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

    @FXML
    public void handleRefreshAction(MouseEvent event)
    {

    }


}
