package ProjectTicTacToe;

import java.util.*;

public class TicTacToe {
     static ArrayList<Integer> playerPositions = new ArrayList<>();
     static ArrayList<Integer> cpuPositions = new ArrayList<>();
    public static void main(String[] args) {
        char[][] board ={
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
        };
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Enter the Position:(1-9)");
            int pos = in.nextInt();
            while(playerPositions.contains(pos)|| cpuPositions.contains(pos)){
                System.out.println("Place Already Take try differnt place :");
                pos = in.nextInt();
            }
            placePieces(board, pos, "player");
            String result = checkWinner();
            if(result.length() > 0){
                printBoard(board);
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos)|| cpuPositions.contains(cpuPos)){
                cpuPos = rand.nextInt(9) + 1;
            }
            placePieces(board, cpuPos, "cpu");
            printBoard(board);

             result = checkWinner();
             if(result.length()>0){
                 printBoard(board);
                 System.out.println(result);
                 break;
             }
        }
     }

    private static void placePieces(char[][] board, int pos,String user) {
        char p =' ';
        if(user.equals("player")){
            p='X';
            playerPositions.add(pos);
        }
        else if(user.equals("cpu")){
            p='O';
            cpuPositions.add(pos);
        }
        switch (pos){
            case 1 :
                board[0][0] = p;
                break;
            case 2 :
                board[0][2] = p;
                break;
            case 3 :
                board[0][4] = p;
                break;
            case 4 :
                board[2][0] = p;
                break;
            case 5 :
                board[2][2] = p;
                break;
            case 6 :
                board[2][4] = p;
                break;
            case 7 :
                board[4][0] = p;
                break;
            case 8 :
                board[4][2] = p;
                break;
            case 9 :
                board[4][4] = p;
                break;
            default:
                break;
        }
    }
    static void printBoard(char[][] board){
        for (char[] row : board){
            for (char ch : row){
                System.out.print(ch);
            }
            System.out.println();
        }
    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);


        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l : winning){
            if(playerPositions.containsAll(l))
               return "Congratulations you Won! ";
            else if(cpuPositions.containsAll(l))
                return "CPU wins! Sorry :(";
            else if(playerPositions.size() + cpuPositions.size() == 9)
                return "CAT";

        }return "";
    }
}

