package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Coordinate;
import edu.saddleback.cs4b.Backend.Objects.Token;

public class ValidMoveMessage extends BaseMessage
{
    private Coordinate coordinate;
    private String gameId;
    private Token token;
    private String user;

    public ValidMoveMessage()
    {
        this(null, null, null, null);
    }

    public ValidMoveMessage(Coordinate coordinate, String gameId, Token token, String user) {
        super(MsgTypes.VALID_MOVE);
        this.coordinate = coordinate;
        this.gameId = gameId;
        this.token = token;
        this.user = user;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
