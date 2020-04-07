package edu.saddleback.cs4b.Backend.PubSub;

/**
 * This will be used for all system events and UI
 * events to force certain names
 */
public enum EventType {
    MESSAGE_EVENT("Message Event"),
    UI_EVENT("UI-Event");

    private EventType(String type) { this.type = type; }
    private String type;
    public String getType() { return type; }
}
