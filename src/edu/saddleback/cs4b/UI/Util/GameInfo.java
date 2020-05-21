package edu.saddleback.cs4b.UI.Util;

import edu.saddleback.cs4b.Backend.Objects.Move;
import edu.saddleback.cs4b.Backend.Utilitys.PublicUser;

import java.util.List;

public class GameInfo
{
    private String id;
    private String title;
    private String startTime;
    private String endTime;
    private String host;
    private String opponent;
    private String result;

    private List<Move> moves;
    private List<PublicUser> viewers;

    public List<Move> getMoves()
    {
        return moves;
    }

    public void setMoves(List<Move> moves)
    {
        this.moves = moves;
    }

    public List<PublicUser> getViewers()
    {
        return viewers;
    }

    public void setViewers(List<PublicUser> viewers)
    {
        this.viewers = viewers;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
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
