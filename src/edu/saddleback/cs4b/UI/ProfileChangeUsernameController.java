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
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileChangeUsernameController implements Observer, Initializable
{
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.ADMIN_FACT.getTypes());
    private User user = ClientUser.getInstanceOf();

    @FXML
    Button saveChangesButton;

    @FXML
    Label usernameLabel;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.usernameLabel.setText(user.getUsername());
    }

    public ProfileChangeUsernameController()
    {
        ClientEventLog.getInstance().addObserver(this);
    }

    @Override
    public void update(SystemEvent e)
    {
        if (e.getEvent().getType().equals(EventType.MESSAGE_EVENT.getType()))
        {
            BaseMessage message = ((MessageEvent)e.getEvent()).getMessage();
            try
            {
                handleMessageEvents(message);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private void handleMessageEvents(BaseMessage message) throws IOException
    {
        if(message instanceof SuccessfulUpdateProfileMessage)
        {
            SuccessfulUpdateProfileMessage msg = (SuccessfulUpdateProfileMessage) message;
            ClientUser.setInstance(msg.getUser());
            swapHomeProfile("/edu/saddleback/cs4b/UI/ClientHome.fxml", saveChangesButton);

        }
        else if (message instanceof RegistrationErrorMessage)
        {
            Platform.runLater(()->
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Username Exists");
                alert.show();
            });
        }
    }

    @FXML
    public void handleSaveChangesAction()
    {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(!username.equals("") && !password.equals(""))
        {
            if(!username.equals(user.getUsername()) && password.equals(user.getPassword()))
            {
                UpdateProfileMessage updateProfileMessage = (UpdateProfileMessage) factory.createMessage(MsgTypes.UPDATE_PROFILE.getType());
                Profile prof = new TTTProfile(username, user.getFirstName(), user.getLastName(), password);
                updateProfileMessage.setProfile(prof);
                uilog.notifyObservers(new MessageEvent(updateProfileMessage));
            }
        }
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

    public void swapHomeProfile(String sceneLocation, Button button) throws IOException
    {
        ClientEventLog.getInstance().removeObserver(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneLocation));
        Parent root = loader.load();
        Scene scene  = new Scene(root);
        Stage window = (Stage)(button).getScene().getWindow();

        ClientHomeController crtl = loader.getController();
        crtl.handleProfileAction();

        Platform.runLater(()->
        {
            window.setScene(scene);
            window.show();
        });
    }
}
