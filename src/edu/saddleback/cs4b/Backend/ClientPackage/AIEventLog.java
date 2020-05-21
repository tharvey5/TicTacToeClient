package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.PubSub.UIObserver;
import edu.saddleback.cs4b.Backend.PubSub.UISubject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIEventLog implements UISubject {
    private volatile static AIEventLog log = null;

    private List<UIObserver> aiObservers;

    private AIEventLog() {
        aiObservers = new ArrayList<>();
    }

    public static AIEventLog getInstance() {
        if (log == null) {
            synchronized (AIEventLog.class) {
                if (log == null) {
                    log = new AIEventLog();
                }
            }
        }
        return log;
    }

    @Override
    public void addObserver(UIObserver o) {
        if (o != null) {
            aiObservers.add(o);
        }
    }

    @Override
    public void removeObserver(UIObserver o) {
        aiObservers.remove(o);
    }

    @Override
    public void notifyObservers(SystemEvent e) {
        Iterator<UIObserver> iterator = aiObservers.iterator();
        while(iterator.hasNext())
        {
            iterator.next().update(e);
        }
    }
}
