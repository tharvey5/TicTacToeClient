package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Move;

import java.util.List;

public class RespondMovesMessage extends BaseMessage {
    private List<Move> moves;

    public RespondMovesMessage() {
        this (null);
    }

    public RespondMovesMessage(List<Move> moves) {
        super(null);
        setMoves(moves);
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}
