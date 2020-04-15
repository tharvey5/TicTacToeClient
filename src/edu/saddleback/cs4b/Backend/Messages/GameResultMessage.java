package edu.saddleback.cs4b.Backend.Messages;

import java.util.ArrayList;
import java.util.List;

public class GameResultMessage extends BaseMessage{
    private WinType winType;
    private String winner;
    private String loser;
    private boolean isTieGame;

    public GameResultMessage()
    {
        this(null, null, null, false);
    }

    public GameResultMessage(WinType newWinType, String newWinner, String newLoser, boolean newIsTieGame)
    {
        super(MsgTypes.GAME_RESULT);

        winType = newWinType;
        winner = newWinner;
        loser = newLoser;
        isTieGame = newIsTieGame;
    }

    public WinType getWinType()
    {
        return winType;
    }

    public String getWinner()
    {
        return winner;
    }

    public String getLoser()
    {
        return loser;
    }

    public List getPlayers()
    {
        ArrayList<String> players = new ArrayList<String>();

        players.add(winner);
        players.add(loser);

        return players;
    }

    public boolean isTieGame()
    {
        return isTieGame;
    }

    public void setWinType(WinType winType) {
        this.winType = winType;
    }

    public void setWinner(String newWinner) {
        winner = newWinner;
    }

    public void setLoser(String newLoser) {
        loser = newLoser;
    }

    public void setTieGame(boolean newTieGame) {
        isTieGame = newTieGame;
    }
}
