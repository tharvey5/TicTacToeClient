package edu.saddleback.cs4b.Backend.Messages;

import java.util.List;

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
