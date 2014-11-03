package problems;

public class PopulatingNextRightPointers2 {

    // Definition for binary tree with next pointer.
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root, subRow = null, subp = null;
        while (cur != null) {
            if (cur.left != null) {
                if (subRow == null) {
                    subRow = cur.left;
                    subp = subRow;
                } else {
                    subp.next = cur.left;
                    subp = subp.next;
                }
            }
            if (cur.right != null) {
                if (subRow == null) {
                    subRow = cur.right;
                    subp = subRow;
                } else {
                    subp.next = cur.right;
                    subp = subp.next;
                }
            }
            if (cur.next != null)
                cur = cur.next;
            else {
                cur = subRow;
                subRow = null;
            }
        }
    }
}
