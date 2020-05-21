package edu.saddleback.cs4b.Backend.Objects;

import java.io.Serializable;

public class TTTToken implements Token, Serializable
{
    private String tokenID;

    public TTTToken()
    {
        this(null);
    }
    public TTTToken(String newTokenID)
    {
        setTokenID(newTokenID);
    }

    public void setTokenID(String newTokenID)
    {
        tokenID = newTokenID;
    }

    @Override
    public String getTokenID()
    {
        return tokenID;
    }
}
