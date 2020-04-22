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
        super(MsgTypes.SUCCESSFUL_VIEW_GAME);

    }
}
