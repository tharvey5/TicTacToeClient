package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Utilitys.User;

public class SuccessfulUpdateProfileMessage extends BaseMessage
{
    private User user;
    public SuccessfulUpdateProfileMessage()
    {
        this(null);
    }

    public SuccessfulUpdateProfileMessage(User user)
    {
        super(MsgTypes.SUCCESS_UPDATE_PROFILE);
        this.user = user;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
