package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Messages.SignInMessage;
import edu.saddleback.cs4b.Backend.PubSub.MessageEvent;
import edu.saddleback.cs4b.Backend.PubSub.SystemEvent;
import edu.saddleback.cs4b.Backend.Utilitys.TTTUser;
import edu.saddleback.cs4b.Backend.Utilitys.User;
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

    public void signIn()
    {
        //Get username and password from UI
        User user; //= FROM UI

        //Send it to server for verification
        sender.update((SystemEvent) new SignInMessage((User)user));

        //if verification true, set username Authenticated Message, Denial message
        //else verification false, don't set username, have UI display error message
        if()
        {
            signIn();
        }
        else if()
        {

        }






        //in client, call sender.update(signInMessage)
        //if PacketReceiver receves an authenification message, call the sign in method for sender and set the name and ID

        TTTUser user = //FROM UI

        sender.signIn(user);
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
