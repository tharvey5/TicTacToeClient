package edu.saddleback.cs4b.Backend.Objects;

import java.io.Serializable;

public class TTTBoard implements Board, Serializable
{

    @Override
    public void setToken(int r, int c, Token token) {

    }

    @Override
    public void setToken(Coordinate coordinate, Token token) {

    }

    @Override
    public Board getBoard() {
        return null;
    }

    @Override
    public Token getToken(int r, int c) {
        return null;
    }

    @Override
    public int rows() {
        return 0;
    }

    @Override
    public int cols() {
        return 0;
    }
}
