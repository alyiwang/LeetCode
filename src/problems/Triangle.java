package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, 
where n is the total number of rows in the triangle.
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int k = triangle.size();
        int[] A = new int[k]; // dynamic storage

        // bottom up
        for (int i = 0; i < k; i++)
            A[i] = triangle.get(k - 1).get(i);

        for (int i = k - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i - 1).get(j);
        }
        return A[0];
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        List<List<Integer>> tri = new ArrayList<List<Integer>>();
        tri.add(new ArrayList<Integer>(Arrays.asList(2)));
        tri.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        tri.add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
        tri.add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));

        System.out.println(triangle.minimumTotal(tri));
    }
}