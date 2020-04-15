package edu.saddleback.cs4b.Backend.Messages;

public class ViewGameRequestMessage extends BaseMessage
{
    private String gameID;

    public ViewGameRequestMessage(String newGameID)
    {
        super(MsgTypes.VIEW_GAME_REQUEST);

        gameID = newGameID;
    }

    public String getGameID()
    {
        return gameID;
    }
}
