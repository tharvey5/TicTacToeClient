package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Utilitys.Profile;
import edu.saddleback.cs4b.Backend.Utilitys.TTTProfile;
import edu.saddleback.cs4b.Backend.Utilitys.User;

public class ClientUser
{
    private static User instance;
    private static Profile profile;

    public static User getInstanceOf()
    {
        return instance;
    }

    public static void setInstance(User user)
    {
        instance = user;
    }

    public static void setProfile(Profile profile) { ClientUser.profile = profile;}

    public static Profile getProfile() { return profile; }
}
