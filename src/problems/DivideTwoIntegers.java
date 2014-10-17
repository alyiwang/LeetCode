package problems;

import java.util.ArrayList;
import java.util.List;

/* 
 * Divide two integers without using multiplication, division and mod operator.
 */

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        else if (divisor == 1)
            return dividend;

        boolean sign = true; // positive
        long divisorL = divisor;
        if (divisor < 0) {
            divisorL = -divisorL;
            sign = !sign;
        }
        long dividendL = dividend;
        if (dividend < 0) {
            dividendL = -dividendL;
            sign = !sign;
        }

        // both are positive
        List<Long> base = new ArrayList<Long>();
        List<Integer> power = new ArrayList<Integer>(); // 2^n
        long cur = divisorL;
        int power2 = 1;
        while (cur <= dividendL) {
            base.add(cur);
            cur += cur;
            power.add(power2);
            power2 += power2;
        }
        
        int result = 0;
        for (int i = base.size() - 1; i >= 0; i--) {
            long b = base.get(i);
            if (dividendL == b) {
                result += power.get(i);
                break;
            } else if (dividendL > b) {
                dividendL -= b;
                result += power.get(i);
            }            
        }
        return sign ? result : -result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers di = new DivideTwoIntegers();
        System.out.println(di.divide(-1, 1));
    }
}
