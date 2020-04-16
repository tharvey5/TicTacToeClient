package edu.saddleback.cs4b.Backend.Objects;

public interface Board
{
    public void setMove(Move newMove);

    //doesn't make sense to make sense to arbitrary get a move, should have a location, or a move ID or something
    public Move getMove(Coordinate moveToGet);
    public Move getMove(String moveID);
}
