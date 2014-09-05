package problems;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // BFS search, takes extra space
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return a;

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode dum = new TreeNode(-1), t = null;
        q.add(dum);
        q.add(root);
        ArrayList<Integer> ls = null;

        while (q.size() > 0) {
            t = q.poll();
            if (t.val == -1) {
                if (ls != null)
                    a.add(ls);

                if (q.size() > 0) {
                    q.add(t);
                    ls = new ArrayList<Integer>();
                }
                continue;
            }

            ls.add(t.val);
            if (t.left != null)
                q.add(t.left);
            if (t.right != null)
                q.add(t.right);
        }
        return a;
    }

    public static void main(String[] args) {
        LevelOrderTraversal lo = new LevelOrderTraversal();

        TreeNode root = lo.new TreeNode(3);
        root.left = lo.new TreeNode(9);
        root.left.right = lo.new TreeNode(8);
        root.right = lo.new TreeNode(20);
        root.right.left = lo.new TreeNode(15);
        root.right.right = lo.new TreeNode(7);

        ArrayList<ArrayList<Integer>> a = lo.levelOrder(root);
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++)
                System.out.print(a.get(i).get(j) + "  ");
            System.out.println(";");
        }
    }
}
