package edu.saddleback.cs4b.Backend.Messages;

import java.io.Serializable;
import java.time.LocalDateTime;


public abstract class BaseMessage implements Serializable {
    private MsgTypes messageType;
    private LocalDateTime timeStamp;

    public BaseMessage(MsgTypes newMessageType)
    {
        messageType = newMessageType;
        timeStamp   = LocalDateTime.now();
    }

    public String getMessageType()
    {
        return messageType.getType();
    }

    /*
     *Returns time of message sent as a string
     * -Could be changed to include the date as well
     */
    public String getTimeStamp()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(Integer.toString(timeStamp.getHour()));
        sb.append(":");
        sb.append(Integer.toString(timeStamp.getMinute()));

        return sb.toString();
    }
}
