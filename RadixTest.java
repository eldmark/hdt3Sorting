import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test class for Radix sort algorithm.
 */
public class RadixTest {

    /**
     * Test case for Radix sort with a standard array.
     */
    @Test
    public void testRadixSortStandardArray() {
        int[] unsortedArray = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expectedSortedArray = {2, 24, 45, 66, 75, 90, 170, 802};

        Radix.radixsort(unsortedArray, unsortedArray.length);

        assertArrayEquals(expectedSortedArray, unsortedArray, "Array should be sorted.");
    }

    /**
     * Test case for Radix sort with an already sorted array.
     */
    @Test
    public void testRadixSortAlreadySortedArray() {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 7, 8};

        Radix.radixsort(sortedArray, sortedArray.length);

        assertArrayEquals(expectedSortedArray, sortedArray, "Array should remain sorted.");
    }

    /**
     * Test case for Radix sort with an array sorted in reverse order.
     */
    @Test
    public void testRadixSortReverseSortedArray() {
        int[] reverseSortedArray = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 7, 8};

        Radix.radixsort(reverseSortedArray, reverseSortedArray.length);

        assertArrayEquals(expectedSortedArray, reverseSortedArray, "Array should be sorted.");
    }

    /**
     * Test case for Radix sort with an array containing duplicate elements.
     */
    @Test
    public void testRadixSortArrayWithDuplicates() {
        int[] arrayWithDuplicates = {5, 3, 8, 3, 9, 1, 5, 3};
        int[] expectedSortedArray = {1, 3, 3, 3, 5, 5, 8, 9};

        Radix.radixsort(arrayWithDuplicates, arrayWithDuplicates.length);

        assertArrayEquals(expectedSortedArray, arrayWithDuplicates, "Array should be sorted.");
    }

    /**
     * Test case for Radix sort with an empty array.
     */
    @Test
    public void testRadixSortEmptyArray() {
        int[] emptyArray = {};
        int[] expectedSortedArray = {};

        Radix.radixsort(emptyArray, emptyArray.length);

        assertArrayEquals(expectedSortedArray, emptyArray, "Empty array should remain empty.");
    }
}
