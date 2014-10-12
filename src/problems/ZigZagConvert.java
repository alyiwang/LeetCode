package problems;

public class ZigZagConvert {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;

        int len = s.length();
        int nCols = len / 2 + 1;

        char[][] a = new char[nRows][nCols];
        boolean dir = true; // true: going down, false: up
        int x = 0, y = 0; // current location

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            a[x][y] = c;
            if (dir) {
                if (x >= nRows - 1) {
                    dir = false;
                    x--;
                    y++;
                } else
                    x++;
            } else {
                if (x <= 0) {
                    dir = true;
                    x++;
                } else {
                    x--;
                    y++;
                }
            }
        }

        String re = "";
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (a[i][j] != 0)
                    re += a[i][j];
            }
        }
        return re;
    }

    public static void main(String[] args) {
        ZigZagConvert zz = new ZigZagConvert();
        String s = "ab";
        System.out.println(zz.convert(s, 1));
    }
}
