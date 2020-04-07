package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Utilitys.User;

public class SignInMessage extends BaseMessage {
    private User userInfo;

    SignInMessage() {
        this(null);
    }

    public SignInMessage(User newUserInfo)
    {
        super(MsgTypes.SIGN_IN);
        setUserInfo(newUserInfo);
    }

    public User getUserInfo()
    {
        return userInfo;
    }

    public void setUserInfo(User newUserInfo)
    {
        userInfo = newUserInfo;
    }
}
