package edu.saddleback.cs4b.Backend.Messages;

public class SuccessfulSetTokenMessage extends BaseMessage
{
    public SuccessfulSetTokenMessage()
    {
        super(MsgTypes.SUCCESS_SET_TOKEN);
    }
}
