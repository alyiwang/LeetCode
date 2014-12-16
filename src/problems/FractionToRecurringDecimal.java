package problems;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            return "NULL";
        
        boolean sign = false;
        if (numerator < 0) {
            numerator = -numerator;
            sign = !sign;
        }
        if (denominator < 0) {
            denominator = -denominator;
            sign = !sign;
        }
        StringBuilder sb = new StringBuilder();
        if (sign)
            sb.append('-');
        
        if (numerator >= denominator) {
            sb.append(numerator / denominator);
            numerator %= denominator;
        }
        if (numerator == 0)
            return sb.toString();
        
        while ()
    }
    
    public static void main(String[] args) {
        FractionToRecurringDecimal fd = new FractionToRecurringDecimal();
        int num = 2;
        int de = 3;
        System.out.println(fd.fractionToDecimal(num, de));
    }
}
