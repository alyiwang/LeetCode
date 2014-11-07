package problems;

public class ReverseNodesInGroups {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2)
            return head;
        ListNode newHead = new ListNode(-1), p = newHead;
        newHead.next = head;
        while (p != null && p.next != null) {
            ListNode[] t = reverse(p.next, k);
            p.next = t[0];
            p = t[1];
        }
        return newHead.next;
    }

    // return the head and tail of the reversed group
    ListNode[] reverse(ListNode head, int k) {
        ListNode p = head, q = p.next, r = null;
        ListNode[] out = { head, null };
        for (int i = 1; i < k; i++) {
            if (p.next == null)
                return out;
            p = p.next;
        }
        p = head;
        for (int i = 1; i < k; i++) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head.next = q;
        out[0] = p;
        out[1] = head;
        return out;
    }

    public static void main(String[] args) {
        ReverseNodesInGroups rn = new ReverseNodesInGroups();

        int[] A = { 1, 2, 3, 4, 5 };
        ListNode head = null, p = null;
        for (int i = 0; i < A.length; i++) {
            ListNode t = rn.new ListNode(A[i]);
            if (head == null)
                head = p = t;
            else {
                p.next = t;
                p = t;
            }
        }

        ListNode l = rn.reverseKGroup(head, 5);
        while (l != null) {
            System.out.print(l.val + ", ");
            l = l.next;
        }
    }
}
