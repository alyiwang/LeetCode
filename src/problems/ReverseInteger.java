package problems;

public class ReverseInteger {
    public int reverse(int x) {
        boolean sign = x < 0;
        long a = sign ? -x : x;

        // int -2,147,483,648 to 2,147,483,647
        int[] c = new int[10]; // at most 10 digits
        int l = 0, r = 0;
        boolean nonzero = false;
        while (a > 0) {
            int t = (int) (a % 10);
            a /= 10;
            c[r++] = t;
            if (t == 0 && !nonzero)
                l++;
            else
                nonzero = true;
        }

        long re = 0;
        int base = 1;
        for (int i = r - 1; i >= l; i--) {
            re += base * c[i];
            base *= 10;
        }
        if (!sign)
            re = -re;

        if (re > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (re < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int) re;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        
        int x = -901000;
        int y = ri.reverse(x);
        System.out.println("x: " + x + ", y: " + y);
    }
}
