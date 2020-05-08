package edu.saddleback.cs4b.Backend.Objects;

import java.io.Serializable;
import java.util.List;

public class DatabaseMoves implements Moves, Serializable {
    private List<Move> moves;

    public DatabaseMoves(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return moves.toString();
    }

    @Override
    public void setMoves(List<Move> newMoves) {
        moves = newMoves;
    }

    @Override
    public void addMove(Move newMove) {
        moves.add(newMove);
    }
}
