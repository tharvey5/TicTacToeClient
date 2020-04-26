package edu.saddleback.cs4b.Backend.Objects;

import edu.saddleback.cs4b.Backend.Utilitys.PublicUser;

import java.time.LocalDateTime;
import java.util.List;

public interface Game
{
    void setToken(Token token, PublicUser user);
    Token getToken(PublicUser user);

    String getStartTime();
    void setStartTime(LocalDateTime newTime);

    void setEndTime(LocalDateTime endTime);
    String getEndTime();

    PublicUser getStartPlayer();
    void setStartPlayer(PublicUser user);

    void setCreator(PublicUser user);
    PublicUser getCreator();

    PublicUser getOtherPlayer();
    void setOtherPlayer (PublicUser user);

    Moves getMoves();
    void setMoves(Moves newMoves);
    void addMove(Move newMove);

    PublicUser getWinner();
    void setWinner(PublicUser user);

    String getGameID();
    void setGameID(String newGameID);

    Board getGameBoard();
    void setGameBoard(Board newBoard);

    List<PublicUser> viewers();
    void addViewer(PublicUser user);
}
