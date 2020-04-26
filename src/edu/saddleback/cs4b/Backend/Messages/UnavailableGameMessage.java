package edu.saddleback.cs4b.Backend.Messages;

public class UnavailableGameMessage extends BaseMessage
{
    public UnavailableGameMessage()
    {
        super(MsgTypes.UNAVAILABLE_GAME);
    }
}
