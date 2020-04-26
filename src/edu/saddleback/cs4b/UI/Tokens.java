package edu.saddleback.cs4b.UI;

public enum Tokens
{
    DEFAULT_X ("X-default", "src/edu/saddleback/cs4b/UI/Images/Tokens/X-default.png"),
    DEFAULT_O ("O-default", "src/edu/saddleback/cs4b/UI/Images/Tokens/O-default.png"),
    BLUE_O    ("Blue-O", "src/edu/saddleback/cs4b/UI/Images/Tokens/Blue-O.png"),
    RED_X     ("Red-X","src/edu/saddleback/cs4b/UI/Images/Tokens/Red-X.png");

    private String fxmlId;
    private String location;

    private Tokens(String fxmlId, String location)
    {
        this.fxmlId = fxmlId;
        this.location = location;
    }

    public String getId()
    {
        return fxmlId;
    }

    public String getLocation()
    {
        return location;
    }
}
