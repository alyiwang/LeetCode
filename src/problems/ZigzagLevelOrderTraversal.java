package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
 Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 (ie, from left to right, then right to left for the next level and alternate between).
 */

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ZigzagLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        if (root == null)
            return out;

        List<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode end = root;
        List<Integer> list = new LinkedList<Integer>();
        boolean go_right = true;

        while (q.size() > 0) {
            TreeNode t = q.remove(0);
            if (go_right)
                list.add(t.val);
            else
                list.add(0, t.val);

            if (t.left != null)
                q.add(t.left);
            if (t.right != null)
                q.add(t.right);
            if (t == end) {
                out.add(list);
                if (q.size() == 0)
                    break;

                list = new LinkedList<Integer>();
                end = q.get(q.size() - 1);
                go_right = !go_right;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        ZigzagLevelOrderTraversal zz = new ZigzagLevelOrderTraversal();

        TreeNode t1 = zz.new TreeNode(1);
        TreeNode t2 = zz.new TreeNode(2);
        TreeNode t3 = zz.new TreeNode(3);
        t1.left = t2;
        t1.right = t3;

        System.out.println(zz.zigzagLevelOrder(t1));
    }
}
