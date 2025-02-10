package com.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] numbers = {5, 3, 8, 4, 2};
        int[] expected = {2, 3, 4, 5, 8};

        QuickSort.quickSort(numbers, 0, numbers.length - 1);

        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testQuickSortWithNegativeNumbers() {
        int[] numbers = {3, -2, -1, 5, 4};
        int[] expected = {-2, -1, 3, 4, 5};

        QuickSort.quickSort(numbers, 0, numbers.length - 1);

        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testQuickSortWithDuplicates() {
        int[] numbers = {3, 3, 2, 1, 2};
        int[] expected = {1, 2, 2, 3, 3};

        QuickSort.quickSort(numbers, 0, numbers.length - 1);

        assertArrayEquals(expected, numbers);
    }
}
