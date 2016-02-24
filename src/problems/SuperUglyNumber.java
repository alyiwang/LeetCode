package problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Leetcode: Super Ugly Number
 * Created by alan on 2/24/2016.
 */
public class SuperUglyNumber {
    class Node implements Comparable<Node> {
        int val;
        final int prime_index;

        public Node(int value, int prime_idx) {
            this.val = value;
            this.prime_index = prime_idx;
        }

        public int compareTo(Node a) {
            return this.val - a.val;
        }
    }

    public int[] nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[n];
        nums[0] = 1;

        int[] index = new int[primes.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++)
            pq.add(new Node(primes[i], i));

        for (int i = 1; i < n; i++) {
            Node node = pq.poll();
            while (node.val == nums[i - 1]) {
                node.val = nums[++index[node.prime_index]] * primes[node.prime_index];
                pq.add(node);
                node = pq.poll();
            }
            nums[i] = node.val;
            node.val = nums[++index[node.prime_index]] * primes[node.prime_index];
            pq.add(node);
        }
        return nums;
    }

    public static void main(String[] args) {
        SuperUglyNumber sn = new SuperUglyNumber();
        int[] primes = {2, 7, 13, 19};

        System.out.println(Arrays.toString(primes));
        System.out.println(Arrays.toString(sn.nthSuperUglyNumber(12, primes)));
    }
}
