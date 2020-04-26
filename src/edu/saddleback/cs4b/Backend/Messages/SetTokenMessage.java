package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Token;

public class SetTokenMessage extends BaseMessage
{
    private Token token;

    public SetTokenMessage()
    {
        this(null);
    }

    public SetTokenMessage(Token newToken)
    {
        super(MsgTypes.SET_TOKEN);
        token = newToken;
    }

    public Token getToken()
    {
        return token;
    }

    public String getTokenID()
    {
        return token.getTokenID();
    }

    public void setToken(Token newToken)
    {
        token = newToken;
    }
}
