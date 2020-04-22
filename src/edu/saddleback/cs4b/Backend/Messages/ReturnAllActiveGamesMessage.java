package edu.saddleback.cs4b.Backend.Messages;

public class ReturnAllActiveGamesMessage extends BaseMessage
{
    List<Game> games;

    public ReturnAllActiveGamesMessage(List<Game> newGames)
    {
        super(MsgTypes.RETURN_ACTIVE_GAMES);

        games = newGames;
    }
    public ReturnAllActiveGamesMessage()
    {
        this(null);
    }

    public List<Game> getGames()
    {
        return games;
    }

    public void setGames(List<Game> newGames)
    {
        games = newGames;
    }
}
