package org.algoritms.geometry;

import java.util.*;

public class ClosestPair {
    public static class Point {
        public double x, y;
        public Point(double a, double b) { x = a; y = b; }
    }

    private double d(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double closest(Point[] pts) {
        Point[] xs = pts.clone();
        Arrays.sort(xs, (a, b) -> (int)Math.signum(a.x - b.x));
        Point[] ys = pts.clone();
        Arrays.sort(ys, (a, b) -> (int)Math.signum(a.y - b.y));
        return go(xs, ys);
    }

    private double go(Point[] xs, Point[] ys) {
        int n = xs.length;
        if (n < 4) {
            double m = Double.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double cur = d(xs[i], xs[j]);
                    if (cur < m) m = cur;
                }
            }
            return m;
        }
        int mid = n / 2;
        Point midp = xs[mid];
        Point[] Lx = Arrays.copyOfRange(xs, 0, mid);
        Point[] Rx = Arrays.copyOfRange(xs, mid, n);
        ArrayList<Point> Ly = new ArrayList<>(), Ry = new ArrayList<>();
        for (Point p : ys) {
            if (p.x <= midp.x) Ly.add(p); else Ry.add(p);
        }
        double left = go(Lx, Ly.toArray(new Point[0]));
        double right = go(Rx, Ry.toArray(new Point[0]));
        double best = Math.min(left, right);
        ArrayList<Point> strip = new ArrayList<>();
        for (Point p : ys) if (Math.abs(p.x - midp.x) < best) strip.add(p);
        return Math.min(best, stripCalc(strip, best));
    }

    private double stripCalc(ArrayList<Point> arr, double lim) {
        double res = lim;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).y - arr.get(i).y >= res) break;
                double cur = d(arr.get(i), arr.get(j));
                if (cur < res) res = cur;
            }
        }
        return res;
    }
}
