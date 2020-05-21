package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Coordinate;

public class MoveMessage extends BaseMessage
{
    private Coordinate coordinate;
    private String gameId;

    public MoveMessage()
    {
        this(null, null);
    }

    public MoveMessage(Coordinate newCoordinate, String gameId)
    {
        super(MsgTypes.MOVE);

        coordinate = newCoordinate;
        this.gameId = gameId;
    }

    public Coordinate getCoordinate()
    {
        return coordinate;
    }

    public void setCoordinate(Coordinate newCoord)
    {
        coordinate = newCoord;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
