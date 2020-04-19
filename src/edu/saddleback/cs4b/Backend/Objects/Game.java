package edu.saddleback.cs4b.Backend.Objects;

import edu.saddleback.cs4b.Backend.Utilitys.PublicUser;

import java.time.LocalDateTime;
import java.util.List;

public interface Game
{
    String getStartTime();
    void setStartTime(LocalDateTime newTime);

    String getStartPlayer();
    void setStartPlayer(String username);

    void setCreator(String username);
    PublicUser getCreator();

    PublicUser getOtherPlayer();
    void setOtherPlayer (String username);

    Moves getMoves();
    void setMoves(Moves newMoves);
    void addMove(Move newMove);

    String getWinner();

    String getGameID();
    void setGameID(String newGameID);

    Board getGameBoard();
    void setGameBoard(Board newBoard);

    List<PublicUser> viewers();
    void addViewer(PublicUser user);
}
