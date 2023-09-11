package Abstraction.Chess;

class Rook extends ChessPiece{

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    boolean isThereAnyPieceInBetween(ChessPiece[][] chessPieces,int from, int to,int constValue,String movingAxis){
        int value1;
        int value2;
        int i = from;
        if(movingAxis.equals("X")){
            value1 = constValue;
            value2 = i;
        }
        else{
            value1 = i;
            value2 = constValue;
        }
        for(i=from;i<=to;i++){
            if(chessPieces[value1][value2] != null){
                return false;
            }
        }
        return  true;
    }

    @Override
    void move(ChessPiece[][] chessPieces,int fromX, int fromY,int toX,int toY) {
        if(fromX == toX && isThereAnyPieceInBetween(chessPieces,fromY+1,toY,fromX,"Y")){
            swapPosition(chessPieces,fromX,fromY,toX,toY,this);
            System.out.println("Valid move");
        }
        else if(fromY == toY && isThereAnyPieceInBetween(chessPieces,fromX+1,toX,fromY,"X")){
            System.out.println("Valid move");
        }
        else{
            System.out.println("Invalid move");
        }
    }

    @Override
    public String toString() {
        return getColor().equals("WHITE")?"♜":"♖";
    }
}
