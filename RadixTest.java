import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RadixTest {

    @Test
    public void RadixTest() {
        int[] unsortedArray = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expectedSortedArray = {2, 24, 45, 66, 75, 90, 170, 802};

        Radix.radixsort(unsortedArray, unsortedArray.length);

        assertArrayEquals(expectedSortedArray, unsortedArray, "Array ordenado.");
    }
}
