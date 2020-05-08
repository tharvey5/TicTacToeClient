package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Game;

public class ReturnSingleGameMessage extends BaseMessage {
    private Game game;

    public ReturnSingleGameMessage() {
        this (null);
    }

    public ReturnSingleGameMessage(Game game) {
        super (null);
        setGame(game);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
