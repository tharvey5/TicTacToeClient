package edu.saddleback.cs4b.Backend.Messages;

import java.util.List;


public class ActiveUserMessage extends BaseMessage {
    private List<String> activeUsers;

    public ActiveUserMessage()
    {
        this(null);
    }

    public ActiveUserMessage(List<String> newActiveUsers)
    {
        super(MsgTypes.ACTIVE_USER);
        setActiveUsers(newActiveUsers);
    }

    public void setActiveUsers(List<String> newActiveUsers)
    {
        activeUsers = newActiveUsers;
    }

    public List<String> getActiveUsers()
    {
        return activeUsers;
    }


}
