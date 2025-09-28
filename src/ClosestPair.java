import java.util.*;

public class ClosestPair {

    public static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
    }

    private static double dist(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double closestPair(Point[] points) {
        Point[] pointsSortedX = points.clone();
        Arrays.sort(pointsSortedX, Comparator.comparingDouble(p -> p.x));
        Point[] pointsSortedY = points.clone();
        Arrays.sort(pointsSortedY, Comparator.comparingDouble(p -> p.y));

        return closestUtil(pointsSortedX, pointsSortedY);
    }

    private static double closestUtil(Point[] Px, Point[] Py) {
        int n = Px.length;

        if (n <= 3) {
            double minDist = Double.POSITIVE_INFINITY;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    minDist = Math.min(minDist, dist(Px[i], Px[j]));
                }
            }
            return minDist;
        }

        int mid = n / 2;
        Point midPoint = Px[mid];
        double midX = midPoint.x;

        List<Point> leftY = new ArrayList<>();
        List<Point> rightY = new ArrayList<>();
        for (Point p : Py) {
            if (p.x <= midX) leftY.add(p);
            else rightY.add(p);
        }

        double dl = closestUtil(Arrays.copyOfRange(Px, 0, mid), leftY.toArray(new Point[0]));
        double dr = closestUtil(Arrays.copyOfRange(Px, mid, n), rightY.toArray(new Point[0]));

        double d = Math.min(dl, dr);

        List<Point> strip = new ArrayList<>();
        for (Point p : Py) {
            if (Math.abs(p.x - midX) < d) {
                strip.add(p);
            }
        }

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < d; j++) {
                d = Math.min(d, dist(strip.get(i), strip.get(j)));
            }
        }

        return d;
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(2, 3), new Point(12, 30), new Point(40, 50),
                new Point(5, 1), new Point(12, 10), new Point(3, 4)
        };

        double minDist = ClosestPair.closestPair(points);
        System.out.printf("Минимальное расстояние: %.4f\n", minDist);
    }
}
