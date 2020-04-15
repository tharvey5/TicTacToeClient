package edu.saddleback.cs4b.Backend.Messages;

public class MoveMessage extends BaseMessage
{
    Coordinate coordinate;

    public MoveMessage(Coordinate newCoordinate)
    {
        super(MsgTypes.MOVE);

        coordinate = newCoordinate;
    }

    public Coordinate getCoordinate()
    {
        return coordinate;
    }
}
