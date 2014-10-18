package problems;

import java.util.HashSet;

public class LongestSubstringWORepeating {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int l = 0, r = 0;
        int max = 0; // max length
        HashSet<Character> hs = new HashSet<Character>();

        for (r = 0; r < len; r++) {
            char c = s.charAt(r);
            if (!hs.contains(c)) // no such char in substring yet
                hs.add(c);
            else { // char repeat
                max = Math.max(r - l, max);
                while (s.charAt(l) != c) // search the repeat one
                    hs.remove(s.charAt(l++));
                l++; // go to the first non-repeat one
            }
        }
        return Math.max(r - l, max);
    }

    public static void main(String[] args) {
        LongestSubstringWORepeating ls = new LongestSubstringWORepeating();

        String s = "abcabcdbb";
        int a = ls.lengthOfLongestSubstring(s);
        System.out.println(a);
    }
}
