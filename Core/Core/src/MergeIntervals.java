/*      merge overlapping intervals
        ✅ Output for this example:
            Merged Intervals: [[1, 6], [8, 10], [15, 18]]

            How it works:

        Sort intervals by their start time.

        Compare current interval with previous:

        If overlapping (curr.start <= prev.end), merge by updating prev.end.

        Else, add prev to result and move prev to current.

        Add the last interval after the loop.
 */
import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}


public class MergeIntervals {

    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> merged = new ArrayList<>();
        Interval prev = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start <= prev.end) {
                // Overlapping intervals, merge them
                prev.end = Math.max(prev.end, curr.end);
            } else {
                // No overlap, add previous interval
                merged.add(prev);
                prev = curr;
            }
        }

        // Add the last interval
        merged.add(prev);

        return merged;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        List<Interval> merged = mergeIntervals(intervals);
        System.out.println("Merged Intervals: " + merged);
    }
}
