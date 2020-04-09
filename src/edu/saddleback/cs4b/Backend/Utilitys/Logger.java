package edu.saddleback.cs4b.Backend.Utilitys;

import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;

public interface Logger {
    void log(SystemEvent se);
}

