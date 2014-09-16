package problems;

public class PalindromePartitioning2 {
    public int minCut(String s) {
        final int n = s.length();
        if (n <= 1)
            return 0;

        boolean[][] b = new boolean[n][n];
        int[] cut = new int[n];
        for (int i = 0; i < n; i++)
            cut[i] = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (i >= j - 1 || b[i + 1][j - 1])) {
                    b[i][j] = true;
                    cut[i] = j == n - 1 ? 0 : Math.min(cut[i], cut[j + 1] + 1);
                }
            }
        }
        return cut[0];
    }

    public static void main(String[] args) {
        PalindromePartitioning2 pp = new PalindromePartitioning2();
        String s = "bbacc";
        final int cut = pp.minCut(s);
        System.out.println(cut);
    }
}
