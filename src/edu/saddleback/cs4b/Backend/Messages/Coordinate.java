package edu.saddleback.cs4b.Backend.Messages;

public class Coordinate {
    private int xCoord;
    private int yCoord;

    public Coordinate()
    {

    }
    public Coordinate(int newX, int newY)
    {
        xCoord = newX;
        yCoord = newY;
    }

    public int getXCoord()
    {
        return xCoord;
    }

    public void setXCoord(int newXCoord)
    {
        this.xCoord = xCoord;
    }

    public int getYCoord()
    {
        return yCoord;
    }

    public void setYCoord(int newYCoord)
    {
        this.yCoord = yCoord;
    }
}
