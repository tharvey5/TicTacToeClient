package edu.saddleback.cs4b.Backend.Messages;


import edu.saddleback.cs4b.Backend.Objects.Game;

import java.util.List;
import java.util.Map;

public class ReturnAllActiveGamesMessage extends BaseMessage
{
    List<Game> games;
    Map<String, List<String>> gameAndPlayers;

    public ReturnAllActiveGamesMessage(List<Game> newGames)
    {
        super(MsgTypes.RETURN_ACTIVE_GAMES);

        games = newGames;
    }
    public ReturnAllActiveGamesMessage()
    {
        this(null);
    }

    public List<Game> getGames()
    {
        return games;
    }
    public Map<String, List<String>> getGameAndPlayers() { return gameAndPlayers; }

    public void setGameAndPlayers(Map<String, List<String>> gameAndPlayers) {
        this.gameAndPlayers = gameAndPlayers; 
    }

    public void setGames(List<Game> newGames)
    {
        games = newGames;
    }
}
