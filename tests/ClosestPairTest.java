import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClosestPairTest {

    private double bruteForce(ClosestPair.Point[] points) {
        double minDist = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dx = points[i].x - points[j].x;
                double dy = points[i].y - points[j].y;
                double dist = Math.sqrt(dx * dx + dy * dy);
                minDist = Math.min(minDist, dist);
            }
        }
        return minDist;
    }

    @Test
    void testSmallExample() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(2, 3),
                new ClosestPair.Point(12, 30),
                new ClosestPair.Point(40, 50),
                new ClosestPair.Point(5, 1),
                new ClosestPair.Point(12, 10),
                new ClosestPair.Point(3, 4)
        };

        double expected = bruteForce(points);
        double actual = ClosestPair.closestPair(points);

        assertEquals(expected, actual, 1e-9);
    }

    @Test
    void testRandomSmall() {
        Random rand = new Random();
        for (int t = 0; t < 20; t++) {
            int n = 20;
            ClosestPair.Point[] points = new ClosestPair.Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new ClosestPair.Point(rand.nextInt(1000), rand.nextInt(1000));
            }

            double expected = bruteForce(points);
            double actual = ClosestPair.closestPair(points);

            assertEquals(expected, actual, 1e-9);
        }
    }

    @Test
    void testRandomLarge() {
        Random rand = new Random();
        int n = 10000; // большое n, O(n^2) нельзя
        ClosestPair.Point[] points = new ClosestPair.Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new ClosestPair.Point(rand.nextDouble() * 1e6, rand.nextDouble() * 1e6);
        }

        double actual = ClosestPair.closestPair(points);

        assert(actual >= 0);
    }
}
