package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Game;

import java.util.ArrayList;
import java.util.List;

public class ReturnAllCompletedGamesMessage extends BaseMessage {
    private List<Game> games;

    public ReturnAllCompletedGamesMessage() {
        this (new ArrayList<>());
    }

    public ReturnAllCompletedGamesMessage(List<Game> games) {
        super (null);
        this.games = games;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        if (games != null) {
            this.games = games;
        }
    }
}
