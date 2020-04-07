package edu.saddleback.cs4b.Backend.PubSub;

public interface Observer {
    void update(SystemEvent e);
}
