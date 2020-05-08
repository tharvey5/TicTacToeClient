package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Messages.BaseMessage;
import edu.saddleback.cs4b.Backend.Messages.MsgTypes;
import edu.saddleback.cs4b.Backend.Utilitys.Profile;
import edu.saddleback.cs4b.Backend.Utilitys.User;

/**
 * This message is sent by the server to indicate to the client that
 * their sign-in was successful. Received by the client
 */
public class AuthenticatedMessage extends BaseMessage {
    private User authUser;
    private Profile profile;

    public AuthenticatedMessage() { super(MsgTypes.AUTHENTICATION);}


    public User getAuthUser() { return authUser; }
    public void setAuthUser(User user) {
        this.authUser = user;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public Profile getProfile() {
        return profile;
    }
}