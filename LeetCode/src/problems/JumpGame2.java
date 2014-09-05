package problems;

public class JumpGame2 {
    public int jump(int[] A) {
        int n = A.length;
        if (n == 0)
            return 0;

        int t = 0, max = A[0], step = 0;
        while (t < n - 1) {
            step++;
            if (max >= n - 1)
                return step;
            int new_max = max;
            for (int i = t + 1; i <= max; i++) {
                new_max = Math.max(new_max, i + A[i]);
                if (new_max >= n - 1)
                    return step + 1;
            }
            t = max; 
            max = new_max;
        }
        return step;
    }

    public static void main(String[] args) {
        JumpGame2 jg = new JumpGame2();

        int[] A = { 2,3,1,1,4 };

        int out = jg.jump(A);

        System.out.println(out);
    }
}
