package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
    public Color getColor() {
        return color;
    }

    public int getMoveCount(){
        return moveCount;
    };
    public void  increaseMoveCount(){
        moveCount++;
    }
    public void  decreaseMoveCount(){
        moveCount++;
    }
    public boolean isThereOpponentPiece(Position position){
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece != null && piece.getColor() != color;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }
}
