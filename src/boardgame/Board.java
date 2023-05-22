package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    /*metodo setRows retirado para que nao seja alterada a quantidade
    de linhas com o programa em execução*/

    public int getColumns() {
        return columns;
    }

    /*metodo setColumns retirado para que nao seja alterada a quantidade
    de colunas com o programa em execução*/

    public Piece piece(int row, int column){
        /*se posição nao existir, lançar uma nova boardException*/
        if(!positionExists(row, column)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        /*testa se ja nao existe uma peça na posição*/
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    //metodo auxiliar para testar por linha e coluna
    //para posição existir, ela deve estar dentro do tabuleiro
    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        /*antes de testar se existe uma peça ele ja testa se a posição existe*/
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        //se a peça for diferente de nulo, tem uma peça nessa posição
        return piece(position) != null;
    }
}
