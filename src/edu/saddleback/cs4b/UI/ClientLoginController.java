package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.*;
import edu.saddleback.cs4b.Backend.Utilitys.TTTUser;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * We will need to have andrew call the instance of this class via the
 * FXML loader so that he can log this instance of an observer AND
 * so we can log his classes as our observer
 */
public class ClientLoginController implements Observer
{
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.ADMIN_FACT.getTypes());

    @FXML
    Button loginButton;

    @FXML
    Button createAccountButton;

    @FXML
    TextField userField;

    @FXML
    TextField passwordField;

    public ClientLoginController() {
        ClientEventLog.getInstance().addObserver(this);
    }

    /**
     * This method gets called by the ClientSubjects
     */
    @Override
    public void update(SystemEvent e)
    {
        if (e.getEvent().getType().equals(EventType.MESSAGE_EVENT.getType())) {
            BaseMessage message = ((MessageEvent)e.getEvent()).getMessage();
            handleMessageEvents(message);
        }
    }

    private void handleMessageEvents(BaseMessage message) {
        if (message instanceof AuthenticatedMessage) {
            swapToHome();
        } else if (message instanceof DeniedEntryMessage) {
            // show some notification
            Platform.runLater(()-> {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Username/password");
                alert.show();
            });
        }
    }


    /**
     * WHEN THIS METHOD IS CALLED THE 'LOGIN' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightLogin()
    {
        loginButton.setOnMouseEntered(mouseEvent -> loginButton.setTextFill(Color.YELLOW));
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
        createAccountButton.setOnMouseEntered(mouseEvent -> createAccountButton.setTextFill(Color.YELLOW));
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

    @FXML
    public void handleLoginAction(ActionEvent event) throws IOException
    {
        String userName = userField.getText();
        String password = passwordField.getText();
        if (!userName.equals("") && !password.equals("")) {
            SignInMessage signIn = (SignInMessage) factory.createMessage(MsgTypes.SIGN_IN.getType());
            signIn.setUserInfo(new TTTUser(userName, password));
            uilog.notifyObservers(new MessageEvent(signIn));

            //swapToHome();  ** uncomment to test and recomment when running with server **
        }
    }

    public void swapToHome()
    {
        swapScene("/edu/saddleback/cs4b/UI/ClientHomeScreen.fxml");
    }

    @FXML
    public void handleCreateAccountAction(ActionEvent event)
    {
        swapScene("/edu/saddleback/cs4b/UI/ClientRegistration.fxml");
    }

    public void swapScene(String sceneLocation)
    {
        Parent parent = null;
        ClientEventLog.getInstance().removeObserver(this);
        try {
            parent = FXMLLoader.load(getClass().getResource(sceneLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene  = new Scene(parent);
        // This line gets the Stage information since loginButton and Register have same scene
        Stage window = (Stage)(loginButton).getScene().getWindow();

        Platform.runLater(()->{
            window.setScene(scene);
            window.show();
        });

    }
}
