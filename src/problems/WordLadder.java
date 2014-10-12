package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end))
            return 1;
        
        int step = 2;
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        String cut = "cut";
        q.add(cut);
        
        while (q.size() > 0) {
            String s = q.remove();
            if (s == cut) {
                if (q.size() > 0) {
                    q.add(cut);
                    step++;
                    continue;
                }
                break;
            }
            
            char[] sa = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {                
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == s.charAt(i))
                        continue;
                    sa[i] = c;
                    String t = new String(sa);
                    if (t.equals(end))
                        return step;
                    
                    if (dict.contains(t)) {
                        q.add(t);
                        dict.remove(t);
                    }
                }
                sa[i] = s.charAt(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        String start = "hit";
        String end = "cog";
        String[] array = { "hot", "dot", "dog", "lot", "log" };
        
        Set<String> dict = new HashSet<String>();
        for (String s : array)
            dict.add(s);
        
        System.out.println(wl.ladderLength(start, end, dict));
    }
}
