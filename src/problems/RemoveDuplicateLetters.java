package problems;

import java.util.Stack;

/**
 * LeetCode: Remove Duplicate Letters
 * Created by alan on 3/7/16.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] counter = new int[26];
        char[] ca = s.toCharArray();
        for (char c : ca)
            counter[c - 'a']++;

        boolean[] used = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for (char c : ca) {
            int idx = c - 'a';
            counter[idx]--;
            if (used[idx])
                continue;
            while (!stack.isEmpty() && stack.peek() > idx && counter[stack.peek()] > 0)
                used[stack.pop()] = false;
            stack.add(idx);
            used[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : stack)
            sb.append((char)('a' + i));
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rd = new RemoveDuplicateLetters();
        String s = "cbacdcbcz";

        System.out.println(s + " - " + rd.removeDuplicateLetters(s));
    }
}
