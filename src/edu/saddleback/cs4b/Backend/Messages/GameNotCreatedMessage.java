package edu.saddleback.cs4b.Backend.Messages;

public class GameNotCreatedMessage extends BaseMessage
{
    public GameNotCreatedMessage()
    {
        super(MsgTypes.GAME_NOT_CREATED);
    }
}
