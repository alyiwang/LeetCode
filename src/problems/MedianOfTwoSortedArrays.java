package problems;

/*
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        if (m == 0)
            return median(B, 0, n - 1);
        if (n == 0)
            return median(A, 0, m - 1);

        return findMedian(A, 0, m - 1, B, 0, n - 1);
    }

    public double median(int[] A, int l, int r) {
        // assume A is not empty and l, r are valid
        int n = r - l + 1;
        if (n <= 0)
            return 0;

        if (n % 2 == 1)
            return A[l + n / 2];

        return (A[l + n / 2 - 1] + A[l + n / 2]) / 2.0;
    }

    public double medianAnd1(int[] A, int l, int r, int mid) {
        int n = r - l + 1;
        if (n <= 1)
            return (A[l] + mid) / 2.0;

        double median = 0;
        if (n % 2 == 0) {
            int a = A[l + n / 2 - 1], b = A[l + n / 2];
            if (mid <= a)
                median = a;
            else if (mid <= b)
                median = mid;
            else
                median = b;
        } else {
            int a = A[l + n / 2 - 1], b = A[l + n / 2], c = A[l + n / 2 + 1];
            if (mid <= a)
                median = (a + b) / 2.0;
            else if (mid <= c)
                median = (mid + b) / 2.0;
            else
                median = (b + c) / 2.0;
        }
        return median;
    }

    public double medianAnd2(int[] A, int l, int r, int m1, int m2) {
        int n = r - l + 1; // assume at least 2
        double median = 0;
        int a = 0, b = 0, c = 0, d = 0;
        if (n % 2 == 0) {
            if (n > 2)
                a = A[l + n / 2 - 2];
            else
                a = Integer.MIN_VALUE;

            b = A[l + n / 2 - 1];
            c = A[l + n / 2];
            if (n > 2)
                d = A[l + n / 2 + 1];
            else
                d = Integer.MAX_VALUE;

            if (m2 <= b)
                median = (b + Math.max(a, m2)) / 2.0;
            else if (m1 <= b)
                median = (b + Math.min(c, m2)) / 2.0;
            else if (m2 <= c)
                median = (m1 + m2) / 2.0;
            else if (m1 <= c)
                median = (m1 + c) / 2.0;
            else
                median = (c + Math.min(d, m1)) / 2.0;
        } else {
            a = A[l + n / 2 - 1];
            b = A[l + n / 2];
            c = A[l + n / 2 + 1];
            if (m2 <= a)
                median = a;
            else if (m1 <= b)
                median = Math.min(b, m2);
            else
                median = Math.min(c, m1);
        }
        return median;
    }

    public double findMedian(int[] A, int la, int ra, int[] B, int lb, int rb) {
        int m = ra - la + 1, n = rb - lb + 1;
        if (m == 1)
            return medianAnd1(B, lb, rb, A[la]);
        if (n == 1)
            return medianAnd1(A, la, ra, B[lb]);
        if (m == 2)
            return medianAnd2(B, lb, rb, A[la], A[la + 1]);
        if (n == 2)
            return medianAnd2(A, la, ra, B[lb], B[lb + 1]);

        int i = m / 2, j = n / 2, k = 0;
        if (A[la + i] <= B[lb + j]) {
            if (m % 2 == 0)
                k = Math.min(i - 1, n - j - 1);
            else
                k = Math.min(i, n - j - 1);

            return findMedian(A, la + k, ra, B, lb, rb - k);
        } else {
            if (n % 2 == 0)
                k = Math.min(m - i - 1, j - 1);
            else
                k = Math.min(m - i - 1, j);

            return findMedian(A, la, ra - k, B, lb + k, rb);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays ma = new MedianOfTwoSortedArrays();
        int[] A = {};
        int[] B = { 2, 3 };

        System.out.println(ma.findMedianSortedArrays(A, B));
    }
}
