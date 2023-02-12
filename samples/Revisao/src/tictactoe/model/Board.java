package tictactoe.model;

import java.util.Arrays;

public class Board {

    private int size;
    private String[][] board;
    private boolean finalized;

//   [["X" , "X", "O"],
//    [" " , " ", "O"],
//    ["X" , " ", " "] ]

    public Board(int size) {
        this.size = size;
        this.board = new String[size][size];
        for(int i = 0; i < board.length; i++ ) {
            Arrays.fill(board[i], " ");
        }
    }

    public boolean isFinalized() {
        return finalized;
    }

    public boolean play(int line, int column, String key) {
        if(line > size || column > size)
            return false;

        line--;
        column--;

        if(!board[line][column].isBlank())
            return false;

        board[line][column] = key;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();

        answer.append("-------------\n");

        for(String[] line : board) {
            answer.append("| ");
            for(String value : line)
                answer.append(value).append(" | ");
            answer.append("\n-------------\n");
        }

        return answer.toString();
    }
}
