package edu.saddleback.cs4b.Backend.Utilitys;

import java.util.UUID;

public class IDGenerator implements Identifiable {
    @Override
    public String getId() {
        return UUID.randomUUID().toString();
    }
}
