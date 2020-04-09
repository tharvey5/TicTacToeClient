package edu.saddleback.cs4b.Backend.Utilitys;

import java.io.Serializable;

public class TTTProfile implements Serializable, Profile {
    private TTTUser user;
    // private GameRecord gameRecord;
    // private List<Games> activeGames;

    /**
     * This ctor will be used to create a user profile, but can also
     * be used to update a user profile
     * @throws NullPointerException
     */
    public TTTProfile(TTTUser user) throws NullPointerException {
        setUser(user);
    }

    /**
     * This method can be used to create or update a user profile
     */
    public TTTProfile(String userName, String firstName, String lastName, String password) {
        setUser(new TTTUser(userName, firstName, lastName, password));
    }

    /**
     * @throws NullPointerException if a null user is added
     */
    private void setUser(TTTUser user) throws NullPointerException {
        if (user == null) {
            throw new NullPointerException();
        }
        this.user = user;
    }

    @Override
    public User getUser() { return (TTTUser)user.clone(); }

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
