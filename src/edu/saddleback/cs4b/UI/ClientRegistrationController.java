package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.*;
import edu.saddleback.cs4b.Backend.Utilitys.Profile;
import edu.saddleback.cs4b.Backend.Utilitys.TTTProfile;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientRegistrationController implements Observer, Initializable
{
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.ADMIN_FACT.getTypes());

    @FXML
    Button returnToLoginButton;

    @FXML
    Button registerAccountButton;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    PasswordField confirmPasswordField;

    @FXML
    TextField firstNameField;

    @FXML
    TextField lastNameField;

    @FXML
    Label usernameError;

    @FXML
    Label passwordError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        usernameError.setText("");
        passwordError.setText("");
    }

    public ClientRegistrationController()
    {
        ClientEventLog.getInstance().addObserver(this);
    }

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
        if (message instanceof SuccessfulRegistrationMessage)
        {
            swapScene("/edu/saddleback/cs4b/UI/AccountCreationSuccess.fxml", registerAccountButton);
        }
        else if (message instanceof RegistrationErrorMessage)
        {
            Platform.runLater(()-> invalidUsername());
        }
    }

    @FXML
    public void handleRegisterAccountAction()
    {
        String firstName = firstNameField.getText();
        String lastName  = lastNameField.getText();
        String username  = usernameField.getText();
        String password  = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!firstName.equals("") && !lastName.equals("") && !username.equals("") && !password.equals("") && !confirmPassword.equals(""))
        {
            if(password.equals(confirmPassword))
            {
                RegistrationMessage registrationMessage = (RegistrationMessage) factory.createMessage(MsgTypes.REGISTRATION.getType());
                Profile prof = new TTTProfile(username, firstName, lastName, password);
                registrationMessage.setProfile(prof);
                uilog.notifyObservers(new MessageEvent(registrationMessage));
            }
            else
            {
                invalidPassword();
                passwordField.clear();
                confirmPasswordField.clear();
            }
        }
        else
        {

        }
    }

    @FXML
    public void handleReturnToLoginAction()
    {
        swapScene("/edu/saddleback/cs4b/UI/ClientLogin.fxml", returnToLoginButton);
    }

    @FXML
    public void invalidUsername()
    {
        usernameField.setText("");
        usernameError.setText("* Username Already Exists!");
    }

    @FXML
    public void invalidPassword()
    {
        passwordError.setText("");
        passwordError.setText("* Password Does Not Match!");
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

    public void swapScene(String sceneLocation, Button button)
    {
        ClientEventLog.getInstance().removeObserver(this);
        Parent parent = null;
        try
        {
            parent = FXMLLoader.load(getClass().getResource(sceneLocation));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Scene scene  = new Scene(parent);
        Stage window = (Stage)(button).getScene().getWindow();

        Platform.runLater(()->
        {
            window.setScene(scene);
            window.show();
        });
    }
}
