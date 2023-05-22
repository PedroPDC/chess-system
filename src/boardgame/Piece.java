package boardgame;

public class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null; //peça nao foi colocada no tabuleiro ainda, portanto posição é nula
    }

    protected Board getBoard() {
        return board;
    }


}
