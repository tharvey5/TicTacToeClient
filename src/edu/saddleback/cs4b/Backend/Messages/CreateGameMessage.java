package edu.saddleback.cs4b.Backend.Messages;



public class CreateGameMessage extends BaseMessage
{
    private boolean isSinglePlayer;

    public CreateGameMessage()
    {
        this(false);
    }

    public CreateGameMessage(boolean newIsSinglePlayer)
    {
        super(MsgTypes.CREATE_GAME);

        isSinglePlayer = newIsSinglePlayer;
    }

    public boolean getIfSinglePlayer()
    {
        return isSinglePlayer;
    }

    public void getIfSinglePlayer(boolean newISinglePlayer)
    {
         isSinglePlayer = newISinglePlayer;
    }
}
