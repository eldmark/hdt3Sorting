import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * The SelectionTest class provides unit tests for the selectionSort method
 * in the Selection class.
 */
public class SelectionTest {

    /**
     * Tests the selectionSort method with an unsorted array.
     */
    @Test
    public void testSelectionSort() {
        int[] unsortedArray = {64, 25, 12, 22, 11};
        int[] expectedSortedArray = {11, 12, 22, 25, 64};

        Selection.selectionSort(unsortedArray);

        assertArrayEquals(expectedSortedArray, unsortedArray, "Array should be sorted.");
    }

    /**
     * Tests the selectionSort method with an already sorted array.
     */
    @Test
    public void testSelectionSortAlreadySorted() {
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] expectedSortedArray = {1, 2, 3, 4, 5};

        Selection.selectionSort(sortedArray);

        assertArrayEquals(expectedSortedArray, sortedArray, "Array should remain sorted.");
    }

    /**
     * Tests the selectionSort method with an array containing duplicate elements.
     */
    @Test
    public void testSelectionSortWithDuplicates() {
        int[] arrayWithDuplicates = {4, 5, 3, 4, 1, 2, 2};
        int[] expectedSortedArray = {1, 2, 2, 3, 4, 4, 5};

        Selection.selectionSort(arrayWithDuplicates);

        assertArrayEquals(expectedSortedArray, arrayWithDuplicates, "Array should be sorted with duplicates.");
    }

    /**
     * Tests the selectionSort method with an array containing negative numbers.
     */
    @Test
    public void testSelectionSortWithNegativeNumbers() {
        int[] arrayWithNegatives = {-3, -1, -2, 0, 2, 1};
        int[] expectedSortedArray = {-3, -2, -1, 0, 1, 2};

        Selection.selectionSort(arrayWithNegatives);

        assertArrayEquals(expectedSortedArray, arrayWithNegatives, "Array should be sorted with negative numbers.");
    }

    /**
     * Tests the selectionSort method with an empty array.
     */
    @Test
    public void testSelectionSortEmptyArray() {
        int[] emptyArray = {};
        int[] expectedSortedArray = {};

        Selection.selectionSort(emptyArray);

        assertArrayEquals(expectedSortedArray, emptyArray, "Empty array should remain empty.");
    }

    /**
     * Tests the selectionSort method with an array containing a single element.
     */
    @Test
    public void testSelectionSortSingleElement() {
        int[] singleElementArray = {42};
        int[] expectedSortedArray = {42};

        Selection.selectionSort(singleElementArray);

        assertArrayEquals(expectedSortedArray, singleElementArray, "Single element array should remain unchanged.");
    }
}
