package edu.saddleback.cs4b.Backend.Objects;

import java.io.Serializable;

public class TTTBoard implements Board, Serializable
{
    private final int ROW_SIZE = 3;
    private final int COL_SIZE = 3;
    private Token[][] board;

    public TTTBoard()
    {
        board = new Token[ROW_SIZE][COL_SIZE];
    }

    @Override
    public Token getToken(int r, int c)
    {
        return board[r][c];
    }
    @Override
    public Board getBoard() {
        return this;
    }
    @Override
    public int rows() {
        return board.length;
    }
    @Override
    public int cols() {
        return board[0].length;
    }
    @Override
    public void setToken(int r, int c, Token token)
    {
        board[r][c] = token;
    }
    @Override
    public void setToken(Coordinate coordinate, Token token)
    {
        int x = coordinate.getXCoord();
        int y = coordinate.getYCoord();

        setToken(x, y, token);
    }
}
