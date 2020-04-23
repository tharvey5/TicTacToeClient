package edu.saddleback.cs4b.Backend.Messages;

public class GameMessageFactory implements AbstractMessageFactory {
    @Override
    public BaseMessage createMessage(String type) {
        BaseMessage message = null;
        if (type.equals(MsgTypes.VIEW_GAME_REQUEST.getType())) {
            message = new ViewGameRequestMessage();
        }
        else if (type.equals(MsgTypes.GAME_HISTORY_REQUEST.getType())) {
            message = new GameHistoryRequestMessage();
        }
        else if (type.equals(MsgTypes.ACTIVE_GAMES.getType())) {
            message = new GetAllActiveGamesMessage();
        }
        else if (type.equals(MsgTypes.MOVE.getType())) {
            message = new MoveMessage();
        }
        else if (type.equals(MsgTypes.INVALID_MOVE.getType())) {
            message = new InvalidMoveMessage();
        }
        else if (type.equals(MsgTypes.GAME_RESULT.getType())) {
            message = new GameResultMessage();
        }
        else if (type.equals(MsgTypes.JOIN_GAME_REQUEST.getType())) {
            message = new JoinGameRequestMessage();
        }
        else if (type.equals(MsgTypes.CREATE_GAME.getType())) {
            message = new CreateGameMessage();
        }
        else if (type.equals(MsgTypes.GAME_HISTORY_RESPONSE.getType())) {
            message = new GameHistoryResponseMessage();
        }
        return message;
    }
}
