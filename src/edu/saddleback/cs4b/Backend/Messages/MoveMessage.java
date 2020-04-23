package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Coordinate;

public class MoveMessage extends BaseMessage
{
    Coordinate coordinate;

    public MoveMessage()
    {
        this(null);
    }

    public MoveMessage(Coordinate newCoordinate)
    {
        super(MsgTypes.MOVE);

        coordinate = newCoordinate;
    }

    public Coordinate getCoordinate()
    {
        return coordinate;
    }

    public void setCoordinate(Coordinate newCoord)
    {
        coordinate = newCoord;
    }
}
