package edu.saddleback.cs4b.Backend.Messages;

public class InvalidProfileUpdateMessage extends BaseMessage
{
    public InvalidProfileUpdateMessage()
    {
        super(MsgTypes.INVALID_PROFILE_UPDATE);
    }
}
