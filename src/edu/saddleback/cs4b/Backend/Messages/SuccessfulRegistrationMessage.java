package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Utilitys.User;

/**
 * This message is initiated by the server to notify the client that the
 * user has successfully registered or updated account details
 */

public class SuccessfulRegistrationMessage extends BaseMessage {
    private User user;

    public SuccessfulRegistrationMessage() { super(MsgTypes.SUCCESS_REG);}

    public SuccessfulRegistrationMessage(User user) {
        super(MsgTypes.SUCCESS_REG);
        this.user = user;
    }

    public void setUser(User user) { this.user = user; }
    public User getUser() { return user; }
}
