package problems;

import java.util.Arrays;

/**
 * Leetcode: Longest Increasing Path
 * Created by alan on 2/23/2016.
 */
public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] count = new int[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 0)
                    findLongest(matrix, i, j, count);
                max = Math.max(max, count[i][j]);
            }
        }
        return max;
    }

    public void findLongest(int[][] matrix, int x, int y, int[][] count) {
        int m = matrix.length, n = matrix[0].length;
        int[][] diff = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int longest = 1;

        for (int[] dif : diff) {
            int x1 = x + dif[0], y1 = y + dif[1];
            if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && matrix[x][y] < matrix[x1][y1]) {
                if (count[x1][y1] == 0)
                    findLongest(matrix, x1, y1, count);
                longest = Math.max(longest, count[x1][y1] + 1);
            }
        }
        count[x][y] = longest;
    }

    public static void main(String[] args) {
        LongestIncreasingPath lp = new LongestIncreasingPath();
        int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};

        System.out.println(Arrays.deepToString(matrix) + " : " + lp.longestIncreasingPath(matrix));
    }
}
