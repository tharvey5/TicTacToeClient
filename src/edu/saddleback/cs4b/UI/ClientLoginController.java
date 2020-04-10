package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.Messages.AuthenticatedMessage;
import edu.saddleback.cs4b.Backend.Messages.BaseMessage;
import edu.saddleback.cs4b.Backend.Messages.DeniedEntryMessage;
import edu.saddleback.cs4b.Backend.Messages.MsgTypes;
import edu.saddleback.cs4b.Backend.PubSub.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ClientLoginController implements UISubject, Observer
{
    private List<UIObserver> uiObservers;
    boolean validLogin = false;

    @FXML
    Button loginButton;

    @FXML
    Button createAccountButton;


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
            validLogin = true;
        } else if (message instanceof DeniedEntryMessage) {
            validLogin = false;
        }
    }

    /**
     * These methods are used for the UISubject
     */
    @Override
    public void addObserver(UIObserver o)
    {
        uiObservers.add(o);
    }

    /**
     * These methods are used for the UISubject
     */
    @Override
    public void removeObserver(UIObserver o)
    {
        uiObservers.remove(o);
    }

    /**
     * These methods are used for the UISubject
     */
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
        Parent parent = FXMLLoader.load(getClass().getResource("/edu/saddleback/cs4b/UI/ClientHomeScreen.fxml"));
        Scene scene  = new Scene(parent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void handleCreateAccountAction(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(getClass().getResource("/edu/saddleback/cs4b/UI/ClientRegistration.fxml"));
        Scene scene  = new Scene(parent);

        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }


}
