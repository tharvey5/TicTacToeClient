package edu.saddleback.cs4b.Backend.Messages;

public class DeactivationConfirmationMessage extends BaseMessage
{
    DeactivationConfirmationMessage()
    {
        super(MsgTypes.DEACTIVATION_CONFIRM);
    }
}
