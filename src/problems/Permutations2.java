package problems;

import java.util.*;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0)
            return new ArrayList<List<Integer>>();

        List<Integer> list = new LinkedList<Integer>();
        for (int t : num)
            list.add(t);
        Collections.sort(list);
        return permute(list);
    }

    List<List<Integer>> permute(List<Integer> A) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        if (A.size() == 1) {
            List<Integer> list = new ArrayList<Integer>(A);
            out.add(list);
            return out;
        }
        for (int i = 0; i < A.size(); i++) {
            if (i > 0 && A.get(i) == A.get(i - 1))
                continue;
            int t = A.remove(i);
            List<List<Integer>> B = permute(A);
            for (List<Integer> L : B)
                L.add(0, t);
            out.addAll(B);
            A.add(i, t);
        }
        return out;
    }

    public static void main(String[] args) {
        Permutations2 pm = new Permutations2();

        int[] num = { 1, 1, 3 };

        List<List<Integer>> out = pm.permuteUnique(num);
        System.out.println(out.toString());
    }
}
