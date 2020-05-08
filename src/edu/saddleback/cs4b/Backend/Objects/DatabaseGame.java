package edu.saddleback.cs4b.Backend.Objects;

import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.Subject;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.Utilitys.PublicUser;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class DatabaseGame implements Game, Serializable, Subject
{

    private String startTime;
    private String endTime;
    private PublicUser startPlayer;
    private PublicUser otherPlayer;
    private PublicUser creator;
    private Moves moves;
    private PublicUser winner;
    private String id;
    private List<PublicUser> viewers;

    public DatabaseGame(String startTime, String endTime, PublicUser startPlayer, PublicUser otherPlayer, PublicUser creator, Moves moves, PublicUser winner, String id, List<PublicUser> viewers)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.startPlayer = startPlayer;
        this.otherPlayer = otherPlayer;
        this.creator = creator;
        this.moves = moves;
        this.winner = winner;
        this.id = id;
        this.viewers = viewers;
    }

    public DatabaseGame(String startTime, String endTime, PublicUser startPlayer, PublicUser otherPlayer, PublicUser creator, PublicUser winner, String id, List<PublicUser> viewers) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.startPlayer = startPlayer;
        this.otherPlayer = otherPlayer;
        this.creator = creator;
        this.winner = winner;
        this.id = id;
        this.viewers = viewers;
    }

    @Override
    public void setToken(Token token, PublicUser user) {

    }

    @Override
    public Token getToken(PublicUser user) {
        return null;
    }

    @Override
    public String getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(LocalDateTime newTime) {


    }

    public void dataStartTime(String newTime) {
        startTime = newTime;

    }

    @Override
    public void setEndTime(LocalDateTime endTime) {

    }

    public void dataEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String getEndTime() {
        return this.endTime;
    }

    @Override
    public PublicUser getStartPlayer() {
        return startPlayer;
    }

    @Override
    public void setStartPlayer(PublicUser user) {
        startPlayer = user;
    }

    @Override
    public void setCreator(PublicUser user) {
        creator = user;
    }

    @Override
    public PublicUser getCreator() {
        return creator;
    }

    @Override
    public PublicUser getOtherPlayer() {
        return otherPlayer;
    }

    @Override
    public void setOtherPlayer(PublicUser user) {
        otherPlayer = user;
    }

    @Override
    public Moves getMoves() {
        return moves;
    }

    @Override
    public void setMoves(Moves newMoves) {
        moves = newMoves;
    }

    @Override
    public void addMove(Move newMove) {
        moves.addMove(newMove);
    }

    @Override
    public PublicUser getWinner() {
        return winner;
    }

    @Override
    public void setWinner(PublicUser user) {
        winner = user;
    }

    @Override
    public String getGameID() {
        return id;
    }

    @Override
    public void setGameID(String newGameID) {
        id = newGameID;
    }

    @Override
    public Board getGameBoard() {
        return null;
    }

    @Override
    public void setGameBoard(Board newBoard) {

    }

    @Override
    public List<PublicUser> viewers() {
        return viewers;
    }

    @Override
    public void addViewer(PublicUser user) {
        viewers.add(user);
    }

    @Override
    public boolean playMove(Move move) {
        return false;
    }

    @Override
    public void addObserver(Observer o) {
    }

    @Override
    public void removeObserver(Observer o) {
    }

    @Override
    public void notifyObserver(SystemEvent e) {
    }
}
