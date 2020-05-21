package edu.saddleback.cs4b.Backend.Utilitys;

import edu.saddleback.cs4b.Backend.Objects.Game;

import java.util.List;

public interface GameRecord
{
    public List<Game> getGameRecord();
    public void setGameRecord(List<Game> newGameRecord);
    void setTotalGames(int total);

    public int  getNumGames();
    public void addGame(Game newGame);

    public int  getWins();
    public void setWins(int newWins);

    public int  getLosses();
    public void setLosses(int newLosses);

    public int  getTies();
}
