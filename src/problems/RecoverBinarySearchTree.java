package problems;

public class RecoverBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    // O(n) time and O(1) space, Morris traversal.
    public void recoverTree(TreeNode root) {
        TreeNode cur = root, pre = null, n1 = null, n2 = null;
        while (cur != null) {
            if (cur.left == null) {
                if (pre != null && pre.val > cur.val) {
                    if (n1 == null)
                        n1 = pre;
                    n2 = cur;
                }
                pre = cur;
                cur = cur.right;
            } else {
                TreeNode t = cur.left;
                while (t.right != null && t.right != cur)
                    t = t.right;
                if (t.right == null) {
                    t.right = cur;
                    cur = cur.left;
                } else {
                    t.right = null;
                    if (pre != null && pre.val > cur.val) {
                        if (n1 == null)
                            n1 = pre;
                        n2 = cur;
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
        if (n1 != null && n2 != null) {
            int t = n1.val;
            n1.val = n2.val;
            n2.val = t;
        }
    }
}
