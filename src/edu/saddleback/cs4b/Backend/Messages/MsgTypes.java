package edu.saddleback.cs4b.Backend.Messages;

public enum MsgTypes {
    PROFILE("Profile"),
    REG_ERROR("Registration Error"),
    SUCCESS_REG("Successful Registration"),
    SIGN_IN("Sign-in"),
    AUTHENTICATION("Authentication"),
    DENIED("Denied"),
    SIGN_OUT("Sign-out"),
    DISCONNECTION("Disconnection"),
    ACTIVE_USER_REQ("Active User Request"),
    DEACTIVATION("Deactivation"),
    // we will need to add our Reg/Profile

    //Game Messages
    REQUEST_JOIN_GAME("Request to Join Game"),
    CREATE_GAME_MESSAGE("Create Game"),
    REQUEST_GAME_HISTORY("Request Game History");






    private String type;
    private MsgTypes(String type) {
        this.type = type;
    }

    public String getType() { return type; }
}
