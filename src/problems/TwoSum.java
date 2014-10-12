package problems;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length <= 0)
            return null;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] re = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                re[0] = map.get(target - numbers[i]);
                re[1] = i + 1;
                return re;
            } else
                map.put(numbers[i], i + 1);
        }
        return re;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int len = numbers.length;
        int[] a = new int[len];
        for (int i = 0; i < len; i++)
            a[i] = numbers[i];
        Arrays.sort(a);

        int p = 0, q = len - 1;
        while (q > p) {
            if (a[p] + a[q] == target)
                break;
            else if (a[p] + a[q] < target)
                p++;
            else
                q--;
        }

        int[] re = new int[2];
        for (int i = 0; i < len; i++) {
            if (numbers[i] == a[p])
                re[0] = i + 1;
        }
        for (int i = 0; i < len; i++) {
            if (i + 1 != re[0] && numbers[i] == a[q])
                re[1] = i + 1;
        }

        if (re[0] > re[1]) {
            int t = re[0];
            re[0] = re[1];
            re[1] = t;
        }
        return re;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        int[] numbers = { 5, 75, 25 };
        int target = 100;

        int[] re = ts.twoSum(numbers, target);
        System.out.println("index1=" + re[0] + ", index2=" + re[1]);
    }
}
