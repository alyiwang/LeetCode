package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return new ArrayList<List<Integer>>();

        Arrays.sort(candidates);
        return allCombinations(candidates, 0, target);
    }

    List<List<Integer>> allCombinations(int[] A, int idx, int target) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        int sum = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (sum <= target) {
            if (sum == target)
                out.add(list);
            else if (idx < A.length - 1) {
                List<List<Integer>> re = allCombinations(A, idx + 1, target - sum);
                for (List<Integer> a : re)
                    a.addAll(0, list);
                out.addAll(re);
            }
            sum += A[idx];
            if (sum <= target)
                list.add(A[idx]);
        }
        return out;
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();

        int[] candidates = { 2, 3, 7, 4 };
        int target = 7;
        System.out.println(cs.combinationSum(candidates, target));
    }
}
