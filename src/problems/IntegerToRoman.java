package problems;

public class IntegerToRoman {
    public String intToRoman(int num) {
        String s = "";
        int base = 1000, index = 3;
        char[][] c = { { 'I', 'V' }, { 'X', 'L' }, { 'C', 'D' }, { 'M' } };

        while (num > 0) {
            if (num / base == 0) {
                base /= 10;
                index--;
                continue;
            }
            switch (num / base) {
            case 1:
                s += c[index][0];
                break;
            case 2:
                s += c[index][0];
                s += c[index][0];
                break;
            case 3:
                s += c[index][0];
                s += c[index][0];
                s += c[index][0];
                break;
            case 4:
                s += c[index][0];
                s += c[index][1];
                break;
            case 5:
                s += c[index][1];
                break;
            case 6:
                s += c[index][1];
                s += c[index][0];
                break;
            case 7:
                s += c[index][1];
                s += c[index][0];
                s += c[index][0];
                break;
            case 8:
                s += c[index][1];
                s += c[index][0];
                s += c[index][0];
                s += c[index][0];
                break;
            case 9:
                s += c[index][0];
                s += c[index + 1][0];
                break;
            default:
                break;
            }

            num -= num / base * base;
        }
        return s;
    }

    public static void main(String[] args) {
        IntegerToRoman ir = new IntegerToRoman();

        int x = 1954;
        System.out.println(x + "  " + ir.intToRoman(x));
    }
}
