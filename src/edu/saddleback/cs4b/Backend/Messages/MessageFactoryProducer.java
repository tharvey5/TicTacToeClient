package edu.saddleback.cs4b.Backend.Messages;

public class MessageFactoryProducer {
    /**
     * @return null if factory wasn't found, use the FactoryTypes enum
     * to get acceptable factory types
     */
    public static AbstractMessageFactory getFactory(String type) {
        if (type.equals(FactoryTypes.ADMIN_FACT.toString())) {
            return new AdminMessageFactory();
        }
        return null;
    }
}
