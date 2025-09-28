package org.algoritms.select;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {
    @Test
    void testSelectBasic() {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        DeterministicSelect d = new DeterministicSelect();
        int res = d.select(arr, 3);
        assertEquals(5, res);
        System.out.println(d.getComparisons());
    }
}
