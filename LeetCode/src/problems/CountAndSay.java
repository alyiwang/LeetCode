package problems;

public class CountAndSay {
    public String count(String s, int n) {
        if (n <= 0)
            return s;

        int len = s.length();
        String out = "";
        int p = 1;
        char c = s.charAt(0);
        int num = 1;

        while (p < len) {
            if (s.charAt(p) == c)
                num++;
            else {
                out += num + "" + c;
                c = s.charAt(p);
                num = 1;
            }
            p++;
        }
        out += num + "" + c;
        System.out.println(out);

        return count(out, n - 1);
    }

    public String countAndSay(int n) {
        if (n <= 0)
            return null;

        String s = "1";
        return count(s, n - 1);
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();

        cs.countAndSay(20);
    }
}
