package problems;

public class IntegerBreak {

  static long[] A = new long[100];

  public long integerBreak(int n) {
    A[1] = 1;
    for (int i = 1; i < n; i++) {
      long left = Math.max(i, getMax(i));
      long right = Math.max(n - i, getMax(n - i));
      A[n] = Math.max(left * right, A[n]);
    }
    return A[n];
  }

  private long getMax(int n) {
    if (A[n] == 0)
      A[n] = integerBreak(n);
    return A[n];
  }

  public static void main(String[] args) {
    IntegerBreak ib = new IntegerBreak();

    System.out.println(ib.integerBreak(99));
  }
}
