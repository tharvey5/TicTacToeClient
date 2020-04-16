package edu.saddleback.cs4b.Backend.Objects;

import java.time.LocalDateTime;
import java.util.List;

public interface Game
{
    public LocalDateTime getStartTime();
    public void setStartTime(LocalDateTime newTime);

    public String getStartPlayer();
    public void setStartPlayer(String newStartPlayer);

    public String getOtherPlayer();
    public void setOtherPlayer(String newOtherPlayer);

    public List<Move> getMoves();
    public void setMoves(List<Move> newMoves);
    public void addMove(Move newMove);

    public String getWinner();

    public String getGameID();
    public void setGameID(String newGameID);

    public Board getGameBoard();
    public void setGameBoard(Board newBoard);

}
