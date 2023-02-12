package tictactoe;

import tictactoe.model.Board;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Board board = new Board(3);
        board.play(2, 2, "X");
        board.play(3, 1, "O");
        System.out.println(board);
    }

}
