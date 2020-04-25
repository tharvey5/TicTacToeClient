package edu.saddleback.cs4b.Backend.Messages;

public class GameMessageFactory implements AbstractMessageFactory {
    @Override
    public BaseMessage createMessage(String type) {
        BaseMessage message = null;

        if (type.equals(MsgTypes.AVAILABLE_GAME.getType()))
        {
            message = new AvailableGameMessage();
        }
        else if (type.equals(MsgTypes.CREATE_GAME.getType()))
        {
            message = new CreateGameMessage();
        }
        else if (type.equals(MsgTypes.DISCONNECTION.getType()))
        {
            message = new DisconnectMessage();
        }
        else if (type.equals(MsgTypes.GAME_HISTORY_REQUEST.getType()))
        {
            message = new GameHistoryRequestMessage();
        }
        else if (type.equals(MsgTypes.GAME_HISTORY_RESPONSE.getType()))
        {
            message = new GameHistoryResponseMessage();
        }
        else if (type.equals(MsgTypes.GAME_NOT_CREATED.getType()))
        {
            message = new GameNotCreatedMessage();
        }
        else if (type.equals(MsgTypes.GAME_RESULT.getType()))
        {
            message = new GameResultMessage();
        }
        else if (type.equals(MsgTypes.GAME_CREATED.getType()))
        {
            message = new GameSuccessfullyCreatedMessage();
        }
        else if (type.equals(MsgTypes.INVALID_MOVE.getType()))
        {
            message = new InvalidMoveMessage();
        }
        else if (type.equals(MsgTypes.JOIN_GAME_REQUEST.getType()))
        {
            message = new JoinGameRequestMessage();
        }
        else if (type.equals(MsgTypes.MOVE.getType()))
        {
            message = new MoveMessage();
        }
        else if (type.equals(MsgTypes.NO_GAME_TO_VIEW.getType()))
        {
            message = new NoGameToViewMessage();
        }
        else if (type.equals(MsgTypes.REQUEST_ALL_GAMES.getType()))
        {
            message = new RequestAllActiveGamesMessage();
        }
        else if (type.equals(MsgTypes.RETURN_ACTIVE_GAMES.getType()))
        {
            message = new ReturnAllActiveGamesMessage();
        }
        else if (type.equals(MsgTypes.SET_TOKEN_ERROR.getType()))
        {
            message = new SetTokenErrorMessage();
        }
        else if (type.equals(MsgTypes.SET_TOKEN.getType()))
        {
            message = new SetTokenMessage();
        }
        else if (type.equals(MsgTypes.SUCCESS_SET_TOKEN.getType()))
        {
            message = new SuccessfulSetTokenMessage();
        }
        else if (type.equals(MsgTypes.SUCCESS_VIEW_GAME.getType()))
        {
            message = new SuccessfulViewGameMessage();
        }
        else if (type.equals(MsgTypes.UNAVAILABLE_GAME.getType()))
        {
            message = new UnavailableGameMessage();
        }
        else if (type.equals(MsgTypes.VALID_MOVE.getType()))
        {
            message = new ValidMoveMessage();
        }
        else if (type.equals(MsgTypes.VIEW_GAME_REQUEST.getType()))
        {
            message = new ViewGameRequestMessage();
        }

        return message;
    }
}
