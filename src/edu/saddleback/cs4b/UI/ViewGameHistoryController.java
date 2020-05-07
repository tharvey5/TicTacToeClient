package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.ClientPackage.ClientUser;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.Objects.Game;
import edu.saddleback.cs4b.Backend.PubSub.EventType;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.Utilitys.TTTProfile;
import edu.saddleback.cs4b.Backend.Utilitys.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewGameHistoryController implements Observer, Initializable {

    private User user = ClientUser.getInstanceOf();
    private TTTProfile profile = (TTTProfile)ClientUser.getProfile();
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.GAME_FACT.getTypes());


    @FXML
    Button refreshBtn;

    public ViewGameHistoryController() { ClientEventLog.getInstance().addObserver(this); }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void update(SystemEvent e) {
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
        if (message instanceof GameHistoryResponseMessage) {
            List<Game> games = ((GameHistoryResponseMessage) message).getGames();
        }
    }

    @FXML
    public void handleRefreshAction() {
        GameHistoryRequestMessage requestMessage = (GameHistoryRequestMessage) factory.createMessage(MsgTypes.GAME_HISTORY_REQUEST.getType());
        uilog.notifyObservers(new MessageEvent(requestMessage));
    }


}
