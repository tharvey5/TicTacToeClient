package edu.saddleback.cs4b.Backend.Utilitys;

import edu.saddleback.cs4b.Backend.Objects.Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TTTGameRecord implements GameRecord, Serializable
{
    List<Game> gameRecord;
    int wins;
    int losses;

    public TTTGameRecord()
    {
        this(new ArrayList<>(), 0, 0);
    }

    public TTTGameRecord(List<Game> newGames, int newWins, int newLosses)
    {
        gameRecord = newGames;
        wins = newWins;
        losses = newLosses;
    }
    @Override
    public List<Game> getGameRecord()
    {
        return gameRecord;
    }
    @Override
    public void setGameRecord(List<Game> newGameRecord)
    {
        gameRecord = newGameRecord;
    }
    @Override
    public int  getNumGames()
    {
        return gameRecord.size();
    }
    @Override
    public void addGame(Game newGame)
    {
        gameRecord.add(newGame);
    }
    @Override
    public int  getWins()
    {
        return wins;
    }
    @Override
    public void setWins(int newWins)
    {
        wins = newWins;
    }
    @Override
    public int  getLosses()
    {
        return losses;
    }
    @Override
    public void setLosses(int newLosses)
    {
        losses = newLosses;
    }
    @Override
    public int  getTies()
    {
        int total = getNumGames();
        return total - wins - losses;
    }
}
