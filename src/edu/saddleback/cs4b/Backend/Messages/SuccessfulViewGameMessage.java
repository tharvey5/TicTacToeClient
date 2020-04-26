package edu.saddleback.cs4b.Backend.Messages;

public class SuccessfulViewGameMessage extends BaseMessage
{
    String gameID;

    public SuccessfulViewGameMessage()
    {
        this(null);
    }

    public SuccessfulViewGameMessage(String newGameID)
    {
        super(MsgTypes.SUCCESS_VIEW_GAME);
        gameID = newGameID;
    }

    public String getGameID()
    {
        return gameID;
    }

    public void setGameID(String newGameID)
    {
        this.gameID = newGameID;
    }
}
