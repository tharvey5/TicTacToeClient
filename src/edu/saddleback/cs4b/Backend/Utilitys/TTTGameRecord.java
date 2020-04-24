package edu.saddleback.cs4b.Backend.Utilitys;

import edu.saddleback.cs4b.Backend.Objects.Game;

import java.io.Serializable;
import java.util.List;

public class TTTGameRecord implements GameRecord, Serializable
{
    List<Game> gameRecord;
    int wins;
    int losses;

    public TTTGameRecord()
    {
        this(null, 0, 0);
    }

    public TTTGameRecord(List<Game> newGames, int newWins, int newLosses)
    {
        gameRecord = newGames;
        wins = newWins;
        losses = newLosses;
    }

    public List<Game> getGameRecord()
    {
        return gameRecord;
    }
    public void setGameRecord(List<Game> newGameRecord)
    {
        gameRecord = newGameRecord;
    }
    public int  getNumGames()
    {
        return gameRecord.size();
    }
    public void addGame(Game newGame)
    {
        gameRecord.add(newGame);
    }
    public int  getWins()
    {
        return wins;
    }
    public void setWins(int newWins)
    {
        wins = newWins;
    }
    public int  getLosses()
    {
        return losses;
    }
    public void setLosses(int newLosses)
    {
        losses = newLosses;
    }
    public int  getTies()
    {
        int total = getNumGames();
        return total - wins - losses;
    }
}
