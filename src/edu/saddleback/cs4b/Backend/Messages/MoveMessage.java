package edu.saddleback.cs4b.Backend.Messages;

public class MoveMessage extends BaseMessage
{
    TTTPosition coordinate;

    public MoveMessage()
    {
        this(null);
    }

    public MoveMessage(TTTPosition newCoordinate)
    {
        super(MsgTypes.MOVE);

        coordinate = newCoordinate;
    }

    public TTTPosition getCoordinate()
    {
        return coordinate;
    }

    public void setCoordinate(TTTPosition newCoord)
    {
        coordinate = newCoord;
    }
}
