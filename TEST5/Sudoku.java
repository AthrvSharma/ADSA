package TEST5;

import java.util.*;

public class Sudoku {

    public static void solveSudoku(char[][] board) {

        // Convert '0' to '.'
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '0') {
                    board[i][j] = '.';
                }
            }
        }

        solve(board);
    }

    private static boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (isValid(board, i, j, ch)) {

                            board[i][j] = ch;

                            if (solve(board)) {
                                return true;
                            }

                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid(char[][] board, int r, int c, char ch) {

        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;

        for (int i = 0; i < 9; i++) {

            if (board[r][i] == ch)
                return false;

            if (board[i][c] == ch)
                return false;

            if (board[sr + i / 3][sc + i % 3] == ch)
                return false;
        }

        return true;
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = {
            {'5','3','0','0','7','0','0','0','0'},
            {'6','0','0','1','9','5','0','0','0'},
            {'0','9','8','0','0','0','0','6','0'},
            {'8','0','0','0','6','0','0','0','3'},
            {'4','0','0','8','0','3','0','0','1'},
            {'7','0','0','0','2','0','0','0','6'},
            {'0','6','0','0','0','0','2','8','0'},
            {'0','0','0','4','1','9','0','0','5'},
            {'0','0','0','0','8','0','0','7','9'}
        };

        solveSudoku(board);

        System.out.println("Solved Sudoku:");
        printBoard(board);
    }
}