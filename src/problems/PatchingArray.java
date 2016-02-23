package problems;

/**
 * LeetCode: Patching Array
 * Created by alan on 2/22/2016.
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long max = 1;  // in case overflow
        int cur = 0, count = 0;

        while (max <= n) {
            if (cur < nums.length && max >= nums[cur]) {
                // can cover at most [1, max + current number]
                max += nums[cur];
                cur++;
            } else {
                // add one number, at most cover [1, 2 * max]
                max <<= 1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PatchingArray pa = new PatchingArray();
        int[] nums = {1, 2, 31, 33};
        int n = 2147483647;

        System.out.println(pa.minPatches(nums, n));
    }
}
