package edu.saddleback.cs4b.Backend.Messages;

public class SignOutConfirmationMessage extends BaseMessage
{
    public SignOutConfirmationMessage()
    {
        super(MsgTypes.SIGN_OUT_CONFIRM);
    }
}
