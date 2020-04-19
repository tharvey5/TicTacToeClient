package edu.saddleback.cs4b.Backend.Utilitys;

/**
 * This user will only contain information about a user
 * that is safe for public visibility
 *
 * NOTE: Our user structure could of been designed in a better way
 * possibly using an abstract class for the specific use cases
 */
public class TTTPublicUser implements PublicUser {
    private String id;
    private String username;

    TTTPublicUser() {
        this ("", "");
    }

    public TTTPublicUser(String id, String username) {
        setId(id);
        setUsername(username);
    }

    @Override
    public void setId(String id) { this.id = id; }

    @Override
    public void setUsername(String username) { this.username = username; }

    @Override
    public String getId() { return id; }

    @Override
    public String getUsername() { return username; }

    //todo implement the other object functions if time

    @Override
    public String toString() {
        return "[username=" + username + ", id=" + id + "]";
    }
}
