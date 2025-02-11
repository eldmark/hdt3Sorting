import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionTest {

    @Test
    public void testSelectionSort() {
        int[] unsortedArray = {64, 25, 12, 22, 11};
        int[] expectedSortedArray = {11, 12, 22, 25, 64};

        Selection.selectionSort(unsortedArray);

        assertArrayEquals(expectedSortedArray, unsortedArray, "Array ordenado.");
    }
}
