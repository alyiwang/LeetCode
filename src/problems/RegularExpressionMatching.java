package problems;

/* 
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ? false
 isMatch("aa","aa") ? true
 isMatch("aaa","aa") ? false
 isMatch("aa", "a*") ? true
 isMatch("aa", ".*") ? true
 isMatch("ab", ".*") ? true
 isMatch("aab", "c*a*b") ? true
 * 
 Assuming only the second string has . and * 
 */

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        if (p.length() == 0)
            return s.length() == 0;

        return match(s, 0, p, 0);
    }

    boolean match(String s, int a, String p, int b) {
        int sl = s.length() - a, pl = p.length() - b;
        if (pl == 0)
            return sl == 0;

        if (pl >= 2 && p.charAt(b + 1) == '*') { // next one is *
            for (int i = 0; i <= sl; i++) {
                if (i > 0 && s.charAt(a + i - 1) != p.charAt(b) && p.charAt(b) != '.')
                    break;

                if (match(s, a + i, p, b + 2))
                    return true;
            }
        } else if (sl > 0 && (s.charAt(a) == p.charAt(b) || p.charAt(b) == '.'))
            return match(s, a + 1, p, b + 1);

        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();

        String s = "aa", p = "a*";
        System.out.println(s + "  " + p + "  " + rem.isMatch(s, p));
    }
}
