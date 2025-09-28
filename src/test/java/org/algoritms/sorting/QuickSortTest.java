package org.algoritms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    void testQuickSortBasic() {
        int[] arr = {15, 7, 8, 9, 1, 3, 4, 5};
        QuickSort q = new QuickSort();
        q.sort(arr);
        assertArrayEquals(new int[]{1, 3, 4, 5, 7, 8, 9, 15}, arr);
        System.out.println(q.getComparisons());
    }
}
