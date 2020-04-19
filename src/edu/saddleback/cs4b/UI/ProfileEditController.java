package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.ClientPackage.ClientUser;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.EventType;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.Utilitys.Profile;
import edu.saddleback.cs4b.Backend.Utilitys.TTTProfile;
import edu.saddleback.cs4b.Backend.Utilitys.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileEditController implements Observer, Initializable
{
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.ADMIN_FACT.getTypes());
    private User user = ClientUser.getInstanceOf();

    @FXML
    Button changeProfilePictureButton;

    @FXML
    Button saveChangesButton;

    @FXML
    Button changeUsernameButton;

    @FXML
    Button changePasswordButton;

    @FXML
    TextField firstNameField;

    @FXML
    TextField lastNameField;

    @FXML
    Label usernameLabel;

    @FXML
    Label winLossTieLabel;

    @Override
    public void update(SystemEvent e)
    {
        if (e.getEvent().getType().equals(EventType.MESSAGE_EVENT.getType()))
        {
            BaseMessage message = ((MessageEvent)e.getEvent()).getMessage();
            handleMessageEvents(message);
        }
    }

    private void handleMessageEvents(BaseMessage message)
    {
        if(message instanceof ProfileMessage)
        {
            ProfileMessage msg = (ProfileMessage) message;

            swapScene("/edu/saddleback/cs4b/UI/ClientHome.fxml", saveChangesButton);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/saddleback/cs4b/UI/ClientHome.fxml"));

            ClientHomeController crtl = loader.getController();
            crtl.handleProfileAction();
        }
    }

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

    /**
     * WHEN THIS METHOD IS CALLED THE 'CHANGE USERNAME' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightChangeUsername()
    {
        changeUsernameButton.setOnMouseEntered(mouseEvent -> changeUsernameButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CHANGE USERNAME' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetChangeUsername()
    {
        changeUsernameButton.setOnMouseExited(mouseEvent -> changeUsernameButton.setTextFill(Color.BLACK));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CHANGE PASSWORD' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightChangePassword()
    {
        changeUsernameButton.setOnMouseEntered(mouseEvent -> changeUsernameButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CHANGE PASSWORD' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetChangePassword()
    {
        changeUsernameButton.setOnMouseExited(mouseEvent -> changeUsernameButton.setTextFill(Color.BLACK));
    }


    @FXML
    public void handleChangeProfilePictureAction()
    {

    }

    @FXML
    public void handleChangeUsernameAction()
    {

    }

    @FXML
    public void handleChangePasswordAction()
    {

    }

    @FXML
    public void handleSaveChangesAction()
    {
        String firstName = firstNameField.getText();
        String lastName  = lastNameField.getText();

        if(!firstName.equals("") && !lastName.equals(""))
        {
            ProfileMessage profileUpdate = (ProfileMessage) factory.createMessage(MsgTypes.PROFILE.getType());
            Profile prof = new TTTProfile(user.getUsername(), firstName, lastName, user.getPassword());
            profileUpdate.setProfile(prof);
            uilog.notifyObservers(new MessageEvent(profileUpdate));
        }
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
        // This line gets the Stage information since loginButton and Register have same scene
        Stage window = (Stage)(button).getScene().getWindow();

        Platform.runLater(()->
        {
            window.setScene(scene);
            window.show();
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.firstNameField.setText(user.getFirstName());
        this.lastNameField.setText(user.getLastName());
        this.usernameLabel.setText(user.getUsername());
    }
}
