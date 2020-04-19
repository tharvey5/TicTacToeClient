package edu.saddleback.cs4b.UI;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class ProfileChangeUsernameController implements Observer
{
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.ADMIN_FACT.getTypes());
    private User user = ClientUser.getInstanceOf();

    @FXML
    Button saveChangesButton;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

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
        if (message instanceof SuccessfulRegistration)
        {

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
            ProfileMessage profileUpdate = (ProfileMessage) factory.createMessage(MsgTypes.PROFILE.getType());
            Profile prof = new TTTProfile(username, user.getFirstName(), user.getLastName(), password);
            profileUpdate.setProfile(prof);
            uilog.notifyObservers(new MessageEvent(profileUpdate));
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
}
