package edu.saddleback.cs4b.Backend.Messages;

/**
 * This factory should be used to create any administrative messages BUT
 * not the game related messages
 */
public class AdminMessageFactory implements AbstractMessageFactory {
    @Override
    public BaseMessage createMessage(String type) {
        BaseMessage message = null;
        if (type.equals(MsgTypes.ACTIVE_USER_REQ.getType())) {
            message = new ActiveUserMessage();
        }
        else  if (type.equals(MsgTypes.DISCONNECTION.getType())) {
            message = new DisconnectMessage();
        }
        else if (type.equals(MsgTypes.SIGN_IN.getType())) {
            message = new SignInMessage();
        }
        else if (type.equals(MsgTypes.SIGN_OUT.getType())) {
            message = new SignOutMessage();
        }
        else if (type.equals(MsgTypes.REG_ERROR.getType())) {
            message = new RegistrationErrorMessage();
        }
        else if (type.equals(MsgTypes.SUCCESS_REG.getType())) {
            message = new SuccessfulRegistration();
        }
        else if (type.equals(MsgTypes.AUTHENTICATION.getType())) {
            message = new AuthenticatedMessage();
        }
        else if (type.equals(MsgTypes.DENIED.getType())) {
            message = new DeniedEntryMessage();
        }
        else if (type.equals(MsgTypes.PROFILE.getType())) {
            message = new ProfileMessage();
        }
        else if (type.equals(MsgTypes.DEACTIVATION.getType())) {
            message = new AcctDeactivationMessage();
        }
        return message;
    }
}
