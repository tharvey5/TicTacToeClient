package edu.saddleback.cs4b.Backend.Messages;

import java.util.List;

/**
 * This message is received by clients to indicate that the user
 * has been disconnected from the channel. This is NOT used for acct
 * suspensions
 */
public class DisconnectMessage extends BaseMessage {
    private List<String> channels;
    private String userName;

    /**
     * used for the message factory
     */
    DisconnectMessage()
    {
        this(null, "");
    }

    public DisconnectMessage(List<String> newChannels, String newUserName)
    {
        super(MsgTypes.DISCONNECTION);
        setChannels(newChannels);
        setUserName(newUserName);
    }

    public List<String> getChannels()
    {
        return channels;
    }

    private void setChannels(List<String> channels)
    {
        channels = channels;
    }

    public String getUserName()
    {
        return userName;
    }

    private void setUserName(String userName)
    {
        this.userName = userName;
    }
}
