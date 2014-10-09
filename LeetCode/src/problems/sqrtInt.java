package problems;

public class sqrtInt {
    public int sqrt(int x) {
        int l = 0, r = Integer.MAX_VALUE - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            long square = (long) mid * mid;
            if (square == x)
                return mid;
            if (square > x)
                r = mid - 1;
            else
                l = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        sqrtInt sq = new sqrtInt();
        int a = 100;
        System.out.println("sqrt of " + a + " is " + sq.sqrt(a));
    }
}
