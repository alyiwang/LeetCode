package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder2 {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> paths = new ArrayList<List<String>>();

        if (!dict.contains(start) || !dict.contains(end))
            return paths;
        if (start.equals(end)) {
            List<String> trivial = new ArrayList<>();
            trivial.add(start);
            paths.add(trivial);
            return paths;
        }

        HashMap<String, HashSet<String>> graph = buildGraph(start, end, dict);
        if (graph.isEmpty())
            return paths;

        paths.addAll(trace(start, end, graph));
        return paths;
    }

    final HashMap<String, HashSet<String>> buildGraph(String start, String end, Set<String> dict) {
        HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();

        HashSet<String> upLevel = new HashSet<String>();
        HashSet<String> curLevel = new HashSet<String>();
        curLevel.add(start);

        boolean foundEnd = false;
        while (!foundEnd) {
            HashSet<String> newLevel = new HashSet<>();
            for (String s : curLevel) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == chars[i])
                            continue;
                        chars[i] = c;
                        String t = new String(chars);

                        if (!dict.contains(t) || curLevel.contains(t) || upLevel.contains(t))
                            continue;

                        if (t.equals(end))
                            foundEnd = true;
                        newLevel.add(t);
                        if (!graph.containsKey(s))
                            graph.put(s, new HashSet<String>());
                        graph.get(s).add(t);
                    }
                    chars[i] = s.charAt(i);
                }
            }
            if (newLevel.isEmpty())
                break;

            upLevel = curLevel;
            curLevel = newLevel;
        }
        if (!foundEnd)
            graph.clear();
        return graph;
    }

    final List<List<String>> trace(String start, String end, HashMap<String, HashSet<String>> graph) {
        List<List<String>> out = new ArrayList<List<String>>();
        if (start.equals(end)) {
            List<String> list = new LinkedList<String>();
            list.add(end);
            out.add(list);
            return out;
        }

        if (!graph.containsKey(start))
            return out;
        for (String s : graph.get(start)) {
            for (List<String> ls : trace(s, end, graph)) {
                ls.add(0, start);
                out.add(ls);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        WordLadder2 wl = new WordLadder2();
        String[] ends = { "hit", "cog" };
        String[] words = { "hit", "hot", "dot", "dog", "cog", "lot", "log", "bot", "cig", "dut",
                "dit" };
        Set<String> dict = new HashSet<String>(Arrays.asList(words));

        List<List<String>> out = wl.findLadders(ends[0], ends[1], dict);
        System.out.print(out);
    }
}
