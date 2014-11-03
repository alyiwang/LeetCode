package problems;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;

        int n1 = s1.length(), n2 = s2.length();
        if (s3.length() != n1 + n2)
            return false;

        boolean[][] b = new boolean[n1 + 1][n2 + 1];
        b[0][0] = true;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i > 0 && b[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    b[i][j] = true;
                else if (j > 0 && b[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    b[i][j] = true;
            }
        }
        return b[n1][n2];
    }

    public static void main(String[] args) {
        InterleavingString is = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(is.isInterleave(s1, s2, s3));
    }
}
