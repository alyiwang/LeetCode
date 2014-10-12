package problems;

public class AddBinary {
    public String addBinary(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        if (n1 <= 0)
            return b;
        if (n2 <= 0)
            return a;

        int carry = 0, t1 = 0, t2 = 0, sum = 0;
        int len = Math.max(n1, n2);
        String out = "";

        for (int i = 1; i <= len; i++) {
            t1 = t2 = 0;
            if (i <= n1)
                t1 = a.charAt(n1 - i) - '0';
            if (i <= n2)
                t2 = b.charAt(n2 - i) - '0';

            sum = t1 + t2 + carry;
            if (sum >= 3) {
                out = '1' + out;
                carry = 1;
            } else if (sum == 2) {
                out = '0' + out;
                carry = 1;
            } else if (sum == 1) {
                out = '1' + out;
                carry = 0;
            } else
                out = '0' + out;
        }
        if (carry > 0)
            out = '1' + out;

        return out;
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();

        String s1 = "11", s2 = "1";

        System.out.println(ab.addBinary(s1, s2));
    }
}
