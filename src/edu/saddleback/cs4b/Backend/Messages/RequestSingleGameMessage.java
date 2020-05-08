package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Game;

public class RequestSingleGameMessage extends BaseMessage {
    private String gameId;
    private Game game;

    public RequestSingleGameMessage() {
        this (null, "-1");
    }

    public RequestSingleGameMessage(String gameId) {
        this (null, gameId);
    }

    public RequestSingleGameMessage(Game game) {
        this (game, game.getGameID());
    }

    private RequestSingleGameMessage(Game game, String id) {
        super(null);
        setGame(game);
        setGameId(id);
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        if (gameId != null) {
            this.gameId = gameId;
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
