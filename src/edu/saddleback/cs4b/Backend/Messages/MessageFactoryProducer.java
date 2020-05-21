package edu.saddleback.cs4b.Backend.Messages;

/**
 * This is a class with a static method that produces the factory and
 * encapulates the creation of our different factories
 */
public class MessageFactoryProducer {
    /**
     * @return null if factory wasn't found, use the FactoryTypes enum
     * to get acceptable factory types
     */
    public static AbstractMessageFactory getFactory(String type) {
        if (type.equals(FactoryTypes.ADMIN_FACT.getTypes())) {
            return new AdminMessageFactory();
        } else if (type.equals(FactoryTypes.GAME_FACT.getTypes())) {
            return new GameMessageFactory();
        }
        return null;
    }
}
