import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    @Test
    void testSmallArray() {
        int[] arr = {9, 3, 7, 1, 5, 4};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        QuickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] expected = arr.clone();

        QuickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testAllEqualElements() {
        int[] arr = {7, 7, 7, 7, 7};
        int[] expected = arr.clone();

        QuickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testRandomArrays() {
        Random rand = new Random();
        for (int t = 0; t < 50; t++) {
            int[] arr = rand.ints(100, -1000, 1000).toArray();
            int[] expected = arr.clone();
            Arrays.sort(expected);

            QuickSort.sort(arr);

            assertArrayEquals(expected, arr);
        }
    }
}
