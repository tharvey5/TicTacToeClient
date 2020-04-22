package edu.saddleback.cs4b.Backend.Messages;

/**
 * This message is sent by the client when they wish to deactivate their
 * account AND returned by the server once the account is deactivated
 */
public class AcctDeactivationMessage extends BaseMessage {
    public AcctDeactivationMessage() { super(MsgTypes.ACCT_DEACTIVATION);}
}
