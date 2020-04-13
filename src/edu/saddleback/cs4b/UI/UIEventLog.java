package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.PubSub.UIObserver;
import edu.saddleback.cs4b.Backend.PubSub.UISubject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UIEventLog implements UISubject {
    private List<UIObserver> uiObservers;
    private static UIEventLog log = new UIEventLog();

    private UIEventLog() {
        uiObservers = new ArrayList<>();
    }

    public static UIEventLog getInstance() { return log; }

    @Override
    public void addObserver(UIObserver o) {
        uiObservers.add(o);
    }

    @Override
    public void removeObserver(UIObserver o) {
        uiObservers.remove(o);
    }

    @Override
    public void notifyObservers(SystemEvent e) {
        Iterator<UIObserver> iterator = uiObservers.iterator();
        while (iterator.hasNext()) {
            iterator.next().update(e);
        }
    }
}
