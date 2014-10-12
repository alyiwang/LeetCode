package problems;

import java.util.HashMap;

public class LongestSubstringWORepeating {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int l = 0, r = 0;
        int max = 0; // max length
        HashMap<Character, Character> hs = new HashMap<Character, Character>();

        char c = 0, d = 0;
        for (r = 0; r < len; r++) {
            c = s.charAt(r);
            if (!hs.containsKey(c)) { // no such char in substring yet
                hs.put(c, c);
            } else { // char repeat
                if (r - l > max)
                    max = r - l;
                while ((d = s.charAt(l)) != c) { // search the repeat one
                    hs.remove(d);
                    l++;
                }
                l++; // go to the first non-repeat one
            }
        }
        if (r - l > max)
            max = r - l;

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWORepeating ls = new LongestSubstringWORepeating();

        String s = "abcabcdbb";
        int a = ls.lengthOfLongestSubstring(s);
        System.out.println(a);
    }
}
