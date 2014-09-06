package problems;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        int max = 0, i = 0;
        Stack<Integer> S = new Stack<Integer>();
        while (i <= height.length) {
            if (i == height.length && S.empty())
                i++;
            else if (i < height.length && (S.empty() || height[S.peek()] < height[i])) {
                S.push(i);
                i++;
            } else {
                int t = S.pop();
                max = Math.max(max, height[t] * (S.empty() ? i : i - S.peek() - 1));
            }
        }
        return max;
    }
    
    public static void main (String[] args) {
        LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
        
        int[] height = {2,1,5,6,2,3};
        
        System.out.println(lr.largestRectangleArea(height));
    }
}
