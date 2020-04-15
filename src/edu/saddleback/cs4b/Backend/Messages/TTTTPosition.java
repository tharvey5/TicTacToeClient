package edu.saddleback.cs4b.Backend.Messages;

public class TTTTPosition implements Coordinate
{
    private int xCoord;
    private int yCoord;

    public TTTTPosition()
    {
        this(0,0);
    }
    public TTTTPosition(int newX, int newY)
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
