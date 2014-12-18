package problems;

public class MaximumGap {

    class Bucket {
        int min, max;

        Bucket(int t) {
            min = max = t;
        }

        public void add(int t) {
            min = Math.min(min, t);
            max = Math.max(max, t);
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
        double D = 1.0 * (max - min - 2) / (N - 1);

        Bucket[] Bu = new Bucket[N];
        for (int t : num) {
            if (t != min && t != max) {
                int k = (int) Math.floor((t - min - 1) / D);
                if (Bu[k] == null)
                    Bu[k] = new Bucket(t);
                else
                    Bu[k].add(t);
            }
        }
        Bu[N - 1] = new Bucket(max);

        int gap = 0, pre = min;
        for (int i = 0; i < N; i++) {
            if (Bu[i] != null) {
                gap = Math.max(gap, Bu[i].min - pre);
                pre = Bu[i].max;
            }
        }
        return gap;
    }

    public static void main(String[] args) {
        MaximumGap mg = new MaximumGap();
        int[] num = { 2, 5, 99999999 };
        System.out.println(mg.maximumGap(num));
    }
}
