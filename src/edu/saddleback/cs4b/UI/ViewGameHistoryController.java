package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.ClientPackage.ClientEventLog;
import edu.saddleback.cs4b.Backend.ClientPackage.ClientUser;
import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.Objects.*;
import edu.saddleback.cs4b.Backend.PubSub.EventType;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.Utilitys.PublicUser;
import edu.saddleback.cs4b.Backend.Utilitys.TTTProfile;
import edu.saddleback.cs4b.Backend.Utilitys.User;
import edu.saddleback.cs4b.UI.Util.GameInfo;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewGameHistoryController implements Observer, Initializable
{

    private User user = ClientUser.getInstanceOf();
    private TTTProfile profile = (TTTProfile)ClientUser.getProfile();
    private UIEventLog uilog = UIEventLog.getInstance();
    private AbstractMessageFactory factory = MessageFactoryProducer.getFactory(FactoryTypes.GAME_FACT.getTypes());

    @FXML
    Button refreshBtn;

    @FXML
    Button returnToProfileBtn;

    @FXML
    TableView<GameInfo> gameInfoTable;

    @FXML
    TableColumn<GameInfo, String> idCol;

    @FXML
    TableColumn<GameInfo, String> startTimeCol;

    @FXML
    TableColumn<GameInfo, String> endTimeCol;

    @FXML
    TableColumn<GameInfo, String> hostCol;

    @FXML
    TableColumn<GameInfo, String> opponentCol;

    @FXML
    TableColumn<GameInfo, String> resultCol;

    @FXML
    TableView<TTTPosition> detailsTable;

    @FXML
    TableColumn<TTTPosition, Integer> movesCol;

    @FXML
    TableColumn<GameInfo, List<PublicUser>> viewersCol;

    private ObservableList<GameInfo> infoList = FXCollections.observableArrayList();
    private ObservableList<TTTPosition> coordList = FXCollections.observableArrayList();

    public ViewGameHistoryController()
    {
        ClientEventLog.getInstance().addObserver(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        startTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endTimeCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        hostCol.setCellValueFactory(new PropertyValueFactory<>("host"));
        opponentCol.setCellValueFactory(new PropertyValueFactory<>("opponent"));
        resultCol.setCellValueFactory(new PropertyValueFactory<>("result"));

        movesCol.setCellValueFactory(new PropertyValueFactory<>("positionAsString"));
        //viewersCol.setCellValueFactory(new PropertyValueFactory<>("viewers"));
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

    public void displayToUI(List<Game> games)
    {
        for (Game g : games) {
            GameInfo info = new GameInfo();

            info.setId(g.getGameID());
            info.setStartTime(g.getStartTime());
            info.setEndTime(g.getEndTime());
            info.setHost(g.getCreator().getUsername());
            info.setOpponent(g.getOtherPlayer().getUsername());
            info.setResult(g.getWinner() == null ? "tie" : g.getWinner().getUsername());
            info.setViewers(g.viewers());
            infoList.add(info);
        }
        gameInfoTable.setItems(infoList);
    }

    private void handleMessageEvents(BaseMessage message) throws IOException
    {
        if (message instanceof GameHistoryResponseMessage)
        {
            System.out.println("games");
            List<Game> games = ((GameHistoryResponseMessage) message).getGames();
            displayToUI(games);
        }
        else if (message instanceof RespondMovesMessage)
        {
            detailsTable.getItems().clear();
            List<Move> moves = ((RespondMovesMessage) message).getMoves();
            System.out.println(moves.size());
            for (Move m : moves)
            {
                coordList.add((TTTPosition)m.getCoordinate());
            }
            detailsTable.setItems(coordList);
        }
    }

    @FXML
    public void handleRefreshAction()
    {
        gameInfoTable.getItems().clear();
        GameHistoryRequestMessage requestMessage = (GameHistoryRequestMessage) factory.createMessage(MsgTypes.GAME_HISTORY_REQUEST.getType());
        uilog.notifyObservers(new MessageEvent(requestMessage));
    }

    @FXML
    public void handleReturnToProfileAction() throws IOException
    {
        swapHomeProfile("/edu/saddleback/cs4b/UI/ClientHome.fxml", returnToProfileBtn);
    }

    @FXML
    public void onRowClicked()
    {
        if(gameInfoTable.getSelectionModel().getSelectedItem() != null)
        {
            RequestMovesOfGameMessage reqMsg = new RequestMovesOfGameMessage();
            reqMsg.setGameId(gameInfoTable.getSelectionModel().getSelectedItem().getId());
            uilog.notifyObservers(new MessageEvent(reqMsg));
        }
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'RETURN TO PROFILE' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightReturnToProfile()
    {
        returnToProfileBtn.setOnMouseEntered(mouseEvent -> returnToProfileBtn.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'RETURN TO PROFILE' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetReturnToProfile()
    {
        returnToProfileBtn.setOnMouseExited(mouseEvent -> returnToProfileBtn.setTextFill(Color.BLACK));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'REFRESH' BUTTON WILL CHANGE COLOR WHEN THE MOUSE IS HOVERING OVER IT
     */
    @FXML
    public void highlightRefresh()
    {
        returnToProfileBtn.setOnMouseEntered(mouseEvent -> returnToProfileBtn.setTextFill(Color.valueOf("#FFD700")));
    }

    /**
     * WHEN THIS METHOD IS CALLED THE 'REFRESH' BUTTON WILL CHANGE BACK TO THE DEFAULT TEXT COLOR WHEN THE MOUSE IS
     * NO LONGER HOVERING OVER IT
     */
    @FXML
    public void resetRefresh()
    {
        returnToProfileBtn.setOnMouseExited(mouseEvent -> returnToProfileBtn.setTextFill(Color.BLACK));
    }

    public void swapHomeProfile(String sceneLocation, Button button) throws IOException
    {
        ClientEventLog.getInstance().removeObserver(this);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneLocation));
        Parent root = loader.load();
        Scene scene  = new Scene(root);
        Stage window = (Stage)(button).getScene().getWindow();

        ClientHomeController crtl = loader.getController();
        crtl.handleProfileAction();

        Platform.runLater(()->
        {
            window.setScene(scene);
            window.show();
        });
    }
}
