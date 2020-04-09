package edu.saddleback.cs4b.Backend.Messages;

/**
 * This message is sent by the server to indicate to the client that
 * their sign-in was successful. Received by the client
 */
public class AuthenticatedMessage extends BaseMessage {
    public AuthenticatedMessage() { super(MsgTypes.AUTHENTICATION);}
}
