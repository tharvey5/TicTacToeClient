package edu.saddleback.cs4b.Backend.Utilitys;

import edu.saddleback.cs4b.Backend.Objects.Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TTTProfile implements Serializable, Profile {
    private TTTUser user;
    private GameRecord gameRecord;
    private List<Game> activeGames;

    /**
     * This ctor will be used to create a user profile, but can also
     * be used to update a user profile
     * @throws NullPointerException
     */
    public TTTProfile(TTTUser user) throws NullPointerException {
        setUser(user);
        this.gameRecord = new TTTGameRecord();
        this.activeGames = new ArrayList<>();
    }

    /**
     * This method can be used to create or update a user profile
     */
    public TTTProfile(String userName, String firstName, String lastName, String password) {
        setUser(new TTTUser(userName, firstName, lastName, password));
        this.gameRecord = new TTTGameRecord();
        this.activeGames = new ArrayList<>();
    }

    /**
     * @throws NullPointerException if a null user is added
     */
    @Override
    public void setUser(User user) throws NullPointerException {
        if (user == null) {
            throw new NullPointerException();
        }
        this.user = (TTTUser)user;
    }



    public GameRecord getGameRecord()
    {
        return gameRecord;
    }

    public void setGameRecord(GameRecord newGameRecord)
    {
        gameRecord = newGameRecord;
    }

    public List<Game> getActiveGames()
    {
        return activeGames;
    }

    public void setActiveGames(List<Game> newActiveGames)
    {
        activeGames = newActiveGames;
    }

    public void addActiveGame(Game newGame)
    {
        activeGames.add(newGame);
    }
    public void removeActiveGame(Game oldGame)
    {
        activeGames.remove(oldGame);
    }
    public void removeActiveGame(String gameID)
    {
        int i = 0;
        while(i < activeGames.size() && activeGames.get(i).getGameID() != gameID)
        {
            ++i;
        }

        if(i < activeGames.size())
        {
            activeGames.remove(i);
        }
    }

    public void addGameToRecord(Game newGame)
    {
        gameRecord.addGame(newGame);
    }

    @Override
    public void setId(String id) {
        user.setId(Integer.parseInt(id));
    }

    @Override
    public User getUser() { return (TTTUser)user.clone(); }

    @Override
    public String getId() {
        return user.getId();
    }

    @Override
    protected Object clone()  {
        try {
            TTTProfile copy = (TTTProfile) super.clone();
            copy.user = (TTTUser)user.clone();
            return copy;
        } catch (CloneNotSupportedException ce) {
            return null;
        }
    }

    @Override
    public String toString() {
        //todo add details about other fields later as we add more data
        StringBuilder sb = new StringBuilder(user.toString());
        return sb.toString();
    }
}
