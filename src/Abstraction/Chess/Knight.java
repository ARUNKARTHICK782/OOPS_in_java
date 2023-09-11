package Abstraction.Chess;

public class Knight extends ChessPiece{
    public Knight(int x, int y, String color) {
        super(x, y, color);
    }



    @Override
    void move(ChessPiece[][] chessPieces,int fromX, int fromY,int toX,int toY) {
        if(fromX+2 == toX && (fromY+1 == toY || fromY-1 == toY)){
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
        }
        else if(fromX-2 == toX && (fromY+1 == toY || fromY-1 ==toY)){
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
        }
        else if(fromY+1 == toY && (fromX+2 == toX || fromX-2 == toX)){
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
        }
        else if(fromY-1 == toY && (fromX+2 == toX || fromX-2 == toX)){
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
        }
        else{
            System.out.println("Invalid move");
        }
    }

    @Override
    public String toString() {
        return getColor().equals("WHITE")?"♞":"♘";
    }
}
