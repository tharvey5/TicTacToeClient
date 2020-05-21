package edu.saddleback.cs4b.UI.Util;

import edu.saddleback.cs4b.Backend.Objects.Game;
import edu.saddleback.cs4b.Backend.PubSub.*;
import edu.saddleback.cs4b.Backend.Utilitys.GameRecord;
import edu.saddleback.cs4b.Backend.Utilitys.TTTGameRecord;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * holds information about the game(s) that the user is(are) playing and can
 * be shared between classes throughout the duration of the program
 */
public class GameManager implements Subject
{
    private volatile static GameManager gameManager = null;
    private Game game;

    private GameRecord localRecord;

    private String id;
    private boolean isCreator;
    private boolean isPlayer;
    private boolean isSinglePlayer;

    private List<Observer> observers;

    public void setLocalRecord(GameRecord record) {
        if (record != null) {
            this.localRecord = record;
        } else {
            this.localRecord = new TTTGameRecord();
        }
    }

    public void updateWins() {
        int wins = localRecord.getWins() + 1;
        localRecord.setWins(wins);
        addGame();
    }

    public void updateLosses() {
        int losses = localRecord.getLosses() + 1;
        localRecord.setLosses(losses);
        addGame();
    }

    public void addGame() {
        int games = localRecord.getNumGames() + 1;
        localRecord.setTotalGames(games);
    }

    public GameRecord getRecord() { return localRecord; }

    @Override
    public void addObserver(Observer o)
    {
        if (o != null)
        {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o)
    {
        if (o != null)
        {
            observers.removeIf(ob->ob == o);
        }
    }

    @Override
    public void notifyObserver(SystemEvent e)
    {
        Iterator<Observer> iterator = observers.iterator();
        while(iterator.hasNext())
        {
            iterator.next().update(e);
        }
    }

    private GameManager()
    {
        clear();
        observers = new ArrayList<>();
    }

    public static GameManager getInstance()
    {
        if (gameManager == null)
        {
            synchronized (GameManager.class)
            {
                if (gameManager == null)
                {
                    gameManager = new GameManager();
                }
            }
        }
        return gameManager;
    }

    public String getId()
    {
        return id;
    }
    public boolean isCreator()
    {
        return isCreator;
    }

    public boolean isPlayer()
    {
        return isPlayer;
    }

    public boolean isSinglePlayer()
    {
        return isSinglePlayer;
    }

    public void setId(String id)
    {
        this.id = id;
        notifyObserver(new MessageEvent(new RequestAIMessage()));
        System.out.println("Game id was set");
    }
    public void setCreator(boolean creator)
    {
        isCreator = creator;
    }
    public void setPlayer(boolean player)
    {
        isPlayer = player;
    }
    public void setSinglePlayer(boolean singlePlayer)
    {
        isSinglePlayer = singlePlayer;
    }

    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }

    /**
     * clears the state of a game you are playing
     */
    public void clear()
    {
        id = null;
        isCreator = false;
        isPlayer = false;
        isSinglePlayer = false;
    }
}
