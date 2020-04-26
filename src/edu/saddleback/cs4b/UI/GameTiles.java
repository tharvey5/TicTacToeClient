package edu.saddleback.cs4b.UI;

public enum GameTiles
{
    CENTER        (1, 1, "Center"        ),
    MIDDLE_LEFT   (1, 0, "Middle Left"   ),
    MIDDLE_RIGHT  (1, 2, "Middle Right"  ),
    TOP_CENTER    (0, 1, "Top Center"    ),
    TOP_LEFT      (0, 0, "Top Left"      ),
    TOP_RIGHT     (0, 2, "Top Right"     ),
    BOTTOM_CENTER (2, 1, "Bottom Center" ),
    BOTTOM_LEFT   (2, 0, "Bottom Left"   ),
    BOTTOM_RIGHT  (2, 2, "Bottom Right"  );

    private int tileRow;
    private int tileColumn;
    private String tileName;

    GameTiles(int tileRow, int tileColumn, String tileName)
    {
        this.tileRow = tileRow;
        this.tileColumn = tileColumn;
        this.tileName = tileName;
    }

    public int getTileRow()
    {
        return tileRow;
    }
    public int getTileColumn()
    {
        return tileColumn;
    }
    public String getTileName()
    {
        return tileName;
    }
}
