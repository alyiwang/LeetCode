package problems;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
            return 0;

        int n1 = word1.length(), n2 = word2.length();
        int[][] d = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++)
            d[i][0] = i;
        for (int i = 1; i <= n2; i++)
            d[0][i] = i;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int min = Math.min(d[i - 1][j - 1], Math.min(d[i - 1][j], d[i][j - 1]));
                d[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? d[i - 1][j - 1] : min + 1;
            }
        }
        return d[n1][n2];
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();

        String s1 = "ab", s2 = "bc";
        System.out.println(ed.minDistance(s1, s2));
    }
}
