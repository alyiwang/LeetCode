package problems;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int[] A = new int[s.length() + 1];
        A[0] = 1;
        A[1] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2')
                    A[i + 1] = 0;
                else
                    A[i + 1] = A[i - 1];
            } else {
                int t = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
                if (t <= 26 && t > 10)
                    A[i + 1] = A[i] + A[i - 1];
                else
                    A[i + 1] = A[i];
            }
        }
        return A[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();

        String s = "120";

        System.out.print(dw.numDecodings(s));
    }
}
