package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Game;

import java.util.List;

public class GameHistoryResponseMessage extends BaseMessage
{
    List<Game> games;

    public GameHistoryResponseMessage(List<Game> newGames)
    {
        super(MsgTypes.GAME_HISTORY_RESPONSE);

        games = newGames;
    }
    public GameHistoryResponseMessage()
    {
        this(null);
    }

    public List<Game> getGames()
    {
        return games;
    }

    public void setGames(List<Game> newGames)
    {
        games = newGames;
    }
}
