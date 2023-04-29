import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){

        // 3x3 array for tic tac toe board
        char[][] board = new char[3][3];
        
        // init empty board with dashes
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                board[i][j] = '-';
            }
        }
    

    
    Scanner input = new Scanner(System.in);
    System.out.println("May the best person win");
    System.out.println("Player 1 (Xs): What's your name?");
    String p1 = input.nextLine();
    System.out.println("Great! Now let's get Player 2's name (Os):");
    String p2 = input.nextLine();
    
    boolean player1 = true;
    boolean gameOver = false;
    
    while(!gameOver){
        drawBoard(board);
        char c = '-';
        if(player1) {
            System.out.println(p1+"'s turn (Xs):");
            c = 'X';
        } else {
            System.out.println(p2+"'s turn (Os):");
            c = 'O';
        }
        
        // Now we play!
        int row = 0;
        int col = 0;
        
        while(true){
            input.useDelimiter("\\D");
            System.out.println("Enter a row and col separated by a comma to play one of (0, 1, 2):");
            row = input.nextInt();
            col = input.nextInt();


            if(row > 2 || row < 0 || col > 2 || col < 0){
                System.out.println("Whoa slow down there. That's not a position on the board! Try again: only 0,1,2 are allowed");
            } else if(board[row][col] != '-'){
                System.out.println("Whoops! That spot is taken. Try again");
            } else {
                break;
            }
        }
    
        board[row][col] = c;

        // check if there's a winner

        char winner  = winner(board);
        if(winner == 'X'){
            drawBoard(board);
            System.out.println("And in a stunning defeat... " + p1 + " Wins!");
            gameOver = true;
        } else if(winner == 'O'){
            drawBoard(board);
            System.out.println("This just in: " + p2 + " is the victor!");
            gameOver = true;
        } else {
        // check if it's a tie
        if(itsTied(board)){
            drawBoard(board);
            System.out.println("Womp womp. No winners here: it's a tie!");
            gameOver = true;
        } else {
            player1 = !player1;
            }
        
            }
        }
    input.close();
    }


    public static void drawBoard(char[][] board){
        System.out.println("Tic Tac Toe:");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    public static char winner(char[][] board){

        // rows
        for(int i = 0; i < 3; i++){
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-'){
                return board[i][0];
            }

            }
        
        // cols
        for(int j = 0; j < 3; j++){
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-'){
                return board[0][j];
            }
        } 
        // diagonals
        if(board[0][0] == board[1][1] && board[1][1]== board[2][2] && board[0][0]!='-'){
            return board[0][0];
            } else if(board[2][0]==board[1][1] && board[1][1]== board[0][2] && board[2][0]!='-'){
                return board[2][0];
            }
        
        // no winner
        return ' ';
    }

    public static boolean itsTied(char[][] board){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                // return false if there are any blank spaces left
                if(board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }


}
