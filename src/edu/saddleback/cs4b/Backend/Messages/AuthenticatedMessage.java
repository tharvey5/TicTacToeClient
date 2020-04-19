package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Utilitys.User;

/**
 * This message is sent by the server to indicate to the client that
 * their sign-in was successful. Received by the client
 */
public class AuthenticatedMessage extends BaseMessage {
    private User authUser;

    public AuthenticatedMessage() { super(MsgTypes.AUTHENTICATION);}

    public User getAuthUser() { return authUser; }
    public void setAuthUser(User user) {
        this.authUser = user;
    }
}
