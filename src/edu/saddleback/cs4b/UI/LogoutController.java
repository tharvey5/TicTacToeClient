package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.EventType;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.Utilitys.TTTUser;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LogoutController implements Observer
{
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.ADMIN_FACT.getTypes());

    @FXML
    Button yesButton;

    @FXML
    Button noButton;

    public LogoutController()
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
        if(message instanceof SignOutMessage)
        {
            swapSceneYes("/edu/saddleback/cs4b/UI/ClientLogin.fxml", yesButton);
        }
    }

    @FXML
    public void handleYesAction()
    {
        SignOutMessage signOut = (SignOutMessage) factory.createMessage(MsgTypes.SIGN_OUT.getType());
        uilog.notifyObservers(new MessageEvent(signOut));
    }

    @FXML
    public void handleNoAction() throws IOException
    {
        swapSceneNo("/edu/saddleback/cs4b/UI/ClientHome.fxml", noButton);
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'YES' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightYes()
    {
        yesButton.setOnMouseEntered(mouseEvent -> yesButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'YES' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetYes()
    {
        yesButton.setOnMouseExited(mouseEvent -> yesButton.setTextFill(Color.BLACK));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'NO' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightNo()
    {
        noButton.setOnMouseEntered(mouseEvent -> noButton.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'NO' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetNo()
    {
        noButton.setOnMouseExited(mouseEvent -> noButton.setTextFill(Color.BLACK));
    }



    public void swapSceneYes(String sceneLocation, Button button) throws IOException
    {
        ClientEventLog.getInstance().removeObserver(this);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneLocation));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        // This line gets the Stage information since loginButton and Register have same scene
        Stage window = (Stage) (button).getScene().getWindow();

        Platform.runLater(() ->
        {
            window.setScene(scene);
            window.show();
        });
    }

    public void swapSceneNo(String sceneLocation, Button button) throws IOException
    {
        ClientEventLog.getInstance().removeObserver(this);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneLocation));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage window = (Stage) (button).getScene().getWindow();

        ClientHomeController crtl = loader.getController();
        crtl.handleMainMenuAction();

        Platform.runLater(() ->
        {
            window.setScene(scene);
            window.show();
        });
    }

}
