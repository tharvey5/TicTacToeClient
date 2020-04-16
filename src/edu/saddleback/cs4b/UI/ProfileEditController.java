package edu.saddleback.cs4b.UI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileEditController
{
    @FXML
    Button changeProfilePictureButton;

    @FXML
    Button saveChangesButton;

    /**
     * WHEN THIS METHOD IS CALLED THE 'CHANGE PROFILE PICTURE' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightChangeProfilePicture()
    {
        changeProfilePictureButton.setOnMouseEntered(mouseEvent -> changeProfilePictureButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CHANGE PROFILE PICTURE' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetChangeProfilePicture()
    {
        changeProfilePictureButton.setOnMouseExited(mouseEvent -> changeProfilePictureButton.setTextFill(Color.BLACK));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'SAVE CHANGES' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightSaveChanges()
    {
        saveChangesButton.setOnMouseEntered(mouseEvent -> saveChangesButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'SAVE CHANGES' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetSaveChanges()
    {
        saveChangesButton.setOnMouseExited(mouseEvent -> saveChangesButton.setTextFill(Color.BLACK));
    }


    @FXML
    public void handleChangeProfilePictureAction(MouseEvent event)
    {

    }

    @FXML
    public void handleSaveChangesAction(MouseEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/saddleback/cs4b/UI/ClientHome.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        // This line gets the Stage information since loginButton and Register have same scene
        Stage window = (Stage) (saveChangesButton).getScene().getWindow();
        ClientHomeController crtl = loader.getController();
        crtl.handleProfileAction(event);

        Platform.runLater(() ->
        {
            window.setScene(scene);
            window.show();
        });
    }

}
