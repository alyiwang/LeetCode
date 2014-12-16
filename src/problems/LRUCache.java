package problems;

import java.util.HashMap;

public class LRUCache {

    private int cap;
    private Node head, tail;
    private HashMap<Integer, Node> map;

    private class Node {
        int key, val;
        Node pre, next;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
            pre = next = null;
        }
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head = this.tail = null;
        this.map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node t = map.get(key);
        moveBack(t);
        return t.val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node t = map.get(key);
            t.val = value;
            moveBack(t);
        } else {
            if (map.size() == cap) {
                map.remove(head.key);
                remove(head);
            }
            Node t = new Node(key, value);
            add(t);
            map.put(key, t);
        }
    }

    private void remove(Node t) {
        if (t.pre != null)
            t.pre.next = t.next;
        else
            head = t.next;
        if (t.next != null)
            t.next.pre = t.pre;
        else
            tail = t.pre;
        t.pre = t.next = null;
    }

    private void add(Node t) {
        if (head == null)
            head = tail = t;
        else {
            tail.next = t;
            t.pre = tail;
            tail = t;
        }
    }

    private void moveBack(Node t) {
        remove(t);
        add(t);
    }
}
