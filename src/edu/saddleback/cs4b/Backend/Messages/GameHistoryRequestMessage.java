package edu.saddleback.cs4b.Backend.Messages;

public class GameHistoryRequestMessage extends BaseMessage {

    GameHistoryRequestMessage()
    {
        super(MsgTypes.GAME_HISTORY_REQUEST);
    }
}
