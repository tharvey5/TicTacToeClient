package edu.saddleback.cs4b.Backend.Messages;

public class RequestGameHistoryMessage extends BaseMessage {

    RequestGameHistoryMessage()
    {
        super(MsgTypes.REQUEST_GAME_HISTORY);
    }
}
