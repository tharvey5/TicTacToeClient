package edu.saddleback.cs4b.Backend.Messages;

public class DeactivationConfirmationMessage extends BaseMessage
{
    public DeactivationConfirmationMessage()
    {
        super(MsgTypes.DEACTIVATION_CONFIRM);
    }
}
