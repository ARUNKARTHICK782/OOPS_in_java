package Abstraction.Chess;

public class King extends  ChessPiece{
    public King(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    void move(ChessPiece[][] chessPieces,int fromX, int fromY,int toX,int toY) {
        if(Math.abs(toX-fromX) == 1 || Math.abs(toY-fromY) == 1){
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
        }
        else{
            System.out.println("Invalid move");
        }
    }

    @Override
    public String toString() {
        return getColor().equals("WHITE")?"♚":"♔";
    }
}
