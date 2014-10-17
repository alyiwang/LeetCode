package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] num, int target) {
        final List<List<Integer>> out = new ArrayList<List<Integer>>();
        if (num.length == 0)
            return out;

        Arrays.sort(num);

        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;

            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1])
                    continue;

                int p = j + 1, q = num.length - 1;
                while (p < q) {
                    final int t = num[i] + num[j] + num[p] + num[q];
                    if (t == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[p]);
                        list.add(num[q]);
                        out.add(list);

                        while (++p < q && num[p] == num[p - 1])
                            ;
                        while (--q > p && num[q] == num[q + 1])
                            ;
                    } else if (t < target)
                        p++;
                    else
                        q--;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Sum4 s = new Sum4();
        int[] num = { 1, 2, 2, 5, 8, 5, 4 };
        int target = 13;
        System.out.println(s.fourSum(num, target));
    }
}
