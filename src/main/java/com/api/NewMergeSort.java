package src.main.java.com.api;
import java.io.*;
import java.util.*;

/*
 * This code was taken from https://www.geeksforgeeks.org/insertion-sort/
 * and modified by Marco Díaz 24229
 */

public class NewMergeSort {
    // Java program for Merge Sort

    // Merges two subarrays of arr[].
    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[]) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        String filePath = "random_numbers.csv";
        int[] arr = readArrayFromCSV(filePath);

        System.out.println("Given Array");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);

        writeArrayToCSV(filePath, arr);
    }

    public static int[] readArrayFromCSV(String filePath) {
        List<Integer> numberList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numberStrings = line.split(",");
                for (String numStr : numberStrings) {
                    numberList.add(Integer.parseInt(numStr.trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberList.stream().mapToInt(i -> i).toArray();
    }

    public static void writeArrayToCSV(String filePath, int[] arr) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < arr.length; i++) {
                bw.write(Integer.toString(arr[i]));
                if (i < arr.length - 1) {
                    bw.write(",");
                }
            }
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
