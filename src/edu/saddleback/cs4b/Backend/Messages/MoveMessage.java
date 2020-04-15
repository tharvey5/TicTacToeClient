package edu.saddleback.cs4b.Backend.Messages;

public class MoveMessage extends BaseMessage
{
    TTTTPosition coordinate;

    public MoveMessage(TTTTPosition newCoordinate)
    {
        super(MsgTypes.MOVE);

        coordinate = newCoordinate;
    }

    public TTTTPosition getCoordinate()
    {
        return coordinate;
    }
}
