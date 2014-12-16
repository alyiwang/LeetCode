package problems;

public class QuickSelect {
    // Select the Kth smallest number in A, average O(n)
    public int select(int[] A, int K) {
        if (A == null || A.length == 0 || A.length < K)
            return -1;

        return quickSelect(A, 0, A.length - 1, K);
    }

    public int quickSelect(int[] A, int l, int r, int K) {
        int p = l;
        for (int i = l; i < r; i++) {
            if (A[i] < A[r])
                swap(A, i, p++);
        }
        swap(A, p, r);
        if (K == p - l + 1)
            return A[p];
        else if (K <= p - l)
            return quickSelect(A, l, p - 1, K);
        else
            return quickSelect(A, p + 1, r, K - p + l - 1);
    }

    public void swap(int[] A, int p, int q) {
        int t = A[p];
        A[p] = A[q];
        A[q] = t;
    }

    public static void main(String[] args) {
        QuickSelect qs = new QuickSelect();
        int[] A = { 3, 2, 5, 7, 5, 3, 9, 0, 1, 8 };
        int K = 3;
        System.out.println(qs.select(A, K));
    }
}
