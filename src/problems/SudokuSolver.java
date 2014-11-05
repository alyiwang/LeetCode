package problems;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;

        solve(board);
    }

    final boolean solve(char[][] B) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (B[i][j] != '.')
                    continue;

                for (char c = '1'; c <= '9'; c++) {
                    B[i][j] = c;
                    if (check(B, i, j) && solve(B))
                        return true;
                }
                B[i][j] = '.';
                return false;
            }
        }
        return true;
    }

    final boolean check(char[][] b, int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (i != x && b[i][y] == b[x][y])
                return false;
            if (i != y && b[x][i] == b[x][y])
                return false;
        }

        for (int i = x - x % 3; i < x - x % 3 + 3; i++) {
            for (int j = y - y % 3; j < y - y % 3 + 3; j++) {
                if ((i != x || j != y) && b[i][j] == b[x][y])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();
        String[] sa = { "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.",
                ".98...3..", "...8.3.2.", "........6", "...2759.." };

        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                board[i][j] = sa[i].charAt(j);
        }
        ss.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + ", ");
            System.out.println();
        }
    }
}
