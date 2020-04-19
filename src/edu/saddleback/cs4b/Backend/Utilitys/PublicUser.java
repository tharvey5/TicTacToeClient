package edu.saddleback.cs4b.Backend.Utilitys;

/**
 * most basic form of a user profile
 */
public interface PublicUser {
    String getId();
    String getUsername();
    void setId(String id);
    void setUsername(String username);
}
