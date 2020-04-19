package edu.saddleback.cs4b.Backend.Objects;

public interface Board
{
    void setToken(int r, int c, Token token);
    void setToken(Coordinate coordinate, Token token);
    Board getBoard();
    Token getToken(int r, int c);
    int rows();
    int cols();
}
