package edu.saddleback.cs4b.Backend.PubSub;

import java.io.*;
import java.net.Socket;

public class Client {
    private PacketSender sender;
    private PacketReceiver receiver;
    private Socket socket;
    private int portNumber;
    private String hostName;
    private Thread listeningThread;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    //controller?


    public Client()
    {
        sender   = new PacketSender();
        receiver = new PacketReceiver();

        socket     = null;
        portNumber = -1;
        hostName   = "";
        in         = null;
        out        = null;

        //Creating the listeningThread
        listeningThread = new Thread();
        listeningThread.start();
    }



    public Client(String newHostName, int newPortNumber) {
        sender   = new PacketSender();
        receiver = new PacketReceiver();

        //Establishing socket and IOStreams
        portNumber = newPortNumber;
        hostName   = newHostName;
        createSocket();

        //Creating the listeningThread
        listeningThread = new Thread();
        listeningThread.start();
    }

    private void createSocket()
    {
        try
        {
            socket = new Socket(hostName, portNumber);
            out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.flush();
            in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
