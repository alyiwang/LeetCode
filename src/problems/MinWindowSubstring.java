package problems;

public class MinWindowSubstring {
    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length();
        int[] count = new int[256], found = new int[256];
        for (int i = 0; i < n; i++)
            count[T.charAt(i)]++;

        boolean hasit = false;
        String out = "";
        int l = 0, r = 0, foundNum = 0, min = m + 1;
        while (r < m || hasit) {
            if (!hasit) {
                char c = S.charAt(r++);
                if (++found[c] <= count[c]) {
                    if (++foundNum >= n)
                        hasit = true;
                }
            } else {
                char c = S.charAt(l++);
                if (--found[c] < count[c]) {
                    hasit = false;
                    if (r - l + 1 < min) {
                        min = r - l + 1;
                        out = S.substring(l - 1, r);
                    }
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        MinWindowSubstring mws = new MinWindowSubstring();
        String S = "aaa";
        String T = "aa";

        System.out.println(mws.minWindow(S, T));
    }
}
