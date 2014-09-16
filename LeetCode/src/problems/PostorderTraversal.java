package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> out = new LinkedList<Integer>();
        if (root == null)
            return out;

        out.addAll(postorderTraversal(root.left));
        out.addAll(postorderTraversal(root.right));
        out.add(root.val);
        return out;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> out = new LinkedList<Integer>();
        if (root == null)
            return out;

        Stack<TreeNode> st = new Stack<TreeNode>();
        st.add(root);
        HashSet<TreeNode> done = new HashSet<TreeNode>();

        while (!st.isEmpty()) {
            TreeNode t = st.peek();
            if ((t.left == null || done.contains(t.left))
                    && (t.right == null || done.contains(t.right))) {
                st.pop();
                out.add(t.val);
                done.add(t);
                continue;
            }
            if (t.right != null)
                st.push(t.right);
            if (t.left != null)
                st.push(t.left);
        }
        return out;
    }
}
