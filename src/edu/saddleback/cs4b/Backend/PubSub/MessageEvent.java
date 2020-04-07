package edu.saddleback.cs4b.Backend.PubSub;

import edu.saddleback.cs4b.Backend.Messages.BaseMessage;

public class MessageEvent implements SystemEvent {
    private BaseMessage message;

    public MessageEvent(BaseMessage message) {
        setMessage(message);
    }

    private void setMessage(BaseMessage message) { this.message = message; }
    public BaseMessage getMessage() { return message; }

    @Override
    public SystemEvent getEvent() { return this; }

    @Override
    public String getType() { return EventType.MESSAGE_EVENT.getType(); }
}
