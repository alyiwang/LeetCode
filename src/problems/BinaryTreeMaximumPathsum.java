package problems;

public class BinaryTreeMaximumPathsum {

    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        return pathSum(root)[1];
    }

    int[] pathSum(TreeNode r) {
        int[] out = new int[2]; // out[0] long leg, out[1] pathSum

        int leftMax = 0, rightMax = 0, leftSum = Integer.MIN_VALUE, rightSum = leftSum;
        if (r.left != null) {
            int[] left = pathSum(r.left);
            leftMax = Math.max(0, left[0]);
            leftSum = left[1];
        }
        if (r.right != null) {
            int[] right = pathSum(r.right);
            rightMax = Math.max(0, right[0]);
            rightSum = right[1];
        }

        out[0] = r.val + Math.max(leftMax, rightMax);
        out[1] = Math.max(r.val + leftMax + rightMax, Math.max(leftSum, rightSum));
        return out;
    }
}
