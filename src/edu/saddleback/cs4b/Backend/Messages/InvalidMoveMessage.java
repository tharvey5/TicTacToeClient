package edu.saddleback.cs4b.Backend.Messages;

public class InvalidMoveMessage extends BaseMessage {
    public InvalidMoveMessage()
    {
        super(MsgTypes.INVALID_MOVE);
    }
}
