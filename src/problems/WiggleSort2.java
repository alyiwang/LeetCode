package problems;

import java.util.Arrays;

/**
 * Leetcode: Wiggle Sort II
 * Created by alan on 2/25/2016.
 */
public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] temp = new int[n];
        int l = (n - 1) / 2, r = n - 1;
        for (int i = 0; i < n; i++)
            temp[i] = (i % 2) == 0 ? nums[l--] : nums[r--];

        System.arraycopy(temp, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        WiggleSort2 ws = new WiggleSort2();
        int[] nums = {1,1,2,1,2,2,1};

        ws.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
