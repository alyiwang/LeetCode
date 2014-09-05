package problems;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        if (n <= 0)
            return 1;

        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] <= n)
                if (A[i] != i + 1 && A[A[i] - 1] != A[i]) {
                    int t = A[i] - 1;
                    A[i] = A[t];
                    A[t] = t + 1;
                    i--;
                }
        }
        for (int i = 0; i < n; i++)
            if (A[i] != i + 1)
                return i + 1;
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive fm = new FirstMissingPositive();
        int[] a = { 3, 4, -1, 1 };
        System.out.println(fm.firstMissingPositive(a));
    }
}