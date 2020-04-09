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
    private UISubject subject;



    public PacketSender(ObjectOutputStream newOut, UISubject newSubject)
    {
        subject = newSubject;
        out = newOut;
    }


    @Override
    public void update(SystemEvent e)
    {

        //massive if else that calls appropriate method to send and or create functions



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
public class ChatSender implements UIObserver {

    private String username;





    @Override
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

    // repeat code will be later refactored to be more concise
    private void updateChannels(UpdateMessage updateMessage)
    {
        try
        {
            out.writeObject(new Packet(MessageType.IMAGE.getType(), updateMessage));
            out.flush();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private void register(RegMessage regMessage)
    {
        try
        {
            out.writeObject(new Packet(MessageType.REGISTRATION.getType(), regMessage));
            out.flush();

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (NullPointerException ne)
        {
            // should figure out a way later to have this solely handled by controller
            // better infrastructure in-place where this happens with sent message
            Platform.runLater(()-> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Server appears to be offline. Please exit and try again later");
                alert.showAndWait();
            });
        }
    }
 */




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
