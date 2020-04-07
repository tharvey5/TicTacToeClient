package edu.saddleback.cs4b.Backend.Messages;

public interface AbstractMessageFactory {
    BaseMessage createMessage(String type);
}
