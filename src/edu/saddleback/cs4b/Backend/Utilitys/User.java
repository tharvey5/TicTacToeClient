package edu.saddleback.cs4b.Backend.Utilitys;

public interface User extends Authenticatable, PublicUser {
    String getFirstName();
    String getLastName();
    String getPassword();
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setPassword(String password);
}
