package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        if (num.length == 0)
            return new ArrayList<List<Integer>>();

        Arrays.sort(num);
        return allCombinations(num, 0, target);
    }

    List<List<Integer>> allCombinations(int[] A, int idx, int target) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        if (A[idx] > target)
            return out;
        if (A[idx] == target) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(A[idx]);
            out.add(list);
            return out;
        }

        if (idx < A.length - 1) {
            List<List<Integer>> re = allCombinations(A, idx + 1, target - A[idx]);
            for (List<Integer> s : re)
                s.add(0, A[idx]);
            out.addAll(re);
        }
        for (int i = idx + 1; i < A.length; i++) {
            if (A[i] != A[idx]) {
                out.addAll(allCombinations(A, i, target));
                break;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        CombinationSum2 cs = new CombinationSum2();

        int[] candidates = { 2, 3, 3, 7, 4 };
        int target = 7;
        System.out.println(cs.combinationSum2(candidates, target));
    }
}
