package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientRegistrationController implements UISubject, Observer
{
    private List<UIObserver> uiObservers = new ArrayList<>();
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
            // call the
        }
    }

    /**
     * The following will be called by this UI
     */
    @Override
    public void addObserver(UIObserver o)
    {
        uiObservers.add(o);
    }

    @Override
    public void removeObserver(UIObserver o)
    {
        uiObservers.remove(o);
    }

    @Override
    public void notifyObservers(SystemEvent e)
    {
        Iterator<UIObserver> iterator = uiObservers.iterator();
        while (iterator.hasNext())
        {
            iterator.next().update(e);
        }
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'RETURN TO LOGIN' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightReturnToLogin()
    {
        returnToLoginButton.setOnMouseEntered(mouseEvent -> returnToLoginButton.setTextFill(Color.YELLOW));
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
        registerAccountButton.setOnMouseEntered(mouseEvent -> registerAccountButton.setTextFill(Color.YELLOW));
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
        //swapScene("/edu/saddleback/cs4b/UI/AccountCreationSuccessScreen.fxml");
    }

    public void showSuccessfulRegistration() {
        swapScene("/edu/saddleback/cs4b/UI/AccountCreationSuccessScreen.fxml");
    }

    public void swapScene(String sceneLocation)
    {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource(sceneLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene  = new Scene(parent);
        Stage window = (Stage)(returnToLoginButton).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
