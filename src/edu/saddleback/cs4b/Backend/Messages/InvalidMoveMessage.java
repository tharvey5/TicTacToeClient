package edu.saddleback.cs4b.Backend.Messages;

import java.io.InputStreamReader;

public class InvalidMoveMessage extends BaseMessage {
    public InvalidMoveMessage()
    {
        super(MsgTypes.INVALID_MOVE);
    }
}
