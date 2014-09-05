package problems;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        if (S.length == 0)
            return new LinkedList<List<Integer>>();

        Arrays.sort(S);
        return allSubsets(S, 0);
    }

    List<List<Integer>> allSubsets(int[] S, int k) {
        List<List<Integer>> out = new LinkedList<List<Integer>>();
        if (k >= S.length - 1) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(S[k]);
            out.add(list);
            out.add(new LinkedList<Integer>());
            return out;
        }

        List<List<Integer>> b = allSubsets(S, k + 1);
        out.addAll(b);
        for (int i = 0; i < b.size(); i++) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(S[k]);
            list.addAll(b.get(i));
            out.add(list);
        }
        return out;
    }

    public List<List<Integer>> subsets2(int[] S) {
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        int len = S.length;
        if (len <= 0)
            return a;

        Arrays.sort(S);

        boolean[] b = new boolean[len];
        boolean carry = false;

        while (true) {
            ArrayList<Integer> t = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                if (b[i])
                    t.add(S[i]);
            }
            a.add(t);

            // do boolean add from 0 to len-1
            boolean[] tmp = addBool(b[0], true, carry);
            carry = tmp[1];
            b[0] = tmp[0];
            for (int i = 1; i < len; i++) {
                tmp = addBool(b[i], false, carry);
                carry = tmp[1];
                b[i] = tmp[0];
                if (!carry)
                    break;
            }
            if (carry)
                break;
        }
        return a;
    }

    boolean[] addBool(boolean a, boolean b, boolean carry) {
        boolean re[] = new boolean[2];
        re[0] = a != b;
        re[1] = a && b;
        if (re[1])
            re[0] = carry;
        else {
            re[1] = re[0] && carry;
            re[0] = re[0] != carry;
        }
        return re;
    }

    public static void main(String[] args) {
        Subsets ss = new Subsets();

        int[] S = { 4, 1 };
        List<List<Integer>> a = ss.subsets(S);

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++)
                System.out.print(" " + a.get(i).get(j));
            System.out.print(" ;");
        }
    }
}
