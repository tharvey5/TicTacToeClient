package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Game;

public class GameSuccessfullyCreatedMessage extends BaseMessage
{
    private Game game;

    public GameSuccessfullyCreatedMessage()
    {
        this(null);
    }

    public GameSuccessfullyCreatedMessage(Game newGame)
    {
        super(MsgTypes.GAME_CREATED);
        game = newGame;
    }

    public String getGameId()
    {
        return game.getGameID();
    }

    public void setGame(Game newGame)
    {
        game = newGame;
    }
}
