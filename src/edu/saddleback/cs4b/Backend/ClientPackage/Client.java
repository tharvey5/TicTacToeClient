package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.PubSub.Subject;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.PubSub.UIObserver;
import edu.saddleback.cs4b.Backend.PubSub.UISubject;

import java.io.*;
import java.net.Socket;

public class Client implements UIObserver {
    private PacketSender sender;
    private PacketReceiver receiver;
    private Socket socket;
    private int portNumber = 8080;
    private String hostName;
    private Thread listeningThread;
    private ObjectInputStream in;
    private ObjectOutputStream out;


    public Client()
    {
        this("", -1, null, null);
    }

    public Client(String newHostName, int newPortNumber, UISubject uiPublisher, Subject clientPublisher)
    {
        //Establishing socket and IOStreams
        portNumber = newPortNumber;
        hostName   = newHostName;

        // V no such method exits at the time
        //controller.registerObserver(this);


        //creating socket, sender, reciever
        startUp(uiPublisher, clientPublisher);
    }

    private void createSocket()
    {
        try
        {
            socket  = new Socket(hostName, portNumber);
            out     = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.flush();
            in      = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            socket  = null;
            out     = null;
            in      = null;
        }
    }

    private void startUp(UISubject uiPublisher, Subject clientPublisher)
    {
        createSocket();
        this.sender          = new PacketSender(out, uiPublisher);
        this.receiver        = new PacketReceiver(in, clientPublisher);
        this.listeningThread = new Thread(receiver);
        listeningThread.start();
//        if(out != null && in != null)
//        {
//            createSocket();
//            this.sender          = new PacketSender(out);
//            this.receiver        = new PacketReceiver(in);
//            this.listeningThread = new Thread(receiver);
//            listeningThread.start();
//        }
//        else
//        {
//            sender          = null;
//            receiver        = null;
//            listeningThread = null;
//        }

    }


    @Override
    public void update(SystemEvent e) {

    }
}
