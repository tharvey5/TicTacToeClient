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
    VIEW_GAME_REQUEST("View Game Request"),
    GAME_HISTORY_RESPONSE("Game History Response"),
    ACTIVE_GAMES("Active_Game"),
    MOVE("Move"),
    INVALID_MOVE("Invalid Move"),
    GAME_RESULT("Game Result"),
    JOIN_GAME_REQUEST("Request to Join Game"),
    CREATE_GAME("Create Game"),
    GAME_HISTORY_REQUEST("Request Game History");






    private String type;
    private MsgTypes(String type) {
        this.type = type;
    }

    public String getType() { return type; }
}
