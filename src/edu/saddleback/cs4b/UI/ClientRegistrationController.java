package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.*;
import edu.saddleback.cs4b.Backend.Utilitys.Profile;
import edu.saddleback.cs4b.Backend.Utilitys.TTTProfile;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientRegistrationController implements Observer
{
//    private List<UIObserver> uiObservers = new ArrayList<>();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.ADMIN_FACT.getTypes());

    @FXML
    Button returnToLoginButton;

    @FXML
    Button registerAccountButton;

    @FXML
    TextField usernameField;

    @FXML
    TextField passwordField;

    @FXML
    TextField firstnameField;

    @FXML
    TextField lastnameField;

    public ClientRegistrationController() {
        ClientEventLog.getInstance().addObserver(this);
    }

    /**
     * This will be called by the client backend
     */
    @Override
    public void update(SystemEvent e)
    {
        if (e.getEvent().getType().equals(EventType.MESSAGE_EVENT.getType())) {
            BaseMessage message = ((MessageEvent)e.getEvent()).getMessage();
            handleMessageEvents(message);
        }
    }

    private void handleMessageEvents(BaseMessage message)
    {
        if (message instanceof SuccessfulRegistration)
        {
            showSuccessfulRegistration();
        }
        else if (message instanceof RegistrationErrorMessage)
        {
            // popup the scene showing unsuccessful message
            Platform.runLater(()-> {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Username Exists");
                alert.show();
            });
        }
    }


    /**
     * WHEN THIS METHOD IS CALLED THE 'RETURN TO LOGIN' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightReturnToLogin()
    {
        returnToLoginButton.setOnMouseEntered(mouseEvent -> returnToLoginButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'RETURN TO LOGIN' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetReturnToLogin()
    {
        returnToLoginButton.setOnMouseExited(mouseEvent -> returnToLoginButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'REGISTER ACCOUNT' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightRegisterAccount()
    {
        registerAccountButton.setOnMouseEntered(mouseEvent -> registerAccountButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'REGISTER ACCOUNT' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetRegisterAccount()
    {
        registerAccountButton.setOnMouseExited(mouseEvent -> registerAccountButton.setTextFill(Color.WHITE));
    }

    @FXML
    public void handleReturnToLoginAction(ActionEvent event) throws IOException
    {
        swapScene("/edu/saddleback/cs4b/UI/ClientLogin.fxml");
    }

    @FXML
    public void handleRegisterAccountAction(ActionEvent event) throws IOException
    {
        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (!firstname.equals("") && !lastname.equals("") && !username.equals("") && !password.equals("")) {
            ProfileMessage profileMessage = (ProfileMessage) factory.createMessage(MsgTypes.PROFILE.getType());
            Profile prof = new TTTProfile(username, firstname, lastname, password);
            profileMessage.setProfile(prof);
            UIEventLog.getInstance().notifyObservers(new MessageEvent(profileMessage));
        } else {
            // generate an error message to the screen
        }

        //swapScene("/edu/saddleback/cs4b/UI/AccountCreationSuccess.fxml");
    }

    public void showSuccessfulRegistration() {
        swapScene("/edu/saddleback/cs4b/UI/AccountCreationSuccess.fxml");
    }

    public void swapScene(String sceneLocation)
    {
        ClientEventLog.getInstance().removeObserver(this);
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource(sceneLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene  = new Scene(parent);
        Stage window = (Stage)(returnToLoginButton).getScene().getWindow();
        Platform.runLater(()->{
            window.setScene(scene);
            window.show();
        });
    }
}
