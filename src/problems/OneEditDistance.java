package problems;

public class OneEditDistance {
    public boolean oneEdit(String A, String B) {
        if (A == null || B == null)
            return false;
        final int n1 = A.length(), n2 = B.length();
        if (Math.abs(n1 - n2) > 1)
            return false;

        final int[] T = { 1, 0, 1 };
        for (int i = 0; i < n2; i++) {
            if (i == 0 || A.charAt(i - 1) != B.charAt(i))
                T[0] = T[1] + 1;
            if (i >= n1)
                return T[0] < 2;

            if (A.charAt(i) != B.charAt(i))
                T[1] = Math.min(T[0], Math.min(T[1], T[2])) + 1;

            if (i + 1 >= n1 || A.charAt(i + 1) != B.charAt(i))
                T[2] = T[1] + 1;
        }
        return T[1] < 2 || T[2] < 2;
    }

    public static void main(String[] args) {
        OneEditDistance oe = new OneEditDistance();

        String A = "adc";
        String B = "adbc";
        System.out.println(oe.oneEdit(A, B));
    }
}
