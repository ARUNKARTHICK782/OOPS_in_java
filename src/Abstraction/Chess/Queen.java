package Abstraction.Chess;

public class Queen extends ChessPiece{
    public Queen(int x, int y, String color) {
        super(x, y, color);
    }

    boolean isThereAnyPieceInBetween(ChessPiece[][] chessPieces,int from, int to,int constValue,String movingAxis){
//        System.out.println("Direction : "+movingAxis);

        if(movingAxis.equals("X")){
            for(int i=from;i<=to;i++){
//                System.out.println("value 1 : "+i+" value 2 : "+constValue);
                if(chessPieces[i][constValue] != null){
                    return false;
                }
            }
        }
        else{
            for(int i=from;i<=to;i++){
//                System.out.println("value 1 : "+i+" value 2 : "+constValue);
                if(chessPieces[constValue][i] != null){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    void move(ChessPiece[][] chessPieces,int fromX, int fromY,int toX,int toY) {

        if(fromX == toX && isThereAnyPieceInBetween(chessPieces,fromY+1,toY,fromX,"X")){
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
            return;
        }
        else if(fromY == toY && isThereAnyPieceInBetween(chessPieces,fromX+1,toX,fromY,"Y")){
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
            return;
        }

        if (Math.abs(fromX - toX) != Math.abs(fromY - toY)) {
            System.out.println("Invalid move");
            return;
        }
        int tFromX = fromX+1;
        int tToX = toX;
        int tFromY = fromY+1;
        int tToY = toY;
        if(toX > fromX && toY > fromY){
            tFromX = fromX+1;
            tFromY = fromY+1;
            while (tToX != tFromX && tToY != tFromY){
                System.out.println("X : "+tFromX+" Y : "+tFromY);
                if(chessPieces[tFromX][tFromY] != null){
                    System.out.println("Invalid move some piece is in between");
                    return;
                }
                tFromX++;
                tFromY++;
            }
            System.out.println("Valid move");
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
        }
        else if(toX > fromX && toY < fromY){
            tFromX = fromX+1;
            tFromY = fromY-1;
            while (tToX != tFromX && tToY != tFromY){
                System.out.println("X : "+tFromX+" Y : "+tFromY);
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
            tFromX = fromX-1;
            tFromY = fromY-1;
            while (tToX != tFromX && tToY != tFromY){
                System.out.println("X : "+tFromX+" Y : "+tFromY);
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
        return getColor().equals("WHITE")?"♛":"♕";
    }
}
