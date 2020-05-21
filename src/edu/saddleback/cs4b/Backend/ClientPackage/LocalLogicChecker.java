package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Objects.Token;

public class LocalLogicChecker {
    public static Token winner(Token[][] board) {
        return checkForWinner(board);
    }

    static Token checkForWinner(Token[][] board) {
        Token winner = horizontalWinner(board);
        if (winner != null) {
            return winner;
        } else if ((winner = verticalWinner(board)) != null) {
            return winner;
        } else if((winner = diagonalWinner(board)) != null) {
            return winner;
        }
        return winner;
    }

    private static Token diagonalWinner(Token[][] board) {
        if (board[0][0] == board[1][1] &&
                board[1][1] == board[2][2] &&
                board[0][0] != null) {
            return board[1][1];
        }

        if (board[0][2] == board[1][1] &&
                board[1][1] == board[2][0] &&
                board[0][2] != null) {
            return board[1][1];
        }
        return null;
    }

    private static Token verticalWinner(Token[][] board) {
        for (int i = 0; i < board.length; ++i) {
            if (board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i] &&
                    board[0][i] != null) {
                return board[0][i];
            }
        }
        return null;
    }

    private static Token horizontalWinner(Token[][] board) {
        for (Token[] row : board) {
            if (row[0] == row[1] &&
                    row[1] == row[2] &&
                    row[0] != null) {
                return row[0];
            }
        }
        return null;
    }
}
