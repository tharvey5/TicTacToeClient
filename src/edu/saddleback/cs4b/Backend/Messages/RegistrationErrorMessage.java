package edu.saddleback.cs4b.Backend.Messages;

/**
 * This message is sent by the server and received by the client when
 * any part of their registration or Update of existing details fails
 * usually due to colliding usernames
 */
public class RegistrationErrorMessage extends BaseMessage {
    public RegistrationErrorMessage() {
        super(MsgTypes.REG_ERROR);
    }
}
