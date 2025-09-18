import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void testMergeSortCorrectness() {
        int[] array = {5, 2, 9, 1, 5, 6};
        MergeSort.sort(array);
        int[] expected = {1, 2, 5, 5, 6, 9};
        assertArrayEquals(expected, array);
    }
}
