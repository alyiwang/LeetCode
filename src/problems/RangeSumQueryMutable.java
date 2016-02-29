package problems;

/**
 * Leetcode: Range Sum Query - Mutable
 * Fenwick tree (binary indexed tree) 
 * Created by alan on 2/29/16.
 */
public class RangeSumQueryMutable {
    final int n;
    final int[] num;
    final int[] Tr;

    public RangeSumQueryMutable(int[] nums) {
        this.n = nums.length;
        this.num = nums.clone();
        this.Tr = new int[n + 1];
        for (int i = 0; i < n; i++)
            add(i + 1, num[i]);
    }

    private int lowbit(int x) {
        return x & -x;
    }

    void add(int i, int val) {
        while (i <= n) {
            Tr[i] += val;
            i += lowbit(i);
        }
    }

    void update(int i, int val) {
        add(i + 1, val - num[i]);
        num[i] = val;
    }

    private int sum(int i) {
        int result = 0;
        while (i > 0) {
            result += Tr[i];
            i -= lowbit(i);
        }
        return result;
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        RangeSumQueryMutable rsq = new RangeSumQueryMutable(nums);

        System.out.println(rsq.sumRange(0, 2));
        rsq.update(1, 10);
        System.out.println(rsq.sumRange(0, 2));
    }
}
