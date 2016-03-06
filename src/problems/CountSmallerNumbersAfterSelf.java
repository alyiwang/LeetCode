package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode: Count of Smaller Numbers After Self
 * Created by yiwan on 3/6/16.
 */
public class CountSmallerNumbersAfterSelf {
    private class Node {
        final int val, idx;

        Node (int value, int index) {
            this.val = value;
            this.idx = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] re = new int[nums.length];
        final Node[] A = new Node[nums.length];
        for (int i = 0; i < nums.length; i++)
            A[i] = new Node(nums[i], i);
        mergesort(A, re);

        List<Integer> results = new ArrayList<>(nums.length);
        for (int r : re)
            results.add(r);
        return results;
    }

    private Node[] mergesort(final Node[] A, final int[] re) {
        if (A.length <= 1)
            return A;

        int mid = A.length / 2;
        Node[] left = mergesort(Arrays.copyOfRange(A, 0, mid), re);
        Node[] right = mergesort(Arrays.copyOfRange(A, mid, A.length), re);

        int l = mid - 1, r = A.length - mid - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (r < 0 || (l >= 0 && left[l].val > right[r].val)) {
                re[left[l].idx] += r + 1;
                A[i] = left[l--];
            } else
                A[i] = right[r--];
        }
        return A;
    }

    public static void main(String[] args) {
        CountSmallerNumbersAfterSelf cs = new CountSmallerNumbersAfterSelf();
        int[] nums = {5, 2, 6, 1};

        System.out.println(cs.countSmaller(nums));
    }
}
