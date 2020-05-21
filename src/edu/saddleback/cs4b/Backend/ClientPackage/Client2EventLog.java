package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.Subject;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Client2EventLog implements Subject {
    private static Client2EventLog log = new Client2EventLog();
    private List<Observer> observers;

    private Client2EventLog() {
        observers = new CopyOnWriteArrayList<>(); // todo costly, find alternative later
    }

    public static Client2EventLog getInstance() { return log; }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.removeIf(i-> i == o);
    }

    @Override
    public void notifyObserver(SystemEvent e) {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            iterator.next().update(e);
        }
    }
}

