package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.UI.Util.GameManager;

/**
 * This class will be used to run the AI for users who wish to play a
 * single player game. It will sign into the system using its own
 * universal login
 */
public final class ClientAIRunner implements Observer {
    private volatile static ClientAIRunner aiRunner = null;
    private GameManager gameManager;

    private ClientAIRunner() {
        gameManager = GameManager.getInstance();
    }

    public static ClientAIRunner getInstance() {
        if (aiRunner == null) {
            synchronized (ClientAIRunner.class) {
                if (aiRunner == null) {
                    aiRunner = new ClientAIRunner();
                    GameManager.getInstance().addObserver(aiRunner);
                }
            }
        }
        return aiRunner;
    }
    
    @Override
    public void update(SystemEvent e) {

    }
}
