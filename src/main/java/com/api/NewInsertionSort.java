package src.main.java.com.api;
import java.io.*;
import java.util.*;

/*
 * This code was taken from https://www.geeksforgeeks.org/insertion-sort/
 * and modified by Marco Díaz 24229
 */

// Java program for implementation of Insertion Sort
public class NewInsertionSort {
    /* Function to sort array using insertion sort */
    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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

        sort(arr);

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
