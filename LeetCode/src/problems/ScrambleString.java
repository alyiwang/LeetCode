package problems;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;

        // check if two strings have same characters.
        int n = s1.length();
        int[] count = new int[256];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int t : count) {
            if (t != 0)
                return false;
        }

        // divide strings and check recursively.
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(n - i))
                    && isScramble(s1.substring(i), s2.substring(0, n - i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ScrambleString ss = new ScrambleString();
        
        String s1 = "abc", s2 = "bca";
        
        System.out.print(ss.isScramble(s1, s2));
    }
}
