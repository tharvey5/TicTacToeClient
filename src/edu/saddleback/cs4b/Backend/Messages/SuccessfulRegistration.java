package edu.saddleback.cs4b.Backend.Messages;

/**
 * This message is initiated by the server to notify the client that the
 * user has successfully registered or updated account details
 */
public class SuccessfulRegistration extends BaseMessage {
    public SuccessfulRegistration() { super(MsgTypes.SUCCESS_REG);}
}
