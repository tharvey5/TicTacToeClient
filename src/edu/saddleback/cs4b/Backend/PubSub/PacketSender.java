package edu.saddleback.cs4b.Backend.PubSub;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class PacketSender implements UISubject{
    private ObjectOutputStream out;
    private List<UIObserver> observers;












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






        /*
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
        */

    }
}
