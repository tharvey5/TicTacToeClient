package edu.saddleback.cs4b.Backend.Utilitys;

import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.Subject;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;

import java.util.ArrayList;
import java.util.List;

public class ServerLogger implements Logger, Subject {
    // volatile tells jvm && threads to not do any cache optimization, make sure that
    // any private copy it keeps is most up to date with whats in memory
    private volatile static ServerLogger logger = null;
    private List<Observer> observers;

    private ServerLogger() {
        observers = new ArrayList<>();
    }

    public static ServerLogger getInstance() {
        if (logger == null) {
            synchronized (ServerLogger.class) {
                // check again in case multiple treads got to this point
                if (logger == null) {
                    logger = new ServerLogger();
                }
            }
        }
        return logger;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(SystemEvent e) {
        for (Observer ob : observers) {
            ob.update(e);
        }
    }

    @Override
    public void log(SystemEvent se) {
        notifyObserver(se);
    }
}
