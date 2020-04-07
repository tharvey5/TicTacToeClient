package edu.saddleback.cs4b.Backend.Utilities;

import java.io.Serializable;

// todo should this and the server lie in the Backend package to allow for
//package access to methods only database would need but not any other client
// such as getting and setting the id etc
public class User implements Serializable, Cloneable {
    private String username;
    private String fn;
    private String ln;
    private String password;
    private int id;

    private User(String username, String fn, String ln, String password, int id) {
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
    public User(String username, String fn, String ln, String password) {
        this(username, fn, ln, password, -1);
    }

    /**
     * This ctor could/should only be used when the only information
     * required for a user is their username and password
     */
    public User(String username, String password) {
        this(username, "", "", password, -1);
    }

    public String getUsername() { return username; }
    public String getFirstName() { return fn; }
    public String getLn() { return ln; }
    // todo how should we handle this?? this could be an issue if its public
    private String getPassword() { return password; }

    // todo this probably would only be used by server??? ** should it be public **
    private int getId() { return id; }

    void setUsername(String username) { this.username = username; }
    void setFirstName(String fn) { this.fn = fn; }
    void setLastName(String ln) { this.ln = ln; }
    void setPassword(String password) { this.password = password; }
    private void setId(int id) { this.id = id; }

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
        } else if (!(obj instanceof User)) {
            return false;
        } else {
            return username.equals((((User) obj).username));
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
}
