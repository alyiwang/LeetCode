package problems;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            return "NULL";
        
        long num = numerator > 0 ? numerator : -(long)numerator;
        long den = denominator > 0 ? denominator : -(long)denominator;        
        StringBuilder sb = new StringBuilder();
        if (1.0 * numerator / denominator < 0)
            sb.append('-');
        
        sb.append(num / den);
        num %= den;
        if (num == 0)
            return sb.toString();        
        sb.append('.');
        
        int i = sb.length();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (num > 0) {
            if (map.containsKey(num)) {
                int t = map.get(num);
                sb.insert(t, '(');
                sb.append(')');
                return sb.toString();
            }
            map.put(num, i++);
            num *= 10;
            sb.append(num / den);
            num %= den;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        FractionToRecurringDecimal fd = new FractionToRecurringDecimal();
        int num = -1;
        int de = -2147483648;
        System.out.println(fd.fractionToDecimal(num, de));
    }
}
