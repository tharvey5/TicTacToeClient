package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Utilitys.User;

public class ClientUser
{
    private static User instance;

    public static User getInstanceOf()
    {
        return instance;
    }

    public static void setInstance(User user)
    {
        instance = user;
    }
}
