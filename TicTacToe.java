import java.util.Scanner;
public class TicTacToe
{
    private static final int ROWS = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROWS][COL];

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain)
        {

            clearBoard();
            String currentPlayer = "X";
            boolean gameOver = false;


            while (!gameOver)
            {
                display();
                System.out.println("Player " + currentPlayer + "'s turn.");
                System.out.print("Enter row (1-3): ");
                int row = scanner.nextInt() - 1;
                System.out.print("Enter column (1-3): ");
                int col = scanner.nextInt() - 1;


                if (isValidMove(row, col))
                {
                    board[row][col] = currentPlayer;

                    if (isWin(currentPlayer))
                    {
                        display();
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameOver = true;
                    }
                    else if (isTie())
                    {
                        display();
                        System.out.println("It's a tie!");
                        gameOver = true;
                    }
                    else
                    {

                        currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                    }
                }

                else
                {
                    System.out.println("Invalid move, try again.");
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next();

            if (response.equalsIgnoreCase("n"))
            {
                playAgain = false;
            }
        }
    }


    private static void clearBoard()
    {
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                board[i][j] = " ";
            }
        }
    }
    private static void display()
    {
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player)
    {
        for (int i = 0; i < ROWS; i++)
        {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player)
    {
        for (int i = 0; i < COL; i++)
        {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie()
    {
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                if (board[i][j].equals(" "))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    Start the game
    Clear the board
    Set current player to X

    While game is not over:
    Show the current board
    Get player move

    If the move is valid:
    Mark the board with the player symbol
    If the player wins:
    Show the board
    Print the winner(X or O)
    End the game
    Else if there is a tie:
    Show the board
    Print that there was a tie
    End the game
    Else:
    Switch to the next player (X becomes O, O becomes X)
    Else:
    Tell player that the move is invalid

    Ask to play again
    If yes:
    Clear the board
    Restart the game */


}
