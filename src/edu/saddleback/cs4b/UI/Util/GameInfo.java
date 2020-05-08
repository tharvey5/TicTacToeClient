package edu.saddleback.cs4b.UI.Util;

import java.util.List;

public class GameInfo
{
    private String id;
    private String startTime;
    private String endTime;
    private String host;
    private String opponent;
    private String result;

    private List moves;
    private List viewers;


    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getOpponent()
    {
        return opponent;
    }

    public void setOpponent(String opponent)
    {
        this.opponent = opponent;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }
}
