package problems;

public class RomanToInteger {
    public int romanDigit(char c) {
        switch (c) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            return -1;
        }
    }

    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0, a = 0, b = 2000;

        for (int i = 0; i < len; i++) {
            a = romanDigit(s.charAt(i));
            if (a > b) {
                sum = sum - 2 * b + a;
                b = a;
            } else {
                sum += a;
                b = a;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger ri = new RomanToInteger();
        String s = "MCMLIV";
        System.out.println(s + ",  " + ri.romanToInt(s));
    }
}
