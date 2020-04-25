package edu.saddleback.cs4b.Backend.Objects;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TTTMove implements Move, Serializable
{
    private String gameID;
    private String playerID;
    private Coordinate coordinate;
    private LocalDateTime moveTime;

    public TTTMove()
    {
        this(null, null, null);
    }

    public TTTMove(String newGameID, String newPlayerID, Coordinate newCoordinate)
    {
        gameID = newGameID;
        playerID = newPlayerID;
        coordinate = newCoordinate;
        moveTime   = LocalDateTime.now();
    }
    public TTTMove(String newGameID, String newPlayerID, int newX, int newY)
    {
        this(newGameID, newPlayerID, new TTTPosition(newX, newY));
    }
    public void setMoveTimeAsNow()
    {
        moveTime   = LocalDateTime.now();
    }

    @Override
    public String getGameID()
    {
        return gameID;
    }
    @Override
    public void setGameID(String newGameID)
    {
        gameID = newGameID;
    }
    @Override
    public String getStartTime()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(Integer.toString(moveTime.getHour()));
        sb.append(":");
        sb.append(Integer.toString(moveTime.getMinute()));

        return sb.toString();
    }
    @Override
    public void setStartTime(LocalDateTime time)
    {
        moveTime = time;
    }
    @Override
    public String getPlayerID()
    {
        return playerID;
    }
    @Override
    public void setPlayerID(String newPlayerID)
    {
        playerID = newPlayerID;
    }
    @Override
    public Coordinate getCoordinate()
    {
        return coordinate;
    }
    @Override
    public void setCoordinate(Coordinate newCoordinate)
    {
        coordinate = newCoordinate;
    }
}
