package application;

import chess.ChessMatch;

public class Program {
    public static void main(String[] args) {

        //instancia nova partida de xadrez
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
