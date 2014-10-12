package problems;

public class MaxProductSubarray {
    public int maxProduct(int[] A) {
        if (A.length == 0)
            return 0;

        int maxProd = Integer.MIN_VALUE;
        int max = 1, min = 1;

        for (final int a : A) {
            final int t0 = a * max;
            final int t1 = a * min;
            max = Math.max(a, Math.max(t0, t1));
            min = Math.min(a, Math.min(t0, t1));
            maxProd = Math.max(max, maxProd);
        }
        return maxProd;
    }

    public static void main(String[] args) {
        MaxProductSubarray mp = new MaxProductSubarray();

        final int[] A = { 0, 2, 3, -2, 4, -1, 1 };
        System.out.println(mp.maxProduct(A));
    }
}
