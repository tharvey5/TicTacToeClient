package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Game;

import java.util.List;

public class GameSuccessfullyCreatedMessage extends BaseMessage
{
    private Game game;
    private String gameId;

    public GameSuccessfullyCreatedMessage()
    {
        this(null, null);
    }

    public GameSuccessfullyCreatedMessage(Game newGame)
    {
        this(newGame, newGame.getGameID());
    }

    public GameSuccessfullyCreatedMessage(String gameId) {
        this(null, gameId);
    }

    public GameSuccessfullyCreatedMessage(Game game, String gameId) {
        super(MsgTypes.GAME_CREATED);
        this.game = game;
        this.gameId = gameId;
    }

    public String getGameId()
    {
        return gameId;
    }
    public void setGameId(String gameId) { this.gameId = gameId; }

    public void setGame(Game newGame)
    {
        game = newGame;
    }
    public Game getGame() { return game; }
}
