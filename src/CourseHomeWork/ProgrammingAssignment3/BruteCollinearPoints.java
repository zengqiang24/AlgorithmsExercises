package ProgrammingAssignment3;

import java.util.*;

/**
 * Created by qiangzeng on 17/4/24.
 */
public class BruteCollinearPoints {
    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException();
        }
        Set<LineSegment> lineSegmentList = new HashSet<>();

        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int m = k + 1; k < points.length; m++) {
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[m];
                        if (p.slopeTo(q) == q.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s)) {
                            lineSegmentList.add(new LineSegment(p, s));
                        }
                    }
                }
            }
        }
        segments = lineSegmentList.toArray(new LineSegment[lineSegmentList.size()]);

    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments() {

        return Arrays.copyOf(segments, segments.length);
    }


}
