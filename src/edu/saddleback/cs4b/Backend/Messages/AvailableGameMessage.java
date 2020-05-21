package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Game;

public class AvailableGameMessage extends BaseMessage
{
    private Game game;
    private String gameId;

    public AvailableGameMessage()
    {
        this(null, null);
    }

    public AvailableGameMessage(Game newGame)
    {
        super(MsgTypes.AVAILABLE_GAME);
        game = newGame;
    }

    public AvailableGameMessage(Game game, String gameId) {
        super(MsgTypes.AVAILABLE_GAME);
        setGame(game);
        setGameId(gameId);
    }

    public AvailableGameMessage(String gameId){
        this(null, gameId);
    }

    public void setGameId(String gameId) { this.gameId = gameId; }
    public String getGameId() { return gameId; }

    public Game getGame()
    {
        return game;
    }

    public void setGame(Game newGame)
    {
        this.game = newGame;
    }
}
