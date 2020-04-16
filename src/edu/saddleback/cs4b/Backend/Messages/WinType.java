package edu.saddleback.cs4b.Backend.Messages;

public enum WinType
{
    NORMAL_WIN("Normal"),
    PLAYER_QUIT_WIN("Player Quit");

    private String type;

    private WinType(String newType)
    {
        type = newType;
    }

    public String getType()
    {
        return type;
    }
}
