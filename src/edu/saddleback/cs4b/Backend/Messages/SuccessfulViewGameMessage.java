package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Game;

public class SuccessfulViewGameMessage extends BaseMessage
{
    private Game game;

    public SuccessfulViewGameMessage()
    {
        this(null);
    }

    public SuccessfulViewGameMessage(Game game)
    {
        super(MsgTypes.SUCCESS_VIEW_GAME);
        this.game = game;
    }

    public String getGameID()
    {
        return game.getGameID();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() { return game; }
}
