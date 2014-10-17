package problems;

public class TrapRainWater {
    public int trap(int[] A) {
        int len = A.length;
        if (len <= 2)
            return 0;

        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], A[i - 1]);
            right[len - i - 1] = Math.max(right[len - i], A[len - i]);
        }

        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            sum += Math.max(0, Math.min(left[i], right[i]) - A[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        TrapRainWater trw = new TrapRainWater();
        int[] A = { 4, 3, 7, 2 };
        System.out.println(trw.trap(A));
    }
}
