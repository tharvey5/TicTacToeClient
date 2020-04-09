package edu.saddleback.cs4b.Backend.Messages;

/**
 * Is the interface that supports any of the message factories for this project
 */
public interface AbstractMessageFactory {
    BaseMessage createMessage(String type);
}
