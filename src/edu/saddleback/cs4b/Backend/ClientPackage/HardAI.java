package edu.saddleback.cs4b.Backend.ClientPackage;

import edu.saddleback.cs4b.Backend.Objects.TTTPosition;
import edu.saddleback.cs4b.Backend.Objects.TTTToken;
import edu.saddleback.cs4b.Backend.Objects.Token;

public class HardAI {
    //private Identifiable player;
    private Token usersSpot; // token for the user
    private Token aiToken;   // token for the ai

    Token getAiToken() { return aiToken; }

    public HardAI(Token usersToken)
    {
        this.usersSpot = usersToken;

        // ai is default as the O
        aiToken = new TTTToken("2");
    }

    private TTTPosition spots[] = { new TTTPosition(0,0),
            new TTTPosition(0,2),
            new TTTPosition(2,0),
            new TTTPosition(2,2),
            new TTTPosition(0,1),
            new TTTPosition(1,0),
            new TTTPosition(1,2),
            new TTTPosition(2,1),
            new TTTPosition(1,1)};


    public String getID()
    {
        return "AI";
    }


    public TTTPosition getPlay(Token[][] board, int emptySpots)
    {
        int check = 0;
        int maxVal = -2;
        TTTPosition spot = null;

        while(check < 9)
        {
            int row = spots[check].getXCoord();
            int col = spots[check].getYCoord();
            if(board[row][col] == null)
            {
                board[spots[check].getXCoord()][spots[check].getYCoord()] = aiToken;
                int val= MiniMax(board, spots[check], emptySpots - 1, false, 0);
                if(val > maxVal)
                {
                    spot = spots[check];
                    maxVal = val;
                }
                board[spots[check].getXCoord()][spots[check].getYCoord()] = null;
            }
            check++;
        }

        return spot;
    }

    private int MiniMax(Token[][] board, TTTPosition position, int depth, boolean maximizingPlayer, int numOfChildren)
    {
        if(depth == 0 || LocalLogicChecker.winner(board) != null )
        {
            if (LocalLogicChecker.winner(board) == null) {
                return 0;
            }
            else if (LocalLogicChecker.winner(board) == aiToken) {
                return depth + 1;
            }
            else if (LocalLogicChecker.winner(board) == usersSpot)
            {
                return (numOfChildren*(-1));
            }
        }

        int eval = 0;

        if(maximizingPlayer)
        {
            int maxEval = -1;
            int check = 0;

            while(check < 9)
            {
                if(board[spots[check].getXCoord()][spots[check].getYCoord()] == null) {
                    board[spots[check].getXCoord()][spots[check].getYCoord()] = aiToken;
                    eval = MiniMax(board, spots[check], depth - 1, false, numOfChildren + 1);
                    maxEval = Math.max(maxEval, eval);
                    board[spots[check].getXCoord()][spots[check].getYCoord()] = null;
                }

                check++;
            }
            return maxEval;
        }
        else
        {
            int minEval = 1;
            int check = 0;

            while(check < 9)
            {
                if(board[spots[check].getXCoord()][spots[check].getYCoord()] == null) {
                    board[spots[check].getXCoord()][spots[check].getYCoord()] = usersSpot;
                    eval = MiniMax(board, spots[check], depth - 1, true, numOfChildren + 1);
                    minEval = Math.min(minEval, eval);
                    board[spots[check].getXCoord()][spots[check].getYCoord()] = null;
                }
                check++;
            }
            return minEval;
        }
    }

    public static void main(String[] ar)
    {
//        Identifiable[][] board = new Identifiable[3][3];
//
//        TTTPosition spot = null;
//
//        class TestPlayer implements Identifiable
//        {
//            @Override
//            public String getID() {
//                return "Player";
//            }
//        }
//
//        TestPlayer player = new TestPlayer();
//        HardAIPlayer AI = new HardAIPlayer(player);
//
//        board[0][0] = player;
//        board[1][1] = AI;
//        board[0][1] = player;
//        board[0][2] = AI;
//        board[2][0] = player;
//        board[1][0] = AI;
//        board[1][2] = player;
//
//
//        System.out.println(AI);
//
//        spot = AI.getPlay(board, 4);
//
//        System.out.println(spot.toString());
    }
}
