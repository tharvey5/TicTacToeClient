package edu.saddleback.cs4b.Backend.Utilitys;

import java.io.Serializable;

// todo should this and the server lie in the Backend package to allow for
//package access to methods only database would need but not any other client
// such as getting and setting the id etc
public class TTTUser implements Serializable, Cloneable, User {
    private String username;
    private String fn;
    private String ln;
    private String password;
    private int id;

    private TTTUser(String username, String fn, String ln, String password, int id) {
        setUsername(username);
        setFirstName(fn);
        setLastName(ln);
        setPassword(password);
        setId(id);
    }

    /**
     * This ctor can be used for creating a new user, or updating ALL
     * of the fields of an existing user
     */
    public TTTUser(String username, String fn, String ln, String password) {
        this(username, fn, ln, password, -1);
    }

    /**
     * This ctor could/should only be used when the only information
     * required for a user is their username and password
     */
    public TTTUser(String username, String password) {
        this(username, "", "", password, -1);
    }

    @Override
    public String getUsername() { return username; }

    @Override
    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    @Override
    public String getFirstName() { return fn; }

    @Override
    public String getLastName() { return ln; }
    // todo how should we handle this?? this could be an issue if its public
    public String getPassword() { return password; }

    // todo this probably would only be used by server??? ** should it be public **
    @Override
    public String getId() { return Integer.toString(id); }

    @Override
    public void setUsername(String username) { this.username = username; }

    @Override
    public void setFirstName(String firstName) { this.fn = firstName; }

    @Override
    public void setLastName(String lastName) { this.ln = lastName; }

    @Override
    public void setPassword(String password) { this.password = password; }

    public void setId(int id) { this.id = id; }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    /**
     * can be used to check that the username for another user
     * is not the same as the one trying to be set by this user
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof TTTUser)) {
            return false;
        } else {
            return username.equals((((TTTUser) obj).username));
        }
    }

    @Override
    protected Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException ce) {
            ce.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Username= ");
        sb.append(username);
        sb.append(", FirstName= ");
        sb.append(fn);
        sb.append(", LastName= ");
        sb.append(ln);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String getKey() {
        return password;
    }

    @Override
    public String getIdentifier() {
        return username;
    }
}
