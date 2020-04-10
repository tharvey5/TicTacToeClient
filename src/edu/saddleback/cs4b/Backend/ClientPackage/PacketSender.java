package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Messages.AdminMessageFactory;
import edu.saddleback.cs4b.Backend.Messages.BaseMessage;
import edu.saddleback.cs4b.Backend.Messages.Packet;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.PubSub.UIObserver;
import edu.saddleback.cs4b.Backend.PubSub.UISubject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PacketSender implements UIObserver {
    private ObjectOutputStream out;
    private UISubject subject;
    private AdminMessageFactory messageFactory;


    public PacketSender()
    {
        this(null, null);
    }


    public PacketSender(ObjectOutputStream newOut, UISubject newSubject)
    {
        subject = newSubject;
        out = newOut;
        messageFactory = new AdminMessageFactory();
    }





    @Override
    public void update(SystemEvent event)
    {
        String messageType;

        if(event instanceof MessageEvent)
        {
            messageType = event.getType();
        }
        else
        {
            System.out.println("Not a valid event");
            return;
        }

        BaseMessage nextMessage = messageFactory.createMessage(messageType);

        sendMessage(nextMessage);
    }


    private void sendMessage(BaseMessage nextMessage)
    {
        try
        {
            out.writeObject(nextMessage);
            out.flush();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

}
