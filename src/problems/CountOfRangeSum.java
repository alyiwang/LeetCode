package problems;

/**
 * LeetCode: Count of Range Sum
 * Created by yiwan on 3/6/16.
 */
public class CountOfRangeSum {
    public int countRangeSum1(int[] nums, int lower, int upper) {
        int n = nums.length, count = 0;
        long[] sum = new long[n + 1];

        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                long rangesum = sum[i + 1] - sum[j];
                if (rangesum >= lower && rangesum <= upper)
                    count++;
            }
        }
        return count;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];
        return mergesort(sum, 0, n, lower, upper);
    }

    private int mergesort(long[] A, int s, int e, int low, int up) {
        if (e <= s)
            return 0;

        int mid = (s + e + 1) / 2;
        int count = mergesort(A, s, mid - 1, low, up) + mergesort(A, mid, e, low, up);

        long[] temp = new long[e - s + 1];
        int i = 0, l = s, r = mid, r1 = mid, r2 = mid;
        while (l < mid) {
            // r1 is the first index satisfy sums[r1] - sums[l] >= lower and
            // r2 is the first index satisfy sums[r2] - sums[l] > upper.
            while (r1 <= e && A[r1] - A[l] < low)
                r1++;
            while (r2 <= e && A[r2] - A[l] <= up)
                r2++;
            count += r2 - r1;
            while (r <= e && A[r] < A[l])
                temp[i++] = A[r++];
            temp[i++] = A[l++];
        }
        System.arraycopy(temp, 0, A, s, r - s);
        return count;
    }

    public static void main(String[] args) {
        CountOfRangeSum cs = new CountOfRangeSum();
        int[] nums = {-2, 0, 0, 2, 2, -2};
        int lower = -3, upper = 1;

        System.out.println(cs.countRangeSum(nums, lower, upper));
    }
}

