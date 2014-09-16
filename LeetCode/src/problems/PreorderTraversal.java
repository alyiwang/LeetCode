package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> out = new LinkedList<Integer>();
        if (root == null)
            return out;
        
        out.add(root.val);
        out.addAll(preorderTraversal(root.left));
        out.addAll(preorderTraversal(root.right));
        return out;
    }
    
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> out = new LinkedList<Integer>();
        if (root == null)
            return out;
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode t = st.pop();
            out.add(t.val);
            
            if (t.right != null)
                st.push(t.right);
            if (t.left != null)
                st.push(t.left);
        }
        return out;
    }    
}
