package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Messages.*;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.Subject;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;

import java.io.IOException;
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
    public void notifyObserver(SystemEvent event)
        {
        for(int i = 0; i < observers.size(); i++)
        {
            observers.get(i).update(event);
        }
    }

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


                //List of if else's determining what to do with messages
                if(data instanceof SuccessfulRegistration)
                {

                }
                else if(data instanceof RegistrationErrorMessage)
                {

                }
                else if(data instanceof AuthenticatedMessage)
                {

                }
                else if(data instanceof DeniedEntryMessage)
                {

                }
                else if(data instanceof DisconnectMessage)
                {

                }
                else if(data instanceof ActiveUserMessage)
                {

                }
                else //invalid message
                {
                    System.out.println("Invalid message type sent");
                }



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