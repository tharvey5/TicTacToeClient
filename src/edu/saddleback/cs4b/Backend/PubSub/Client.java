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

    private String userName;
    private String userID;
    /*
    constructor sets it to ""
    When client is signing in, it attempts to set userName to the name given, but only once the receiver gets an authentification message saying that it's valid
    Sign out method resets data member to ""
    Call this method when shutting down program
    */


    public void signIn()
    {

    }

    public void signOut()
    {
        sender.update(SIGN_OUT);

        userName = "";
        userID   = null;
    }

    public Client()
    {
        this("", -1);
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

    private void startUp()
    {
        if(out != null && in != null)
        {
            createSocket();
            this.sender          = new PacketSender(out, controller);
            this.receiver        = new PacketReceiver(in, controller);
            this.listeningThread = new Thread(receiver);
            listeningThread.start();
        }
        else
        {
            sender          = null;
            receiver        = null;
            listeningThread = null;
        }

    }


}
