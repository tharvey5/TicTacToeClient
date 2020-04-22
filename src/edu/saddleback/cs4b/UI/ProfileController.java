package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientUser;
import edu.saddleback.cs4b.Backend.Utilitys.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable
{
    private User user = ClientUser.getInstanceOf();

    @FXML
    Label firstNameLabel;

    @FXML
    Label lastNameLabel;

    @FXML
    Label winLossTieLabel;

    @FXML
    Label usernameLabel;

    @FXML
    Label passwordLabel;

    @FXML
    Button editProfileButton;

    @FXML
    ImageView profilePicture;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.firstNameLabel.setText(user.getFirstName());
        this.lastNameLabel.setText(user.getLastName());
        this.usernameLabel.setText(user.getUsername());
    }

    @FXML
    public void handleEditProfileAction() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/saddleback/cs4b/UI/ClientHome.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage window = (Stage) (editProfileButton).getScene().getWindow();

        ClientHomeController crtl = loader.getController();
        crtl.handleEditProfileAction();

        Platform.runLater(() ->
        {
            window.setScene(scene);
            window.show();
        });
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'EDIT PROFILE' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightEditProfile()
    {
        editProfileButton.setOnMouseEntered(mouseEvent -> editProfileButton.setTextFill(Color.valueOf("#FFD700")));
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
}
