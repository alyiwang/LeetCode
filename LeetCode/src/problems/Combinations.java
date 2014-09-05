package problems;

import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k)
            return new LinkedList<List<Integer>>();

        return combinations(n, k, 1);
    }

    List<List<Integer>> combinations(int n, int k, int p) {
        List<List<Integer>> out = new LinkedList<List<Integer>>();
        if (k == 1) {
            for (int i = p; i <= n; i++) {
                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                out.add(list);
            }
            return out;
        }

        for (int i = p + 1; i <= n - k + 2; i++) {
            List<List<Integer>> b = combinations(n, k - 1, i);
            for (int j = 0; j < b.size(); j++)
                b.get(j).add(0, i - 1);
            out.addAll(b);
        }
        return out;
    }

    public static void main(String[] args) {
        Combinations cb = new Combinations();

        System.out.println(cb.combine(3, 2).toString());
    }
}
