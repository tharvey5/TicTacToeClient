package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.Subject;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientEventLog implements Subject {
    private static ClientEventLog log = new ClientEventLog();
    private List<Observer> observers;

    private ClientEventLog() {
        observers = new ArrayList<>();
    }

    public static ClientEventLog getInstance() { return log; }

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
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            iterator.next().update(e);
        }
    }
}
