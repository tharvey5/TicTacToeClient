package edu.saddleback.cs4b.Backend.Messages;



public class CreateGameMessage extends BaseMessage
{
    private boolean isSinglePlayer;


    public CreateGameMessage(boolean newIsSinglePlayer)
    {
        super(MsgTypes.CREATE_GAME_MESSAGE);

        isSinglePlayer = newIsSinglePlayer;
    }

    public boolean checkIfSinglePlayer()
    {
        return isSinglePlayer;
    }
}
