package problems;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = 0, y = 0;
        int base = 1;
        if (x < Integer.MIN_VALUE + 2)
            return false;
        if (x < 0)
            x = -x;

        y = x;
        while (y > 0) {
            len++;
            y /= 10;
        }
        for (int i = 0; i < len - 1; i++)
            base *= 10;

        y = x;
        for (int i = 0; i < len / 2; i++) {
            if (y / base != y % 10)
                return false;
            y -= y / base * base;
            y /= 10;
            base /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        int x = 2147447412;
        System.out.println(x + ": " + pn.isPalindrome(x));
    }
}