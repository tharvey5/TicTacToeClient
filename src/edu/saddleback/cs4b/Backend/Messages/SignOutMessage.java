package edu.saddleback.cs4b.Backend.Messages;

/**
 * this message is sent by the client to the server when the user
 * requests to sign out
 */
public class SignOutMessage extends BaseMessage {
    public SignOutMessage() {
        super(MsgTypes.SIGN_OUT);
    }
}
