package problems;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m <= 0)
            return false;
        int n = board[0].length;
        if (n <= 0)
            return false;
        int len = word.length();
        if (len <= 0)
            return true;

        boolean[][] v = new boolean[m][n];
        char c = word.charAt(0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == c) {
                    v[i][j] = true;
                    if (check(board, v, i, j, word, 1))
                        return true;

                    v[i][j] = false;
                }
            }
        }
        return false;
    }

    boolean check(char[][] board, boolean[][] v, int x, int y, String word, int n) {
        if (n >= word.length())
            return true;

        char c = word.charAt(n);
        if (x > 0 && !v[x - 1][y] && board[x - 1][y] == c) {
            v[x - 1][y] = true;
            if (check(board, v, x - 1, y, word, n + 1))
                return true;

            v[x - 1][y] = false;
        }
        if (x + 1 < v.length && !v[x + 1][y] && board[x + 1][y] == c) {
            v[x + 1][y] = true;
            if (check(board, v, x + 1, y, word, n + 1))
                return true;

            v[x + 1][y] = false;
        }
        if (y > 0 && !v[x][y - 1] && board[x][y - 1] == c) {
            v[x][y - 1] = true;
            if (check(board, v, x, y - 1, word, n + 1))
                return true;

            v[x][y - 1] = false;
        }
        if (y + 1 < v[0].length && !v[x][y + 1] && board[x][y + 1] == c) {
            v[x][y + 1] = true;
            if (check(board, v, x, y + 1, word, n + 1))
                return true;

            v[x][y + 1] = false;
        }
        return false;
    }
}
