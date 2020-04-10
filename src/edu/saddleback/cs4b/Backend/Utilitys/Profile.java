package edu.saddleback.cs4b.Backend.Utilitys;

public interface Profile {
    User getUser();
    String getId();
    void setUser(User user);
    void setId(String id);
}
