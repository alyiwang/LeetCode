package problems;

public class MinWindowSubstring {
    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length();
        int[] count = new int[256];
        int[] found = new int[256];

        for (int i = 0; i < n; i++)
            count[T.charAt(i)]++;

        int l = 0, r = 0, num = 0;
        int minl = 0, minr = 0, minL = m + 1;
        boolean inc = true;

        while (r < m || !inc) {
            if (inc) {
                char t = S.charAt(r++);
                if (count[t] > 0) {
                    found[t]++;
                    if (found[t] <= count[t])
                        num++;
                    if (num >= n)
                        inc = false;
                }
            } else {
                char t = S.charAt(l++);
                if (count[t] > 0) {
                    found[t]--;
                    if (found[t] < count[t]) {
                        num--;
                        inc = true;
                        if (r - l + 1 < minL) {
                            minl = l - 1;
                            minr = r;
                            minL = r - l + 1;
                        }
                    }
                }
            }
        }
        return S.substring(minl, minr);
    }

    public static void main(String[] args) {
        MinWindowSubstring mws = new MinWindowSubstring();
        String S = "aaa";
        String T = "aa";

        System.out.println(mws.minWindow(S, T));
    }
}
