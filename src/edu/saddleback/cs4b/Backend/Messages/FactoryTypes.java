package edu.saddleback.cs4b.Backend.Messages;

/**
 * Defines the types of Message Factories that exist
 */
public enum FactoryTypes {
    ADMIN_FACT("Admin Factory"),
    GAME_FACT("Game Factory");
    private String type;
    private FactoryTypes(String type) { this.type = type; }
    public String getTypes() { return  type; }

    @Override
    public String toString() { return getTypes(); }
}
