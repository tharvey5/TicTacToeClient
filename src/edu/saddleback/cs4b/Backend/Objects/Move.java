package edu.saddleback.cs4b.Backend.Objects;

import java.time.LocalDateTime;

public interface Move
{
    public String getGameID();
    public void setGameID(String newGameID);

    public String getStartTime();
    public void setStartTime(LocalDateTime time);

    public String getPlayerID();
    public void setPlayerID(String newPlayerID);

    public Coordinate getCoordinate();
    public void setCoordinate(Coordinate newCoordinate);
}
