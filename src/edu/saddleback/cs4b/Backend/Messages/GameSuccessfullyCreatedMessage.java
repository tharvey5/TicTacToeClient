package edu.saddleback.cs4b.Backend.Messages;

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

    public Game getGame()
    {
        return game;
    }

    public void setGame(Game newGame)
    {
        game = newGame;
    }
}
