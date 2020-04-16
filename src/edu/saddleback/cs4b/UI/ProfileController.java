package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Observer, Initializable
{
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


    public ProfileController()
    {
        ClientEventLog.getInstance().addObserver(this);
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

    @FXML
    public void handleEditProfileAction(MouseEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/saddleback/cs4b/UI/ClientHome.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        // This line gets the Stage information since loginButton and Register have same scene
        Stage window = (Stage) (editProfileButton).getScene().getWindow();
        ClientHomeController crtl = loader.getController();
        crtl.handleEditProfileAction(event);

        Platform.runLater(() ->
        {
            window.setScene(scene);
            window.show();
        });

    }

    @Override
    public void update(SystemEvent e)
    {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
