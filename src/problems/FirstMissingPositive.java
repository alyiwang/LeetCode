package problems;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0)
            return 1;
        
        for (int i = 0; i < A.length; ) {
            if (A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i])
                swap(A, i, A[i] - 1);
            else
                i++;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }
    
    void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        FirstMissingPositive fm = new FirstMissingPositive();
        int[] a = { 3, 4, -1, 1 };
        System.out.println(fm.firstMissingPositive(a));
    }
}