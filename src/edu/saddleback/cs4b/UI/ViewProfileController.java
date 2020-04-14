package edu.saddleback.cs4b.UI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ViewProfileController
{
    @FXML
    Button editProfileButton;

    @FXML
    Button changeProfilePictureButton;

    @FXML
    Button saveChangesButton;

    /**
     * WHEN THIS METHOD IS CALLED THE 'EDIT PROFILE' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightEditProfile()
    {
        editProfileButton.setOnMouseEntered(mouseEvent -> editProfileButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'EDIT PROFILE' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetEditProfile()
    {
        editProfileButton.setOnMouseExited(mouseEvent -> editProfileButton.setTextFill(Color.BLACK));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CHANGE PROFILE PICTURE' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightChangeProfilePicture()
    {
        changeProfilePictureButton.setOnMouseEntered(mouseEvent -> changeProfilePictureButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CHANGE PROFILE PICTURE' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetChangeProfilePicture()
    {
        changeProfilePictureButton.setOnMouseExited(mouseEvent -> changeProfilePictureButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'SAVE CHANGES' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightSaveChanges()
    {
        saveChangesButton.setOnMouseEntered(mouseEvent -> saveChangesButton.setTextFill(Color.YELLOW));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'SAVE CHANGES' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetSaveChanges()
    {
        saveChangesButton.setOnMouseExited(mouseEvent -> saveChangesButton.setTextFill(Color.WHITE));
    }

    @FXML
    public void handleEditProfileAction(MouseEvent event)
    {

    }

    @FXML
    public void handleChangeProfilePictureAction(MouseEvent event)
    {

    }

    @FXML
    public void handleSaveChangesAction(MouseEvent event)
    {

    }

}
