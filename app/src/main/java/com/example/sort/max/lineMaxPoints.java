package com.example.sort.max;

//import android.graphics.Point;

import java.util.HashMap;
import java.util.Map;

public class lineMaxPoints {
    public static class Point {
        public double x;
        public double y;
    }

    public static int lineMaxPoints(Point[] points) {
        if (null == points) return 0;
        if (3>points.length) return points.length;

        int max = 0;
        int depeat = 0;
        double scope = 0.0;
        Map<Double, Integer> scopePoints = new HashMap<>();
        for (int i=0; i<points.length; ++i) {
            scopePoints.clear();
            depeat = 0;
            for (int j=i+1; j<points.length; ++j) {
                if ((points[i].x == points[j].x)
                    && (points[i].y == points[j].y)
                ) {
                    depeat++;
                    continue;
                } else if (points[i].x == points[j].x) {
                    scope = Double.MAX_VALUE;
                } else if (points[i].y == points[j].y) {
                    scope = 0.0;
                } else {
                    scope = 1.0 * (points[j].y - points[i].y)/(points[j].x - points[i].x);
                }

                scopePoints.put(scope, scopePoints.containsKey(scope)?(scopePoints.get(scope)+1):1);
            }

            if (0>=scopePoints.size()) {
                max = Math.max(depeat, max);
            } else {
                for (Double scopeKey : scopePoints.keySet()) {
                    max = Math.max(scopePoints.get(scopeKey)+depeat, max);
                }
            }
        }

        return max;
    }
}

