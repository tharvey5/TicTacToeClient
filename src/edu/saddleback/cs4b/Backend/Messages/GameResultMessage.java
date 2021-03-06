package edu.saddleback.cs4b.Backend.Messages;

public class GameResultMessage extends BaseMessage {
    private WinType winType;
    private String winner;


    public GameResultMessage()
    {
        this(null, null, null, false);
    }

    public GameResultMessage(WinType newWinType, String newWinner, String newLoser, boolean newIsTieGame)
    {
        super(MsgTypes.GAME_RESULT);

        winType = newWinType;
        winner = newWinner;
    }

    public WinType getWinType()
    {
        return winType;
    }

    public String getWinner()
    {
        return winner;
    }

    public void setWinner(String newWinner) {
        winner = newWinner;
    }

    public void setWinType(WinType newWinType)
    {
        winType = newWinType;
    }

}
