package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Messages.Packet;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.PubSub.UIObserver;
import edu.saddleback.cs4b.Backend.PubSub.UISubject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PacketSender implements UIObserver {
    private ObjectOutputStream out;
    private List<UIObserver> observers;
    private UISubject subject;

    public PacketSender(ObjectOutputStream newOut, UISubject newSubject)
    {
        subject = newSubject;
        out = newOut;
    }


    @Override
    public void update(SystemEvent e)
    {

        /*
        public void update(Sendable data) {
        String type = data.getType();
        if (type.equals(SendTypes.MESSAGE.getType()))
        {
            UIFields messageField = (UIFields)data;
            if (messageField.getValue() instanceof TextMessage)
            {
                TextMessage message = (TextMessage) messageField.getValue();
                focusedChannel = message.getChannel();
                sendMessage(message);
            }
            else if (messageField.getValue() instanceof PicMessage)
            {
                sendPicture((PicMessage)messageField.getValue());
            }
        }
        else if (type.equals(SendTypes.JOIN.getType()))
        {
            UIFields message = (UIFields)data;
            RegMessage reg = (RegMessage)message.getValue();
            register(reg);
        }
        else if (type.equals(SendTypes.CHANNEL.getType()))
        {
            UIFields message = (UIFields)data;
            UpdateMessage um = (UpdateMessage)message.getValue();
            updateChannels(um);
        } else if (type.equals(SendTypes.LEAVE.getType()))
        {
            UIFields discon = (UIFields)data;
            DisconnectMessage disMsg = (DisconnectMessage)discon.getValue();
            try
            {
                out.writeObject(new Packet(MessageType.DISCONNECT.getType(), disMsg));
                out.flush();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        else if (type.equals(SendTypes.HISTORY_REQUEST.getType()))
        {
            UIFields req = (UIFields)data;
            RequestMessage historyRequest = (RequestMessage)req.getValue();
            try
            {
                out.writeObject(new Packet(MessageType.HISTORY_REQUEST.getType(), historyRequest));
                out.flush();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
         */
    }







    /*
    @Override
    public void addObserver(UIObserver newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void removeObserver(UIObserver oldObserver) {
        observers.remove(oldObserver);
    }

    @Override
    public void notifyObservers(SystemEvent e) {
        try
        {
            out.writeObject();
            out.flush();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }







          public void update(Sendable data) {
        String type = data.getType();
        if (type.equals(SendTypes.MESSAGE.getType()))
        {
            UIFields messageField = (UIFields)data;
            if (messageField.getValue() instanceof TextMessage)
            {
                TextMessage message = (TextMessage) messageField.getValue();
                focusedChannel = message.getChannel();
                sendMessage(message);
            }
            else if (messageField.getValue() instanceof PicMessage)
            {
                sendPicture((PicMessage)messageField.getValue());
            }
        }
        else if (type.equals(SendTypes.JOIN.getType()))
        {
            UIFields message = (UIFields)data;
            RegMessage reg = (RegMessage)message.getValue();
            register(reg);
        }
        else if (type.equals(SendTypes.CHANNEL.getType()))
        {
            UIFields message = (UIFields)data;
            UpdateMessage um = (UpdateMessage)message.getValue();
            updateChannels(um);
        } else if (type.equals(SendTypes.LEAVE.getType()))
        {
            UIFields discon = (UIFields)data;
            DisconnectMessage disMsg = (DisconnectMessage)discon.getValue();
            try
            {
                out.writeObject(new Packet(MessageType.DISCONNECT.getType(), disMsg));
                out.flush();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        else if (type.equals(SendTypes.HISTORY_REQUEST.getType()))
        {
            UIFields req = (UIFields)data;
            RequestMessage historyRequest = (RequestMessage)req.getValue();
            try
            {
                out.writeObject(new Packet(MessageType.HISTORY_REQUEST.getType(), historyRequest));
                out.flush();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
        */




}
