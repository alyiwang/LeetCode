package problems;

import java.util.Stack;

/**
 * Leetcode: Verify Preorder Serialization of a Binary Tree
 * Created by alan on 2/22/2016.
 */
public class VerifyPreorderTree {

    public boolean isValidSerialization(String preorder) {
        Stack<Integer> st = new Stack<>(); // store the children count in stack
        String[] strings = preorder.split(",");

        for (String s : strings) {
            if (s.equals("#")) {
                while (!st.empty() && st.peek() > 0)
                    st.pop();
                if (st.empty())
                    return s == strings[strings.length - 1]; // check if s is last one
                st.pop();
                st.push(1);
            } else
                st.push(0);
        }
        return st.empty();
    }

    public static void main(String[] args) {
        final VerifyPreorderTree vp = new VerifyPreorderTree();

        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(preorder + " : " + vp.isValidSerialization(preorder));
    }
}
