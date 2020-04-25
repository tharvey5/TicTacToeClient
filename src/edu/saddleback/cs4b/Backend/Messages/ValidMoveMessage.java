package edu.saddleback.cs4b.Backend.Messages;

public class ValidMoveMessage extends BaseMessage
{
    public ValidMoveMessage()
    {
        super(MsgTypes.VALID_MOVE);
    }
}
