package problems;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length <= 1)
            return 0;

        int a = 0, b = height.length - 1;
        int max = 0;
        while (b > a) {
            int volumn = Math.min(height[a], height[b]) * (b - a);
            if (volumn > max)
                max = volumn;
            if (height[a] <= height[b])
                a++;
            else
                b--;
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cw = new ContainerWithMostWater();
        int[] height = { 1, 3, 2, 5, 3 };
        System.out.println(cw.maxArea(height));
    }
}
