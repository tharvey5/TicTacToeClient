package edu.saddleback.cs4b.Backend.Messages;

public class SuccessfulUpdateProfileMessage extends BaseMessage
{
    public SuccessfulUpdateProfileMessage()
    {
        super(MsgTypes.SUCCESS_UPDATE_PROFILE);
    }
}
