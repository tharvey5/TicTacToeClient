package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.EventType;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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

    private void handleMessageEvents(BaseMessage message)
    {
        if(message instanceof AuthenticatedMessage)
        {
            swapScene("/edu/saddleback/cs4b/UI/MainMenu.fxml");
        }
        else if(message instanceof DeniedEntryMessage)
        {

        }
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

    /**
     * WHEN THIS METHOD IS CALLED THE 'YES' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightYes()
    {
        BackgroundFill fill = new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(fill);
        yesButton.setOnMouseEntered(mouseEvent -> yesButton.setBackground(background));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'YES' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetYes()
    {
        BackgroundFill fill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(fill);
        yesButton.setOnMouseExited(mouseEvent -> yesButton.setBackground(background));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'NO' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightNo()
    {
        BackgroundFill fill = new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(fill);
        yesButton.setOnMouseEntered(mouseEvent -> yesButton.setBackground(background));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'NO' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetNo()
    {
        BackgroundFill fill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(fill);
        yesButton.setOnMouseExited(mouseEvent -> yesButton.setBackground(background));
    }

    @FXML
    public void handleYesAction(MouseEvent event)
    {
        swapScene("/edu/saddleback/cs4b/UI/ClientLogin.fxml");
    }

    @FXML
    public void handleNoAction(MouseEvent event)
    {
        swapScene("/edu/saddleback/cs4b/UI/MainMenu.fxml");
    }

    public void swapScene(String sceneLocation)
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
        Stage window = (Stage)(yesButton).getScene().getWindow();

        Platform.runLater(()->
        {
            window.setScene(scene);
            window.show();
        });
    }



}
