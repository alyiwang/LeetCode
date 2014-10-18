package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalStartComparator());
        for (int i = 1; i < intervals.size();) {
            if (intervals.get(i - 1).end >= intervals.get(i).start) {
                intervals.get(i - 1).end = Math.max(intervals.get(i).end, intervals.get(i - 1).end);
                intervals.remove(i);
            } else
                i++;
        }
        return intervals;
    }

    class IntervalStartComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            if (a.start < b.start)
                return -1;
            else if (a.start > b.start)
                return 1;
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(mi.new Interval(1, 4));
        intervals.add(mi.new Interval(0, 2));
        intervals.add(mi.new Interval(3, 5));

        List<Interval> out = mi.merge(intervals);
        for (int i = 0; i < intervals.size(); i++)
            System.out.print(" [" + out.get(i).start + ", " + out.get(i).end + "]");
    }
}
