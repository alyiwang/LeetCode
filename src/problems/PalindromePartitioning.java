package problems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        final int n = s.length();
        if (n == 0)
            return new ArrayList<List<String>>();

        boolean[][] b = new boolean[n][n];
        for (int i = 0; i < n - 1; i++) {
            b[i][i] = true;
            b[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        b[n - 1][n - 1] = true;

        for (int i = 3; i <= n; i++) {
            for (int x = 0; x < n + 1 - i; x++) {
                if (s.charAt(x) == s.charAt(x + i - 1))
                    b[x][x + i - 1] = b[x + 1][x + i - 2];
            }
        }

        return trace(b, s, 0);
    }

    List<List<String>> trace(boolean[][] b, String s, int l) {
        int n = s.length();
        List<List<String>> out = new ArrayList<List<String>>();

        if (b[l][n - 1]) {
            List<String> a = new ArrayList<String>();
            a.add(s.substring(l));
            out.add(a);
        }

        for (int i = l; i < n - 1; i++) {
            if (b[l][i]) {
                List<List<String>> t = trace(b, s, i + 1);
                for (int j = 0; j < t.size(); j++)
                    t.get(j).add(0, s.substring(l, i + 1));
                out.addAll(t);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();

        String s = "a";
        System.out.println(pp.partition(s));
    }
}
