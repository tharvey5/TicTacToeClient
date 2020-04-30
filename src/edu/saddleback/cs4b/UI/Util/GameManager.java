package edu.saddleback.cs4b.UI.Util;

/**
 * holds information about the game(s) that the user is(are) playing and can
 * be shared between classes throughout the duration of the program
 */
public class GameManager {
    private volatile static GameManager gameManager = null;
    // List<String> ids;
    private String id;
    private boolean isCreator;
    private boolean isPlayer;


    private GameManager() {
        id = null;
        isCreator = false;
        isPlayer = false;
    }

    public static GameManager getInstance() {
        if (gameManager == null) {
            synchronized (GameManager.class) {
                if (gameManager == null) {
                    gameManager = new GameManager();
                }
            }
        }
        return gameManager;
    }

    public String getId() { return id; }
    public boolean isCreator() { return isCreator; }
    public boolean isPlayer() { return isPlayer; }

    public void setId(String id) { this.id = id; }
    public void setCreator(boolean creator) { isCreator = creator; }
    public void setPlayer(boolean player) { isPlayer = player; }
}
