import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeterministicSelectTest {

    @Test
    void testSmallArray() {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        for (int k = 0; k < arr.length; k++) {
            int expected = sorted[k];
            int actual = DeterministicSelect.selectKth(arr.clone(), k);
            assertEquals(expected, actual);
        }
    }

    @Test
    void testRandomArrays() {
        Random rand = new Random();
        for (int t = 0; t < 50; t++) {
            int n = rand.nextInt(50) + 1; // от 1 до 50 элементов
            int[] arr = rand.ints(n, -1000, 1000).toArray();
            int[] sorted = arr.clone();
            Arrays.sort(sorted);

            for (int k = 0; k < n; k++) {
                int expected = sorted[k];
                int actual = DeterministicSelect.selectKth(arr.clone(), k);
                assertEquals(expected, actual);
            }
        }
    }

    @Test
    void testAllEqualElements() {
        int[] arr = {7, 7, 7, 7, 7};
        for (int k = 0; k < arr.length; k++) {
            int actual = DeterministicSelect.selectKth(arr.clone(), k);
            assertEquals(7, actual);
        }
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        int actual = DeterministicSelect.selectKth(arr, 0);
        assertEquals(42, actual);
    }
}
