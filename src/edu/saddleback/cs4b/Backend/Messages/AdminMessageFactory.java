package edu.saddleback.cs4b.Backend.Messages;

/**
 * This factory should be used to create any administrative messages BUT
 * not the game related messages
 */
public class AdminMessageFactory implements AbstractMessageFactory {
    @Override
    public BaseMessage createMessage(String type) {
        BaseMessage message = null;
        if(type.equals(MsgTypes.ACCT_DEACTIVATION.getType()))
        {
            message = new AcctDeactivationMessage();
        }
        else if (type.equals(MsgTypes.ACTIVE_USER.getType())) {
            message = new ActiveUserResponseMessage();
        }
        else if (type.equals(MsgTypes.ACTIVE_USER_RESPONSE.getType()))
        {
            message = new ActiveUserMessage();
        }
        else if (type.equals(MsgTypes.AUTHENTICATION.getType()))
        {
            message = new AuthenticatedMessage();
        }
        else if (type.equals(MsgTypes.DEACTIVATION_CONFIRM.getType()))
        {
            message = new DeactivationConfirmationMessage();
        }
        else if (type.equals(MsgTypes.DENIED.getType()))
        {
            message = new DeniedEntryMessage();
        }
        else if (type.equals(MsgTypes.INVALID_PROFILE_UPDATE.getType()))
        {
            message = new InvalidProfileUpdateMessage();
        }
        else if (type.equals(MsgTypes.REG_ERROR.getType()))
        {
            message = new RegistrationErrorMessage();
        }
        else if (type.equals(MsgTypes.REGISTRATION.getType()))
        {
            message = new RegistrationErrorMessage();
        }
        else if (type.equals(MsgTypes.SIGN_IN.getType()))
        {
            message = new SignInMessage();
        }
        else if (type.equals(MsgTypes.SIGN_OUT.getType()))
        {
            message = new SignOutMessage();
        }
        else if (type.equals(MsgTypes.SIGN_OUT_CONFIRM))
        {
            message = new SignOutConfirmationMessage();
        }
        else if (type.equals(MsgTypes.SUCCESS_REG.getType()))
        {
            message = new SuccessfulRegistrationMessage();
        }
        else if (type.equals(MsgTypes.SUCCESS_UPDATE_PROFILE.getType()))
        {
            message = new SuccessfulUpdateProfileMessage();
        }





        else if (type.equals(MsgTypes.UPDATE_PROFILE.getType()))
        {
            message = new UpdateProfileMessage();
        }
        return message;
    }
}
