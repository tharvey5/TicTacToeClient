package edu.saddleback.cs4b.Backend.Messages;

public class JoinGameRequestMessage extends BaseMessage
{
    private String gameID;

    public JoinGameRequestMessage()
    {
        this(null);
    }

    public JoinGameRequestMessage(String newGameID)
    {
        super(MsgTypes.JOIN_GAME_REQUEST);

        gameID = newGameID;
    }

    public String getGameID()
    {
        return gameID;
    }

    public void setGameID(String newGameID)
    {
        gameID = newGameID;
    }
}
