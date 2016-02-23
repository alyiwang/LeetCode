package problems;

import java.util.Arrays;

/**
 * Leetcode: Increasing Triplet Subsequence
 * Created by alan on 2/23/2016.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;

        for (int t : nums) {
            if (t > two)
                return true;
            if (t < one)
                one = t;
            else if (t > one && t < two)
                two = t;
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence it = new IncreasingTripletSubsequence();
        int[] nums = {1, 6, -2, 2};

        System.out.print(Arrays.toString(nums) + " : " + it.increasingTriplet(nums));
    }
}
