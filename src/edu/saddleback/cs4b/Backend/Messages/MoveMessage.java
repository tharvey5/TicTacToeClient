package edu.saddleback.cs4b.Backend.Messages;

public class MoveMessage extends BaseMessage
{
    TTTPosition coordinate;

    public MoveMessage(TTTPosition newCoordinate)
    {
        super(MsgTypes.MOVE);

        coordinate = newCoordinate;
    }

    public TTTPosition getCoordinate()
    {
        return coordinate;
    }
}
