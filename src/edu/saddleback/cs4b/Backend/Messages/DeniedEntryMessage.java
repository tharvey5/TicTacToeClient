package edu.saddleback.cs4b.Backend.Messages;

/**
 * This message is received by the client when their sign-in / login was
 * unsuccessful
 */
public class DeniedEntryMessage extends BaseMessage {
    public DeniedEntryMessage() { super(MsgTypes.DENIED);}
}
