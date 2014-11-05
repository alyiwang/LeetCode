package problems;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public class Interval {
		int start, end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		// record the insert position
		int p = search(intervals, 0, newInterval.start);
		if (p > 0 && intervals.get(p - 1).end >= newInterval.start)
			newInterval.start = intervals.get(--p).start;

		// record the intervals to be removed
		int q = search(intervals, p, newInterval.end);
		if (q > 0 && intervals.get(q - 1).end > newInterval.end)
			newInterval.end = intervals.get(q - 1).end;
		// remove intervals from p to q - 1
		for (int i = q - 1; i >= p; i--)
			intervals.remove(i);

		intervals.add(p, newInterval); // insert the new interval
		return intervals;
	}

	final int search(List<Interval> In, int l, int val) {
		for (int i = l; i < In.size(); i++) {
			if (In.get(i).start > val)
				return i;
		}
		return In.size();
	}

	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();

		List<Interval> intervals = new ArrayList<Interval>();
		int[] A = { 1, 2, 3, 5, 6, 7, 8, 10, 12, 16 };
		for (int i = 0; i < A.length / 2; i++) {
			Interval it = ii.new Interval(A[2 * i], A[2 * i + 1]);
			intervals.add(it);
		}

		Interval newInterval = ii.new Interval(4, 9);
		List<Interval> out = ii.insert(intervals, newInterval);
		for (Interval it : out)
			System.out.println("[" + it.start + ", " + it.end + "]");
	}
}
