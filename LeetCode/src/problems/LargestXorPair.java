package problems;

/**
 * Given a list of numbers, a[0], a[1], ... , a[N-1]. Find the maximum result of
 * a[i] XOR a[j]. All numbers in array are 32-bit unsigned integers. Example:
 * 11100 11001 10100 10001 01010 01000 00100 00001 Solution: 10100 01010
 * 
 * @author Yi
 */

public class LargestXorPair {
    // number of digits to consider
    // assuming the first digit is 0 (for positive)
    final int Digits = 6;

    class Node {
        Node zero, one;
    }

    final int maxXOR(final int[] A) {
        // Assume A contains all positive number (first digit 0)
        if (A.length <= 1)
            return 0;

        final Node root = new Node();
        for (final int k : A)
            insert(root, k);

        int max = 0;
        for (final int t : A) {
            final int p = findPair(root, t);
            max = Math.max(max, t ^ p);
        }
        return max;
    }

    final Node insert(final Node r, final int a) {
        Node n = r;
        for (int i = 1; i < Digits; i++) {
            if (digit1(a, i)) {
                if (n.one != null)
                    n = n.one;
                else {
                    Node newNode = new Node();
                    n.one = newNode;
                    n = newNode;
                }
            } else {
                if (n.zero != null)
                    n = n.zero;
                else {
                    Node newNode = new Node();
                    n.zero = newNode;
                    n = newNode;
                }
            }
        }
        return n;
    }

    final boolean digit1(final int a, final int digit) {
        int musk = 1 << (Digits - 1 - digit);
        return (a & musk) > 0;
    }

    final int findPair(Node r, int a) {
        Node n = r;

        int out = 0, base = 1 << (Digits - 2);

        for (int i = 1; i < Digits; i++) {
            if (n.zero == null || (n.one != null && !digit1(a, i))) {
                n = n.one;
                out += base;
            } else
                n = n.zero;

            base /= 2;
        }
        System.out.println(Integer.toBinaryString(a) + ", " + Integer.toBinaryString(out));
        return out;
    }

    public static void main(String[] args) {
        LargestXorPair lx = new LargestXorPair();

        final int[] A = { 0b11100, 0b11001, 0b10100, 0b10001, 0b01010, 0b01000, 0b00100, 0b00001 };

        final int max = lx.maxXOR(A);
        System.out.println(Integer.toBinaryString(max));
    }
}
