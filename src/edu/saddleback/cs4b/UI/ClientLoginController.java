package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.ClientPackage.ClientUser;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.EventType;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.Utilitys.TTTUser;
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

public class ClientLoginController implements Observer, Initializable
{
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.ADMIN_FACT.getTypes());

    @FXML
    Button loginButton;

    @FXML
    Button createAccountButton;

    @FXML
    Button forgotPasswordButton;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    Label passwordError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        passwordError.setText("");
    }

    public ClientLoginController()
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
        if(message instanceof AuthenticatedMessage)
        {
            AuthenticatedMessage msg = (AuthenticatedMessage) message;
            ClientUser.setInstance(msg.getAuthUser());

            swapHome("/edu/saddleback/cs4b/UI/ClientHome.fxml", loginButton);
        }
        else if(message instanceof DeniedEntryMessage)
        {
            Platform.runLater(()->
            {
                invalidUsernameOrPassword();
            });
        }
    }

    @FXML
    public void handleLoginAction()
    {
        String userName = usernameField.getText();
        String password = passwordField.getText();
        if(!userName.equals("") && !password.equals(""))
        {
            SignInMessage signIn = (SignInMessage) factory.createMessage(MsgTypes.SIGN_IN.getType());
            signIn.setUserInfo(new TTTUser(userName, password));
            uilog.notifyObservers(new MessageEvent(signIn));
        }
    }

    public void handleForgotPasswordAction()
    {
        swapScene("/edu/saddleback/cs4b/UI/ForgotPassword.fxml", forgotPasswordButton);
    }

    @FXML
    public void handleCreateAccountAction()
    {
        swapScene("/edu/saddleback/cs4b/UI/ClientRegistration.fxml", createAccountButton);
    }

    @FXML
    public void invalidUsernameOrPassword()
    {
        passwordField.setText("");
        passwordError.setText("* Invalid Username or Password");

    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'LOGIN' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightLogin()
    {
        loginButton.setOnMouseEntered(mouseEvent -> loginButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'LOGIN' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetLogin()
    {
        loginButton.setOnMouseExited(mouseEvent -> loginButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CREATE ACCOUNT' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightCreateAccount()
    {
        createAccountButton.setOnMouseEntered(mouseEvent -> createAccountButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'CREATE ACCOUNT' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetCreateAccount()
    {
        createAccountButton.setOnMouseExited(mouseEvent -> createAccountButton.setTextFill(Color.WHITE));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'FORGOT PASSWORD?' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightForgotPassword()
    {
        forgotPasswordButton.setOnMouseEntered(mouseEvent -> forgotPasswordButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'FORGOT PASSWORD?' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetForgotPassword()
    {
        forgotPasswordButton.setOnMouseExited(mouseEvent -> forgotPasswordButton.setTextFill(Color.valueOf("#0099FF")));
    }

    public void swapHome(String sceneLocation, Button button) throws IOException
    {
        ClientEventLog.getInstance().removeObserver(this);

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
}
