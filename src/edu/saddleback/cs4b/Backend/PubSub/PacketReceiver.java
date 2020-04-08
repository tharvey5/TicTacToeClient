package edu.saddleback.cs4b.Backend.PubSub;

import edu.saddleback.cs4b.Backend.Messages.Packet;
import edu.saddleback.cs4b.Backend.Messages.SignInMessage;

import java.io.ObjectInputStream;
import java.util.List;


public class PacketReceiver implements Subject, Runnable
{
    private ObjectInputStream in;
    private List<Observer> observers;

    public PacketReceiver(ObjectInputStream newIn, Observer controller)
    {
        in = newIn;
        addObserver(controller);

    }

    /*@Override
    public void update(SystemEvent event) {
        //This handles the inout and output of messages
        //SystemEvent is an interface that wraps around message event which holds a base message
        //Since base message is the base class, it can be any of the subclasses
        //this function uses the SystemEvent class to indirectly access the base message
        //This function then proceeds to handle each message appropriately



        if(event.getType() == "Sign-in")
        {

        }
        else if(event.getType() == "Disconnection")
        {

        }
        else if(event.getType() == "Active User Request")
        {

        }
    }*/

    @Override
    public void addObserver(Observer newObserver)
    {
        observers.add(newObserver);
    }

    @Override
    public void removeObserver(Observer oldObserver)
    {
        int deleteIndex = observers.indexOf(oldObserver);

        if(deleteIndex > -1)
        {
            observers.remove(oldObserver);
        }
        else
        {
            System.out.println("Observer could not be found");
        }
    }

    @Override
    public void notifyObserver(SystemEvent e)
    {
        for(int i = 0; i < observers.size(); i++)
        {
            observers.get(i).update(????????????);
        }
    }

    @Override
    public void run() {

    }
}
