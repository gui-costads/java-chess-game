package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean testRookCastling(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
    }

    private boolean canMove(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        // Up
        p.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Down
        p.setValues(position.getRow()  + 1 , position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Left
        p.setValues(position.getRow() , position.getColumn() - 1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Right
        p.setValues(position.getRow() , position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Up-Left
        p.setValues(position.getRow() - 1, position.getColumn() -1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Up-Right
        p.setValues(position.getRow() - 1, position.getColumn() + 1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Down-Left
        p.setValues(position.getRow() + 1, position.getColumn() - 1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Down-Right
        p.setValues(position.getRow() + 1, position.getColumn() + 1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // special move castling kingside rook
        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            Position positionRook1 =  new Position(position.getRow(), position.getColumn() + 3);
            if(testRookCastling(positionRook1)){
                Position position1 = new Position(position.getRow(), position.getColumn()+1);
                Position position2 = new Position(position.getRow(), position.getColumn()+2);
                if (getBoard().piece(position1) == null && getBoard().piece(position2 ) == null) {
                    mat[position.getRow()][position.getColumn() + 2 ] = true;
                }
            }
        }

        // special move castling queenside rook
        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            Position positionRook2 =  new Position(position.getRow(), position.getColumn() - 4);
            if(testRookCastling(positionRook2)){
                Position position1 = new Position(position.getRow(), position.getColumn()-1);
                Position position2 = new Position(position.getRow(), position.getColumn()-2);
                Position position3 = new Position(position.getRow(), position.getColumn()-3);
                if (getBoard().piece(position1) == null &&
                    getBoard().piece(position2) == null &&
                    getBoard().piece(position3) == null) {
                        mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }
    @Override
    public String toString(){
        return "K";
    }
}

