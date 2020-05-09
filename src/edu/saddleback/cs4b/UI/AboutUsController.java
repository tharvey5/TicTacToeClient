package edu.saddleback.cs4b.UI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutUsController
{
    @FXML
    Button returnToMainMenuBtn;

    @FXML
    public void handleReturnToMainMenuAction() throws IOException
    {
        swapHomeMainMenu("/edu/saddleback/cs4b/UI/ClientHome.fxml", returnToMainMenuBtn);
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'RETURN TO MAIN MENU' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightReturnToMainMenu()
    {
        returnToMainMenuBtn.setOnMouseEntered(mouseEvent -> returnToMainMenuBtn.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'RETURN TO MAIN MENU' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetReturnToMainMenu()
    {
        returnToMainMenuBtn.setOnMouseExited(mouseEvent -> returnToMainMenuBtn.setTextFill(Color.BLACK));
    }

    public void swapHomeMainMenu(String sceneLocation, Button button) throws IOException
    {
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
}
