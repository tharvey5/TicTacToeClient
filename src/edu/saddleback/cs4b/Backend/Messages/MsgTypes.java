package edu.saddleback.cs4b.Backend.Messages;

public enum MsgTypes {


    DEACTIVATION("Deactivation"),
    ACTIVE_USER("Active User"),
    ACTIVE_USER_RESPONSE("Active User Response"),
    AUTHENTICATION("Authentication"),
    AVAILABLE_GAME("Available Game"),
    CREATE_GAME("Create Game"),
    DEACTIVATION_CONFIRM("Deactivation Confirmation"),
    DENIED("Denied"),
    DISCONNECTION("Disconnection"),
    GAME_HISTORY_REQUEST("Request Game History"),
    GAME_HISTORY_RESPONSE("Game History Response"),
    GAME_NOT_CREATED("Game Not Created"),
    GAME_RESULT("Game Result"),
    GAME_CREATED("Game Successfully Created"),
    INVALID_MOVE("Invalid Move"),
    INVALID_PROFILE_UPDATE("Invalid Profile Update"),
    JOIN_GAME_REQUEST("Request to Join Game"),
    MOVE("Move"),
    NO_GAME_TO_VIEW("No Game to View"),
    REG_ERROR("Registration Error"),
    REGISTRATION("Registration"),
    REQUEST_ALL_GAMES("Request All Active Games"),
    RETURN_ACTIVE_GAMES("Active_Game"),
    SIGN_IN("Sign-in"),
    SIGN_OUT_CONFIRM("Sign Out Confirmation"),
    SIGN_OUT("Sign-out"),
    SUCCESSFUL_VIEW_GAME("Successful View Game");



    PROFILE("Profile"),



    SUCCESS_REG("Successful Registration"),
    VIEW_GAME_REQUEST("View Game Request");


    private String type;
    private MsgTypes(String type) {
        this.type = type;
    }

    public String getType() { return type; }
}
