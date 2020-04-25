package edu.saddleback.cs4b.Backend.Objects;

import java.time.LocalDateTime;

public class TTTMove implements Move
{
    private String gameID;
    private String playerID;
    private Coordinate coordinate;
    private LocalDateTime moveTime;



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
    public LocalDateTime getStartTime()
    {
        return moveTime;
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
