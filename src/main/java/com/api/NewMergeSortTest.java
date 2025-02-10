package src.main.java.com.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NewMergeSortTest {



        @Test
        public void testMergeSortWithPositiveNumbers() {
            int[] arr = {12, 11, 13, 5, 6, 7};
            NewMergeSort.sort(arr, 0, arr.length - 1);
            int[] expected = {5, 6, 7, 11, 12, 13};
            assertArrayEquals(expected, arr);
        }

        @Test
        public void testMergeSortWithNegativeNumbers() {
            int[] arr = {-12, -11, -13, -5, -6, -7};
            NewMergeSort.sort(arr, 0, arr.length - 1);
            int[] expected = {-13, -12, -11, -7, -6, -5};
            assertArrayEquals(expected, arr);
        }

        @Test
        public void testMergeSortWithMixedNumbers() {
            int[] arr = {12, -11, 13, -5, 6, -7};
            NewMergeSort.sort(arr, 0, arr.length - 1);
            int[] expected = {-11, -7, -5, 6, 12, 13};
            assertArrayEquals(expected, arr);
        }

        @Test
        public void testMergeSortWithSingleElement() {
            int[] arr = {1};
            NewMergeSort.sort(arr, 0, arr.length - 1);
            int[] expected = {1};
            assertArrayEquals(expected, arr);
        }

        @Test
        public void testMergeSortWithEmptyArray() {
            int[] arr = {};
            NewMergeSort.sort(arr, 0, arr.length - 1);
            int[] expected = {};
            assertArrayEquals(expected, arr);
        }
    }

