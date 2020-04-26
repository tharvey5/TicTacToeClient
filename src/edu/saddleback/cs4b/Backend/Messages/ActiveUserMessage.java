package edu.saddleback.cs4b.Backend.Messages;

public class ActiveUserMessage extends BaseMessage
{
    public ActiveUserMessage()
    {
        super(MsgTypes.ACTIVE_USER_RESPONSE);
    }
}
