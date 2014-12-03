package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int k : num)
            map.put(k, 1);

        int max = 0;
        for (int k : num) {
            if (!map.containsKey(k))
                continue;
            int end = k + map.get(k) - 1, next = end + 1;
            while (map.containsKey(next)) {
                end = next + map.remove(next) - 1;
                next++;
            }

            map.put(k, end - k + 1);
            max = Math.max(max, end - k + 1);
        }
        return max;
    }

    public int longestConsecutive2(int[] num) {
        if (num == null || num.length == 0)
            return 0;

        Set<Integer> set = new HashSet<Integer>();
        for (int k : num)
            set.add(k);

        int max = 0;
        for (int k : num) {
            if (!set.contains(k))
                continue;
            int count = 1, next = k + 1;
            while (set.contains(next)) {
                count++;
                set.remove(next++);
            }

            next = k - 1;
            while (set.contains(next)) {
                count++;
                set.remove(next--);
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

        int[] num = { -2, -3, -3, 7, -3, 0, 5, 0, -8, -4, -1, 2 };
        System.out.println(lcs.longestConsecutive(num));
    }
}
