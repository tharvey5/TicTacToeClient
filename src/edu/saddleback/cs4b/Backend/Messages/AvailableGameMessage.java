package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Game;

public class AvailableGameMessage extends BaseMessage
{
    private Game game;

    public AvailableGameMessage()
    {
        this(null);
    }

    public AvailableGameMessage(Game newGame)
    {
        super(MsgTypes.AVAILABLE_GAME);
        game = newGame;
    }

    public Game getGame()
    {
        return game;
    }

    public void setGame(Game newGame)
    {
        this.game = newGame;
    }
}
