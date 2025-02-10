package src.main.java.com.api;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class NewInsertionSortTest {

    @Test
    public void testInsertionSortWithPositiveNumbers() {
        int[] array = {5, 2, 9, 1, 5, 6};
        int[] sortedArray = {1, 2, 5, 5, 6, 9};
        NewInsertionSort.insertionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testInsertionSortWithNegativeNumbers() {
        int[] array = {-3, -1, -2, -5, -4};
        int[] sortedArray = {-5, -4, -3, -2, -1};
        NewInsertionSort.insertionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testInsertionSortWithMixedNumbers() {
        int[] array = {3, -1, 2, -5, 4};
        int[] sortedArray = {-5, -1, 2, 3, 4};
        NewInsertionSort.insertionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testInsertionSortWithDuplicates() {
        int[] array = {3, 3, 2, 1, 2};
        int[] sortedArray = {1, 2, 2, 3, 3};
        NewInsertionSort.insertionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testInsertionSortWithSingleElement() {
        int[] array = {1};
        int[] sortedArray = {1};
        NewInsertionSort.insertionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testInsertionSortWithEmptyArray() {
        int[] array = {};
        int[] sortedArray = {};
        NewInsertionSort.insertionSort(array);
        assertArrayEquals(sortedArray, array);
    }
}