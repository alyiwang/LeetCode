package problems;

import java.util.*;

/**
 * Leetcode: Remove Invalid Parentheses
 * Created by alan on 2/29/16.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();

        LinkedList<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        q.add(s);
        set.add(s);
        String end = s;
        while (!q.isEmpty()) {
            String t = q.removeFirst();
            if (isValid(t))
                results.add(t);
            else {
                for (int i = 0; i < t.length(); i++) {
                    if (t.charAt(i) == '(' || t.charAt(i) == ')') {
                        String newS = t.substring(0, i) + t.substring(i + 1);
                        if (!set.contains(newS)) {
                            q.add(newS);
                            set.add(newS);
                        }
                    }
                }
            }

            if (t == end) {
                if (results.size() > 0)
                    return results;
                end = q.getLast();
            }
        }
        return results;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                count++;
            else if (c == ')') {
                if (count <= 0)
                    return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses rp = new RemoveInvalidParentheses();
        String s = "(a)())()";

        System.out.println(rp.removeInvalidParentheses(s));
        // rp.removeInvalidParentheses(s).forEach(System.out::println);
    }
}