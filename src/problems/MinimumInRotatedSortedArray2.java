package problems;

public class MinimumInRotatedSortedArray2 {
    public int findMin(int[] num) {
        if (num == null || num.length == 0)
            return 0;

        return findMinHelper(num, 0, num.length - 1);
    }
    
    int findMinHelper(int[] A, int l, int r) {
        if (r - l <= 1)
            return Math.min(A[l], A[r]);
        
        int mid = (l + r) / 2;
        if (A[mid] >= A[l] && A[mid] > A[r])
            return findMinHelper(A, mid, r);
        if (A[mid] == A[l] && A[mid] == A[r])
            return Math.min(findMinHelper(A, mid, r), findMinHelper(A, l, mid - 1));
        return findMinHelper(A, l, mid);
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray2 ma = new MinimumInRotatedSortedArray2();
        int[] A = { 4, 5, 6, 7, 0, 0, 0, 0, 0 };

        System.out.println(ma.findMin(A));
    }
}
