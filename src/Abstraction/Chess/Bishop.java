package Abstraction.Chess;

public class Bishop extends ChessPiece{
    public Bishop(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    void move(ChessPiece[][] chessPieces,int fromX, int fromY,int toX,int toY) {
        if (Math.abs(fromX - toX) != Math.abs(fromY - toY)) {
            System.out.println("Invalid move");
            return;
        }
        int tFromX = fromX;
        int tToX = toX;
        int tFromY = fromY;
        int tToY = toY;
        if(toX > fromX && toY > fromY){
            System.out.println(1);
            tFromX = fromX+1;
            tFromY = fromY+1;
            while (tToX != tFromX && tToY != tFromY){
                if(chessPieces[tFromX][tFromY] != null){
                    System.out.println("Invalid move some piece is in between the path");
                    return;
                }
                tFromX++;
                tFromY++;
            }
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
            System.out.println("Valid move");
        }
        else if(toX > fromX && toY < fromY){
            System.out.println(2);
            tFromX = fromX+1;
            tFromY = fromY-1;
            while (tToX != tFromX && tToY != tFromY){
                if(chessPieces[tFromX][tFromY] != null){
                    System.out.println("Invalid move some piece is in between");
                    return;
                }
                tFromX++;
                tFromY--;
            }
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
        }
        else if(toX < fromX && toY > fromY){
            System.out.println(3);
            tFromX = fromX-1;
            tFromY = fromY+1;
            while (tToX != tFromX && tToY != tFromY){
                System.out.println("X : "+tFromX+" Y : "+tFromY);
                if(chessPieces[tFromX][tFromY] != null){
                    System.out.println("Invalid move some piece is in between");
                    return;
                }
                tFromX--;
                tFromY++;
            }
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
        }
        else if(toX < fromX && toY < fromY){
            System.out.println(4);
            tFromX = fromX-1;
            tFromY = fromY-1;
            while (tToX != tFromX && tToY != tFromY){
                if(chessPieces[tFromX][tFromY] != null){
                    System.out.println("Invalid move some piece is in between");
                    return;
                }
                tFromX--;
                tFromY--;
            }
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
        }
        else{
            System.out.println("Invalid move");
        }
    }

    @Override
    public String toString() {
        return getColor().equals("WHITE")?"♝":"♗";
    }
}