package edu.saddleback.cs4b.Backend.PubSub;

import sample.Controller;

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
    private Controller controller;


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

    public Client(String newHostName, int newPortNumber)
    {
        //Establishing socket and IOStreams
        portNumber = newPortNumber;
        hostName   = newHostName;

        controller = new Controller();
        // V no such method exits at the time
        //controller.registerObserver(this);


        //creating socket, sender, reciever
        startUp();
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

    private void startUp()
    {
        if(out != null && in != null)
        {
            createSocket();
            this.sender = new PacketSender(out, controller);
            this.receiver = new PacketReceiver(in, controller);
            this.listeningThread = new Thread(receiver);
            listeningThread.start();
        }

    }
}
