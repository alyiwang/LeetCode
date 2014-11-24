package problems;

import java.util.Stack;

public class BinaryTreeUpsideDown {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    public final TreeNode upsideDownBinaryTree(TreeNode root) {
        // recursive solution
        if (root == null || root.left == null)
            return root;

        final TreeNode parent = root.left;
        final TreeNode head = upsideDownBinaryTree(parent);
        parent.left = root.right;
        parent.right = root;
        root.left = root.right = null;
        return head;
    }

    public final TreeNode upsideDownBinaryTree2(TreeNode root) {
        // iterative solution using stack
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode left = root;
        while (left != null) {
            st.push(left);
            left = left.left;
        }
        TreeNode head = st.isEmpty() ? null : st.pop();
        TreeNode parent = head;
        while (st.size() > 0) {
            TreeNode t = st.pop();
            parent.right = t;
            parent.left = t.right;
            t.left = t.right = null;
            parent = t;
        }
        return head;
    }

    void PreorderPrintTree(TreeNode root) {
        if (root == null)
            System.out.print("#,");
        else {
            System.out.print(root.val + ",");
            PreorderPrintTree(root.left);
            PreorderPrintTree(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeUpsideDown ud = new BinaryTreeUpsideDown();

        TreeNode root = ud.new TreeNode(1);
        root.left = ud.new TreeNode(2);
        root.right = ud.new TreeNode(3);
        root.left.left = ud.new TreeNode(4);
        root.left.right = ud.new TreeNode(5);

        TreeNode head = ud.upsideDownBinaryTree2(root);
        ud.PreorderPrintTree(head);
    }
}
