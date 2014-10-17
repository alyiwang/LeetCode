package problems;

import java.util.Arrays;

public class Sum3Closest {
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3)
            return 0;

        Arrays.sort(num);

        int closest = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;

            int p = i + 1, q = num.length - 1;
            while (p < q) {
                int t = num[p] + num[q] + num[i];
                if (t == target)
                    return t;
                if (Math.abs(t - target) < Math.abs(closest - target))
                    closest = t;
                if (t < target)
                    p++;
                else
                    q--;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Sum3Closest sc = new Sum3Closest();
        int[] num = { 1, 3, 4, 8, 3, 5 };
        int target = 9;
        System.out.println(sc.threeSumClosest(num, target));
    }
}
