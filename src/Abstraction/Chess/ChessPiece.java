package Abstraction.Chess;

abstract class ChessPiece {
    private int x;
    private int y;
    private String color;

    ChessPiece(int x,int y,String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    boolean isCrossingBoundary(int x,int y){
        if(x>7 || x<0 || y>7 || y<0){
            return true;
        }
        return false;
    }

    void changePawnToAnotherPiece(String piece){
        System.out.println("Changing pawn to"+piece);
    }

    void swapPosition(ChessPiece[][] chessPieces,int fromX,int fromY,int toX,int toY,ChessPiece piece){
        chessPieces[toX][toY] = piece;
        chessPieces[fromX][fromY] = null;
    }

    void kill(){
        System.out.println("Get the piece out of the board");
    }

    void checkingForKill(ChessPiece[][] chessPieces,int fromX,int fromY,int toX,int toY){
        if(chessPieces[fromX][fromY].getColor().equals("WHITE") && chessPieces[toX][toY].getColor().equals("BLACK")){
            swapPosition(chessPieces,fromX,fromY,toX,toY,chessPieces[fromX][fromY]);
        }
        else{
            System.out.println("Can't kill same color piece");
        }
    }

    abstract void move(ChessPiece[][] chessPieces,int fromX,int fromY,int toX,int toY);

    @Override
    public String toString() {
        return color.substring(0,1);
    }
}
