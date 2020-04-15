package edu.saddleback.cs4b.Backend.Messages;

import javax.print.DocFlavor;

public class RequestJoinGameMessage extends BaseMessage{

    RequestJoinGameMessage()
    {
        super(MsgTypes.REQUEST_JOIN_GAME);
    }
}
