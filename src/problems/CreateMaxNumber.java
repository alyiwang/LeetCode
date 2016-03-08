package problems;

import java.util.Arrays;

/**
 * LeetCode: Create Maximum Number
 * Created by alan on 3/7/16.
 */
public class CreateMaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] re = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= nums1.length && i <= k; i++) {
            int[] m = merge(maxArray(nums1, i), maxArray(nums2, k - i));
            if (ge(m, 0, re, 0))
                re = m;
        }
        return re;
    }

    /**
     * Find the maximum number sequence in A.
     * @param A int[] input sequence
     * @param k sequence length
     * @return int[]
     */
    private int[] maxArray(int[] A, int k) {
        int[] re = new int[k];
        if (k == 0)
            return re;

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            while (count > 0 && A.length - i - 1 >= k - count && A[i] > re[count - 1])
                count--;
            if (count < k)
                re[count++] = A[i];
        }
        return re;
    }

    /**
     * Merge two sequence into one largest number.
     * @param A1 int[] input sequence 1
     * @param A2 int[] input sequence 2
     * @return int[] merged largest number sequence
     */
    private int[] merge(int[] A1, int[] A2) {
        int n1 = A1.length, n2 = A2.length, n = n1 + n2;
        if (n1 == 0)
            return A2;
        if (n2 == 0)
            return A1;

        int[] re = new int[n];
        int cur = 0, i1 = 0, i2 = 0;
        while (i1 < n1 || i2 < n2) {
            if (i2 >= n2 || i1 < n1 && ge(A1, i1, A2, i2))
                re[cur++] = A1[i1++];
            else
                re[cur++] = A2[i2++];
        }
        return re;
    }

    /**
     * Check is the number in sequence A1 is greater than or equal to the number in A2
     * @param A1 int[]
     * @param s1 startint point of A1
     * @param A2 int[]
     * @param s2 starting point of A1
     * @return boolean
     */
    private boolean ge(int[] A1, int s1, int[] A2, int s2) {
        int i = 0;
        while (i + s1 < A1.length && i + s2 < A2.length && A1[i + s1] == A2[i + s2])
            i++;
        return i + s2 == A2.length || i + s1 != A1.length && A1[i + s1] > A2[i + s2];
    }

    public static void main(String[] args) {
        CreateMaxNumber cn = new CreateMaxNumber();
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;

        System.out.println(Arrays.toString(cn.maxNumber(nums1, nums2, k)));
    }
}
