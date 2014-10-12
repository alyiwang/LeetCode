package problems;

import java.util.HashMap;

public class MaxPointsOnLine {

    class Point {
        int x, y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        if (points.length <= 2)
            return points.length;

        int max = 0;
        for (Point p : points) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int dup = 1, vertical = 0; // duplicated points and vertical line
            for (Point t : points) {
                if (t == p)
                    continue;
                if (p.x == t.x) {
                    if (p.y == t.y)
                        dup++;
                    else
                        vertical++;
                } else {
                    final double slope = (double) (t.y - p.y) / (t.x - p.x);
                    if (!map.containsKey(slope))
                        map.put(slope, 1);
                    else
                        map.put(slope, map.get(slope) + 1);
                }
            }
            max = Math.max(max, vertical + dup);
            for (final int num : map.values())
                max = Math.max(max, num + dup);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPointsOnLine mp = new MaxPointsOnLine();
        Point a = mp.new Point(-1, -1), b = mp.new Point(0, 0), c = mp.new Point(1, 1);
        Point[] pts = { a, b, c };
        System.out.print(mp.maxPoints(pts));
    }
}
