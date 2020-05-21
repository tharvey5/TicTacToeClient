package edu.saddleback.cs4b.Backend.PubSub;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver(SystemEvent e);
}
