package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.Subject;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class PacketReceiver implements Runnable
{
    private ObjectInputStream in;
    //private List<Observer> observers;
    private ClientEventLog clientLog = ClientEventLog.getInstance();

    public PacketReceiver(ObjectInputStream newIn)
    {
        in = newIn;
        //observers = new ArrayList<>();
    }



//    @Override
//    public void addObserver(Observer newObserver)
//    {
//        observers.add(newObserver);
//    }
//
//    @Override
//    public void removeObserver(Observer oldObserver)
//    {
//        observers.remove(oldObserver);
//    }
//
//    @Override
//    public void notifyObserver(SystemEvent event)
//    {
//        for(int i = 0; i < observers.size(); i++)
//        {
//            observers.get(i).update(event);
//        }
//    }

    @Override
    public void run()
    {
        boolean listening = true;
        while(listening)
        {
            try
            {
                //get messages from "in"
                Packet message = (Packet) in.readObject();
                BaseMessage data = message.getData();

                SystemEvent messageEvent = new MessageEvent(data);
                clientLog.notifyObserver(messageEvent);

                //Might need to look for message to stop listening
                /*
                if(data instanceOf ShutdownMessage)
                {
                    listening = false;
                }
                 */
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
            catch(ClassNotFoundException ex)
            {
                ex.printStackTrace();
            }


        }//while(listening)
    }
}