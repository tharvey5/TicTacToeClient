package edu.saddleback.cs4b.Backend.PubSub;

public interface UISubject {
    void addObserver(UIObserver o);
    void removeObserver(UIObserver o);
    void notifyObservers(SystemEvent e);
}
