package problems;

import java.util.*;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] num) {
        if (num.length <= 0)
            return new ArrayList<List<Integer>>();
        
        Arrays.sort(num);
        List<Integer> A = new ArrayList<Integer>();
        for (int k : num)
            A.add(k);
        return permute(A);
    }
    
    List<List<Integer>> permute(List<Integer> A) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        if (A.size() == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(A.get(0));
            re.add(list);
            return re;
        }
        
        for (int i = 0; i < A.size(); i++) {
            if (i > 0 && A.get(i) == A.get(i-1))
                continue;
            int t = A.remove(i);
            List<List<Integer>> b = permute(A);
            for (int j = 0; j < b.size(); j++)
                b.get(j).add(0, t);
            re.addAll(b);
            A.add(i, t);
        }
        return re;
    }
    
    public static void main(String[] args) {
        Permutations2 pm = new Permutations2(); 
        
        int[] num = {1, 1, 3};
        
        List<List<Integer>> out = pm.permuteUnique(num);        
        System.out.println(out.toString());
    }
}
