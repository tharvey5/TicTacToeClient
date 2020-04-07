package edu.saddleback.cs4b.Backend.Messages;

import java.util.List;

public class ActiveUserMessage extends BaseMessage {
    private List<String> activeUsers;

    /*
     * Request Message Constructor
     */
    public ActiveUserMessage()
    {
        super(MsgTypes.ACTIVE_USER_REQ);
        activeUsers = null;
    }

    /*
     * Server Response Message Constructor
     */
    public ActiveUserMessage(List<String> newActiveUsers)
    {
        super(MsgTypes.ACTIVE_USER_REQ);
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
