package M04_AlgorithmsFundamentals.L01_RecursionAndBacktracking.Lab;

public class T06_8QueensPuzzle {
    public static char[][] board = {
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},};

    public static void main(String[] args) {
        findQueens(0);
    }

    private static void findQueens(int row) {
        if (row == 8) {
            print();
        } else {
            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    findQueens(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static void putQueen(int row, int col) {
        board[row][col] = '*';
    }

    private static void removeQueen(int row, int col) {
        board[row][col] = '-';
    }

    private static boolean canPlaceQueen(int row, int col) {
        for (int c = 0; c < 8; c++) {
            if (board[row][c] == '*') {
                return false;
            }
        }

        for (int r = 0; r < 8; r++) {
            if (board[r][col] == '*') {
                return false;
            }
        }

        int r = row, c = col;

        while (r >= 0 && c >= 0) {
            if (board[r--][c--] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while (r < 8 && c < 8) {
            if (board[r++][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while (r >= 0 && c < 8) {
            if (board[r--][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while (r < 8 && c >= 0) {
            if (board[r++][c--] == '*') {
                return false;
            }
        }

        return true;
    }

    private static void print() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}