package edu.saddleback.cs4b.Backend.PubSub;

import edu.saddleback.cs4b.Backend.Messages.SignInMessage;

public class PacketReceiver implements UIObserver{
    @Override
    public void update(SystemEvent event) {
        //This handles the inout and output of messages
        //SystemEvent is an interface that wraps around message event which holds a base message
        //Since base message is the base class, it can be any of the subclasses
        //this function uses the SystemEvent class to indirectly access the base message
        //This function then proceeds to handle each message appropriately



        if(event.getType() == "Sign-in")
        {

        }
        else if(event.getType() == "Disconnection")
        {

        }
        else if(event.getType() == "Active User Request")
        {

        }







    }
}
