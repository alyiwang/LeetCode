package problems;

public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        final int m = s.length(), n = p.length();
        int p1 = 0, p2 = 0, star = -1, p1pre = -1;

        while (p1 < m) {
            if (p2 < n && (s.charAt(p1) == p.charAt(p2) || p.charAt(p2) == '?')) {
                p1++;
                p2++;
            } else if (p2 < n && p.charAt(p2) == '*') {
                star = p2++;
                p1pre = p1;
            } else if (star >= 0) {
                p2 = star + 1;
                p1 = ++p1pre;
            } else
                return false;
        }
        while (p2 < n) {
            if (p.charAt(p2) != '*')
                return false;
            p2++;
        }
        return true;
    }

    public static void main(String[] args) {
        WildCardMatching wm = new WildCardMatching();
        String s = "abab";
        String p = "a*b";
        System.out.print(s + ", " + p + ", " + wm.isMatch(s, p));
    }
}
