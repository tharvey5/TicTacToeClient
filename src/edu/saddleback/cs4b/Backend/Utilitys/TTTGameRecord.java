package edu.saddleback.cs4b.Backend.Utilitys;

import edu.saddleback.cs4b.Backend.Objects.Game;

import java.io.Serializable;
import java.util.List;

public class TTTGameRecord implements GameRecord, Serializable
{
    List<Game> gameRecord;
    int wins;
    int losses;

    CONSTRUCTORS!!!!!!!!











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
