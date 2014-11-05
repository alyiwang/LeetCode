package problems;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1)
            return 0;

        int max = 0;
        int[] A = new int[s.length() + 1];
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push(i);
            else if (!st.empty()) {
                int t = st.pop();
                A[i + 1] = A[t] + i - t + 1;
                max = Math.max(max, A[i + 1]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses lp = new LongestValidParentheses();
        String s = "()(()";

        System.out.println(s + " : " + lp.longestValidParentheses(s));
    }
}
