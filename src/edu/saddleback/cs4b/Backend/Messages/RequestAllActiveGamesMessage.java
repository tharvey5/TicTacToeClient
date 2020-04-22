package edu.saddleback.cs4b.Backend.Messages;

public class RequestAllActiveGamesMessage extends BaseMessage
{
    public RequestAllActiveGamesMessage()
    {
        super(MsgTypes.REQUEST_ALL_GAMES);
    }
}
