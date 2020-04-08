package edu.saddleback.cs4b.Backend.PubSub;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private PacketSender sender;
    private PacketReceiver receiver;
    private Socket socket;
    private Thread listeningThread;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private int portNumber;
    //controller


}
