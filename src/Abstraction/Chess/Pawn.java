package Abstraction.Chess;

public class Pawn extends ChessPiece{
    boolean initialStepFinished;


    Pawn(int x,int y,String color){
        super(x,y,color);
        initialStepFinished = false;
    }


    @Override
    void move(ChessPiece[][] chessPieces,int fromX, int fromY,int toX,int toY) {

        // If its pawns first move then it can move 2 steps ahead or else 1 step at the start
        // It can cut across columns but only one column to the right or to the left diagonal

        if(fromY == toY){
            if(Math.abs(toX-fromX) > 2 || toY>7 || toX>7){
                System.out.println("Invalid");
            }
            else if(initialStepFinished == false && Math.abs(toX-fromX)<=2){
                System.out.println("Valid");
                swapPosition(chessPieces,fromX,fromY,toX,toY,this);
                initialStepFinished = true;
            }
        }
        else if(Math.abs(toY-fromY) == 1){
            if((toX-fromX) > 2){
                System.out.println("Invalid");
            }
            else{
                System.out.println("Valid");
                swapPosition(chessPieces,fromX,fromY,toX,toY,this);
            }
        }
        else{
            System.out.println("Invalid");
        }


    }

    @Override
    public String toString() {
        return getColor().equals("WHITE")?"♟":"♙";
    }
}
