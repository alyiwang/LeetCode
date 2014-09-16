package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        
        List<Integer> out = inorderTraversal(root.left);
        out.add(root.val);
        out.addAll(inorderTraversal(root.right));
        return out;
    }
    
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> out = new ArrayList<Integer>();
        if (root == null)
            return out;

        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        HashSet<TreeNode> done = new HashSet<TreeNode>();

        while (!st.isEmpty()) {
            TreeNode t = st.peek();
            if (t.left == null || done.contains(t.left)) {
                st.pop();
                done.add(t);
                out.add(t.val);
                if (t.right != null)
                    st.push(t.right);
            } else
                st.push(t.left);
        }
        return out;
    }
}
