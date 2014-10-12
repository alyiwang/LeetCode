package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
    public List<String> wordBreak(String s, Set<String> dict) {
        final int n = s.length();
        if (n == 0)
            return new ArrayList<String>();

        // find the valid next word's index.
        List<List<Integer>> pre = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++)
            pre.add(new ArrayList<Integer>());

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j != n - 1 && pre.get(j + 1).size() == 0)
                    continue;

                if (dict.contains(s.substring(i, j + 1)))
                    pre.get(i).add(j + 1);
            }
        }
        return trace(0, s, pre);
    }

    public List<String> trace(int a, String s, List<List<Integer>> pre) {
        final int n = s.length();
        List<String> out = new ArrayList<String>();

        for (int t : pre.get(a)) {
            String cur = s.substring(a, t);
            if (t >= n) {
                out.add(cur);
                continue;
            }
            for (String ns : trace(t, s, pre))
                out.add(cur + " " + ns);
        }
        return out;
    }

    public static void main(String[] args) {
        WordBreak2 wb = new WordBreak2();
        String s = "catsanddog";
        String[] words = { "cat", "cats", "and", "sand", "dog" };
        Set<String> dict = new HashSet<String>(Arrays.asList(words));

        List<String> out = wb.wordBreak(s, dict);
        System.out.print(out);
    }
}
