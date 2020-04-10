package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Messages.Packet;
import edu.saddleback.cs4b.Backend.Messages.SignInMessage;
import edu.saddleback.cs4b.Backend.PubSub.Observer;
import edu.saddleback.cs4b.Backend.PubSub.Subject;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;

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
                //List of if else's determining what to do wit messages
            }
            catch()
            {
                //List of catches responding to different types of errors
            }
        }//while(listening)
    }
}










/*
public class ChatListener implements ClientSubject, Runnable {

    private Receivable receivable;
    private ArrayList<ClientObserver> observers;
    private ObjectInputStream in;





    @Override
    public void run() {
        boolean listening = true;
        while (listening)
        {
            try
            {
                Packet message = (Packet) in.readObject();
                Serializable data = message.getData();
                if (data instanceof TextMessage)
                {
                    receivable = new UIDisplayData(ReceiveTypes.TEXT_AREA,
                            (TextMessage)data,
                            ((TextMessage) data).getChannel());
                    notifyObservers();
                }
                else if (data instanceof PicMessage)
                {
                    receivable = new UIDisplayData(ReceiveTypes.TEXT_AREA, data, (
                            (PicMessage) data).getChannel());
                    notifyObservers();
                } else if (data instanceof DisconnectMessage) {
                    listening = false;
                } else if (data instanceof RequestMessage) {
                    receivable = new UIDisplayData(ReceiveTypes.TEXT_AREA, data,
                            ((RequestMessage) data).getChannel());
                    notifyObservers();
                }
            }
            catch (SocketException socketEx)
            {
                listening = false;
            }
            catch (EOFException eof)
            {
                listening = false;
                String error = "Server has been unexpectedly shutoff, please restart";
                TextMessage offlineServerMsg = new TextMessage("SERVER", "", error);
                receivable = new UIDisplayData(ReceiveTypes.TEXT_AREA,
                        offlineServerMsg,
                        "");
                notifyObservers();
            }
            catch (IOException ioEx)
            {
                ioEx.printStackTrace();
            }
            catch (ClassNotFoundException notFoundEx)
            {
                notFoundEx.printStackTrace();
            }
        }//END while (listening)
    }//end public void run()



}
 */