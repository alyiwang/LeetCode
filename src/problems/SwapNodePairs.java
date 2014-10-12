package problems;

public class SwapNodePairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode l = head, r = head.next;
        ListNode pre = null;
        while (r != null) {
            if (Math.abs(l.val - r.val) <= 1) {
                if (pre == null) {
                    head = r;
                    l.next = r.next;
                    r.next = l;
                    r = l.next;
                    pre = head;
                } else {
                    pre.next = r;
                    l.next = r.next;
                    r.next = l;
                    pre = r;
                    r = l.next;
                }
            } else {
                pre = l;
                l = r;
                r = r.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        SwapNodePairs sp = new SwapNodePairs();

        int[] a = { 1, 2, 3, 4 };
        ListNode head = null, cur = null;

        for (int i = 0; i < a.length; i++) {
            ListNode t = sp.new ListNode(a[i]);
            if (head == null) {
                cur = t;
                head = cur;
            } else {
                cur.next = t;
                cur = t;
            }
        }

        head = sp.swapPairs(head);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
}
