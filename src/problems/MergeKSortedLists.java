package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Pair implements Comparable<Pair> {
        ListNode node;
        int idx;

        Pair(ListNode ln, int index) {
            node = ln;
            idx = index;
        }

        public int compareTo(Pair p) {
            return node.val - p.node.val;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        ListNode head = null, p = null;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        List<ListNode> A = new ArrayList<ListNode>(lists);

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) != null)
                pq.add(new Pair(A.get(i), i));
        }

        while (pq.size() > 0) {
            Pair t = pq.poll();
            if (head == null) {
                head = t.node;
                p = head;
            } else {
                p.next = t.node;
                p = p.next;
            }
            A.set(t.idx, A.get(t.idx).next);
            if (A.get(t.idx) != null) {
                pq.add(new Pair(A.get(t.idx), t.idx));
            }
        }
        return head;
    }
}
