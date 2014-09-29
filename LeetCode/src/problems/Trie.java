package problems;

import java.util.HashMap;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node((char) 0);
    }

    public class Node {
        final char ch;
        boolean end;
        final HashMap<Character, Node> child;

        public Node(char c) {
            this.ch = c;
            child = new HashMap<Character, Node>();
        }
    }

    public Node insert(String s) {
        Node n = root;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (n.child.containsKey(a))
                n = n.child.get(a);
            else {
                Node newNode = new Node(a);
                n.child.put(a, newNode);
                n = newNode;
            }
        }
        n.end = true;
        return n;
    }

    public String longestMatch(String s) {
        String out = "";
        Node n = root;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (n.child.containsKey(c)) {
                out += c;
                n = n.child.get(c);
            } else
                break;
        }
        return out;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();

        String[] a = { "ra", "rob", "rooc" };
        for (String s : a)
            trie.insert(s);

        System.out.println(trie.longestMatch("roab"));
    }
}
