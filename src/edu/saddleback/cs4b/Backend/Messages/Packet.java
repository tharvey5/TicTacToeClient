package edu.saddleback.cs4b.Backend.Messages;

import java.io.Serializable;

public class Packet implements Serializable{
    private BaseMessage data;

    public Packet(BaseMessage newData)
    {
        setData(newData);
    }

    private void setData(BaseMessage data)
    {
        this.data = data;
    }

    public BaseMessage getData()
    {
        return data;
    }
}
