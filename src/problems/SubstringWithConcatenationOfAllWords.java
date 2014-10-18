package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        final List<Integer> out = new ArrayList<Integer>();
        if (S == null || L == null || S.length() == 0 || L.length == 0)
            return out;

        final int len = L[0].length();
        final int N = L.length * len;
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> mapcopy = null;
        for (final String st : L) {
            if (!map.containsKey(st))
                map.put(st, 1);
            else
                map.put(st, map.get(st) + 1);
        }

        for (int i = 0; i < S.length() - N + 1; i++) {
            final String a = S.substring(i, i + len);
            if (!map.containsKey(a))
                continue;
            else {
                mapcopy = new HashMap<String, Integer>(map);
                remove(mapcopy, a);
            }

            for (int j = 1; j < L.length; j++) {
                String t = S.substring(i + j * len, i + (j + 1) * len);
                if (!remove(mapcopy, t))
                    break;
            }
            if (mapcopy.size() == 0)
                out.add(i);
        }
        return out;
    }
    
    boolean remove(HashMap<String, Integer> map, String s) {
        if (map.containsKey(s)) {
            final int count = map.get(s);
            if (count > 1)
                map.put(s, count - 1);
            else
                map.remove(s);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords sw = new SubstringWithConcatenationOfAllWords();
        String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] L = { "fooo", "barr", "wing", "ding", "wing" };
        System.out.println(sw.findSubstring(S, L));
    }
}
