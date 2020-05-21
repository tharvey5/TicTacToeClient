package edu.saddleback.cs4b.Backend.Objects;

import java.util.List;

public interface GameHistory {
    public List<Game> returnGames();
    public void setGames(List<Game> newGames);
    public void addGame(Game newGame);

}
