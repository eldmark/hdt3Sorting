package src.main.java.com.api;
import java.io.*;
import java.util.*;

/*
 * This code was taken from https://www.geeksforgeeks.org/insertion-sort/
 * and modified by Marco Díaz 24229
 */

/**
 * The NewMergeSort class provides methods to perform the Merge Sort algorithm
 * on an array of integers. It also includes methods to read an array from a CSV
 * file and write a sorted array back to a CSV file.
 */
public class NewMergeSort {

    /**
     * Merges two subarrays of arr[].
     * First subarray is arr[l..m]
     * Second subarray is arr[m+1..r]
     *
     * @param arr the array to be sorted
     * @param l the starting index of the first subarray
     * @param m the ending index of the first subarray
     * @param r the ending index of the second subarray
     */
    static void merge(int arr[], int l, int m, int r) {
        // Implementation here
    }

    /**
     * Sorts the array using the Merge Sort algorithm.
     *
     * @param arr the array to be sorted
     * @param l the starting index of the array
     * @param r the ending index of the array
     */
    public static void sort(int arr[], int l, int r) {
        // Implementation here
    }

    /**
     * Prints the elements of the array.
     *
     * @param arr the array to be printed
     */
    static void printArray(int arr[]) {
        // Implementation here
    }

    /**
     * The main method to execute the Merge Sort algorithm.
     * Reads an array from a CSV file, sorts it, and writes the sorted array back to the CSV file.
     *
     * @param args command line arguments
     */
    public static void main(String args[]) {
        // Implementation here
    }

    /**
     * Reads an array of integers from a CSV file.
     *
     * @param filePath the path to the CSV file
     * @return an array of integers read from the CSV file
     */
    public static int[] readArrayFromCSV(String filePath) {
        // Implementation here
    }

    /**
     * Writes an array of integers to a CSV file.
     *
     * @param filePath the path to the CSV file
     * @param arr the array of integers to be written to the CSV file
     */
    public static void writeArrayToCSV(String filePath, int[] arr) {
        // Implementation here
    }
}
