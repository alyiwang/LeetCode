package problems;

import java.util.ArrayList;
import java.util.List;

public class MaximumGap {

    class Bucket {
        int min, max, count;

        Bucket() {
            count = 0;
        }

        public void add(int t) {
            if (count == 0)
                min = max = t;
            else {
                min = Math.min(min, t);
                max = Math.max(max, t);
            }
            count++;
        }
    }

    public int maximumGap(int[] num) {
        if (num == null || num.length == 0)
            return 0;

        int N = num.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int t : num) {
            min = Math.min(min, t);
            max = Math.max(max, t);
        }

        List<Bucket> Bu = new ArrayList<Bucket>(N - 1);
        for (int i = 0; i < N - 1; i++)
            Bu.add(new Bucket());
        for (int t : num) {
            if (t != min && t != max)
                Bu.get().add(t);
        }
        int gap = Math.max(Bu.get(0).min - min, max - Bu.get(N - 2).max);
        for (int i = 0; i < N - 1; i++)
            gap = Math.max()
    }

    public static void main(String[] args) {
        MaximumGap mg = new MaximumGap();
        int[] num = { 2, 99999999 };
        System.out.println(mg.maximumGap(num));
    }
}
