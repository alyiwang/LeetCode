package problems;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return trees(1, n);
    }
    
    List<TreeNode> trees(int l, int r) {
        List<TreeNode> out = new ArrayList<TreeNode>();
        if (r < l) {
            out.add(null);
            return out;
        }
        
        for (int i = l; i <= r; i++) { 
            List<TreeNode> left = trees(l, i - 1);
            List<TreeNode> right = trees(i + 1, r);
            
            for (TreeNode t1 : left) {
                for (TreeNode t2 : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = t1; 
                    node.right = t2;
                    out.add(node);
                }
            }
        }
        return out;
    }
}
