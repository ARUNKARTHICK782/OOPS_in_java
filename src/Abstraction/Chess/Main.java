package Abstraction.Chess;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ChessPiece[][] chessPieces = new ChessPiece[8][8];

    static void initializeChessPieces(){
        //Initializing white pieces
        chessPieces[0][0] = new Rook(0,0,Color.player1Color);
        chessPieces[0][1] = new Knight(0,1,Color.player1Color);
        chessPieces[0][2] = new Bishop(0,2,Color.player1Color);
        chessPieces[0][3] = new Queen(0,3,Color.player1Color);
        chessPieces[0][4] = new King(0,4,Color.player1Color);
        chessPieces[0][5] = new Bishop(0,5,Color.player1Color);
        chessPieces[0][6] = new Knight(0,6,Color.player1Color);
        chessPieces[0][7] = new Rook(0,7,Color.player1Color);

        for(int col = 0;col<=7;col++){
//            chessPieces[1][col] = new Pawn(1,col,Color.player1Color);
            chessPieces[1][col] = new Pawn(1,col,Color.player1Color);
        }

        //Initializing black pieces
        chessPieces[7][0] = new Rook(7,0,Color.player2Color);
        chessPieces[7][1] = new Knight(7,1,Color.player2Color);
        chessPieces[7][2] = new Bishop(7,2,Color.player2Color);
        chessPieces[7][3] = new Queen(7,3,Color.player2Color);
        chessPieces[7][4] = new King(7,4,Color.player2Color);
        chessPieces[7][5] = new Bishop(7,5,Color.player2Color);
        chessPieces[7][6] = new Knight(7,6,Color.player2Color);
        chessPieces[7][7] = new Rook(7,7,Color.player2Color);

        for(int col = 0;col<=7;col++){
            chessPieces[6][col] = new Pawn(6,col,Color.player2Color);
        }

        for(int row=2;row<=5;row++){
            for(int col=0;col<=7;col++){
                chessPieces[row][col] = null;
            }
        }

    }

    static void printChessBoard(){
        for(int row=-1;row<=7;row++){
            if(row==-1)
                System.out.print("  ");
            else
                System.out.print(row+" ");
        }
        System.out.println();
        for(int row=7;row>=0;row--){
            System.out.print(row+" ");
            for(int col=0;col<=7;col++){
                if(chessPieces[row][col] != null)
                    System.out.print(chessPieces[row][col]+" ");
                else{
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        initializeChessPieces();
        printChessBoard();
        Scanner scanner = new Scanner(System.in);
        int fromX,fromY,toX,toY;
        while (true){
            System.out.println("Source : ");

            fromX = scanner.nextInt();
            scanner.nextLine();

            if(fromX == -1)
                break;

            fromY = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Destination : ");

            toX = scanner.nextInt();
            scanner.nextLine();

            toY = scanner.nextInt();
            scanner.nextLine();

            chessPieces[fromX][fromY].move(chessPieces,fromX,fromY,toX,toY);
            printChessBoard();
        }

    }
}
