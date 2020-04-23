package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Messages.AdminMessageFactory;
import edu.saddleback.cs4b.Backend.Messages.BaseMessage;
import edu.saddleback.cs4b.Backend.Messages.Packet;
import edu.saddleback.cs4b.Backend.Messages.SignOutMessage;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.PubSub.UIObserver;
import edu.saddleback.cs4b.Backend.PubSub.UISubject;
import edu.saddleback.cs4b.UI.UIEventLog;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PacketSender implements UIObserver {
    private ObjectOutputStream out;
    private AdminMessageFactory messageFactory;

    public PacketSender()
    {
        this(null);
    }


    public PacketSender(ObjectOutputStream newOut)
    {
        out = newOut;
        messageFactory = new AdminMessageFactory();
        UIEventLog.getInstance().addObserver(this);
    }

    @Override
    public void update(SystemEvent event)
    {
//        String messageType;
//
//        if(event instanceof MessageEvent)
//        {
//            messageType = ((MessageEvent) event).getMessage().getMessageType();
//        }
//        else
//        {
//            System.out.println("Not a valid event");
//            return;
//        }

        BaseMessage nextMessage = ((MessageEvent) event).getMessage();

        sendMessage(nextMessage);
    }

    private void sendMessage(BaseMessage nextMessage)
    {
        try
        {
            out.writeObject(new Packet(nextMessage));
            out.flush();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
