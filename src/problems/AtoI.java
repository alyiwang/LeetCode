package problems;

public class AtoI {
    public int atoi(String str) {
        int l = str.length();
        if (l == 0)
            return 0; // null string
        int i = 0;
        boolean minus = false;
        char c = 0;
        long sum = 0;

        while ((c = str.charAt(i)) == ' ') {
            i++;
            if (i >= l)
                return 0; // all whitespaces
        }

        if (c == '-') {
            minus = true;
            i++;
        } else if (c == '+') {
            minus = false;
            i++;
        }

        while (i < l) {
            c = str.charAt(i);
            if (!Character.isDigit(c))
                break;
            else
                sum = sum * 10 + c - '0';
            i++;
        }

        if (minus) {
            long t = Integer.MIN_VALUE;
            if (sum > -t)
                return Integer.MIN_VALUE;
            else
                return -1 * (int) sum;
        } else if (sum > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) sum;
    }

    public static void main(String[] args) {
        AtoI ai = new AtoI();
        System.out.println(ai.atoi("-1"));
    }
}
