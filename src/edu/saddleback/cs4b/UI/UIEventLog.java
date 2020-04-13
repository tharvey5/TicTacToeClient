package edu.saddleback.cs4b.UI;

import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.PubSub.UIObserver;
import edu.saddleback.cs4b.Backend.PubSub.UISubject;

import java.util.List;

public class UIEventLog implements UISubject {
    private List<UIObserver> uiObservers;
    
    @Override
    public void addObserver(UIObserver o) {

    }

    @Override
    public void removeObserver(UIObserver o) {

    }

    @Override
    public void notifyObservers(SystemEvent e) {

    }
}
