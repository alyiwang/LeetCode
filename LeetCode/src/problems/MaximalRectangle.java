package problems;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        if (n == 0)
            return 0;

        int[] H = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                H[j] = (matrix[i][j] == '0') ? 0 : H[j] + 1;

            max = Math.max(max, largestRectangleArea(H));
        }
        return max;
    }

    int largestRectangleArea(int[] height) {
        int max = 0, i = 0;
        Stack<Integer> S = new Stack<Integer>();
        while (i <= height.length) {
            if (i == height.length && S.empty())
                i++;
            else if (i < height.length && (S.empty() || height[S.peek()] < height[i])) {
                S.push(i);
                i++;
            } else {
                int t = S.pop();
                max = Math.max(max, height[t] * (S.empty() ? i : i - S.peek() - 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle mr = new MaximalRectangle();

        char[][] matrix = { { '0' } };

        System.out.println(mr.maximalRectangle(matrix));
    }
}
