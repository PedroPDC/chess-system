package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0); //aux

        // NW / NOROESTE
        p.setValues(position.getRow() - 1, position.getColumn() - 1);

        //enquanto a posição p existir e estiver vaga, vamos marcar como VERDADEIRA
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        //testa se existe casa e se é ocupada por um adversário
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // NE / NORDESTE
        p.setValues(position.getRow() - 1, position.getColumn() + 1);

        //enquanto a posição p existir e estiver vaga, vamos marcar como VERDADEIRA
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        //testa se existe casa e se é ocupada por um adversário
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // SE / SUDESTE
        p.setValues(position.getRow() + 1, position.getColumn() + 1);

        //enquanto a posição p existir e estiver vaga, vamos marcar como VERDADEIRA
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
        //testa se existe casa e se é ocupada por um adversário
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // SW / SUDOESTE
        p.setValues(position.getRow() + 1, position.getColumn() - 1);

        //enquanto a posição p existir e estiver vaga, vamos marcar como VERDADEIRA
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        //testa se existe casa e se é ocupada por um adversário
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
