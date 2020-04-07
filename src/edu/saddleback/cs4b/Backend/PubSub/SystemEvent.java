package edu.saddleback.cs4b.Backend.PubSub;

public interface SystemEvent {
    SystemEvent getEvent();
    String getType();
}
