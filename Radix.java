import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Radix sort implementation adapted by Adrian 24246.
 */
class Radix {

    /**
     * Gets the maximum absolute value in the array.
     *
     * @param arr the array of integers
     * @param n   the number of elements in the array
     * @return the maximum absolute value
     */
    static int getMax(int arr[], int n) {
        int mx = Math.abs(arr[0]);
        for (int i = 1; i < n; i++)
            if (Math.abs(arr[i]) > mx)
                mx = Math.abs(arr[i]);
        return mx;
    }

    /**
     * A function to do counting sort of arr[] according to the digit represented by exp.
     *
     * @param arr the array of integers
     * @param n   the number of elements in the array
     * @param exp the exponent representing the digit position
     */
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[19]; // 19 to handle digits from -9 to 9
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10 + 9; // Shift digit range from -9-9 to 0-18
            count[digit]++;
        }

        // Change count[i] so that count[i] now contains actual position of this digit in output[]
        for (i = 1; i < 19; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10 + 9;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to current digit
        System.arraycopy(output, 0, arr, 0, n);
    }

    /**
     * The main function to that sorts arr[] of size n using Radix Sort.
     *
     * @param arr the array of integers
     * @param n   the number of elements in the array
     */
    static void radixsort(int arr[], int n) {
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead of passing digit number, exp is passed. exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    /**
     * A utility function to print an array.
     *
     * @param arr the array of integers
     * @param n   the number of elements in the array
     */
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /**
     * The main method to read the input file, sort the numbers using Radix Sort, and print the sorted numbers.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Read all lines from the input file
            List<String> lines = Files.readAllLines(Paths.get("hdt3Sorting/random_numbers.csv"));
            List<Integer> numbers = new ArrayList<>();

            // Parse the numbers from the file and add to the list
            for (String line : lines) {
                String[] values = line.split(",");
                for (String value : values) {
                    try {
                        numbers.add(Integer.parseInt(value.trim()));
                    } catch (NumberFormatException e) {
                        System.err.println("Valor inválido ignorado: " + value);
                    }
                }
            }

            // Convert the list to an array
            int[] arr = numbers.stream().mapToInt(i -> i).toArray();
            int n = arr.length;

            if (n > 0) {
                // Sort the array using Radix Sort and print the sorted array
                radixsort(arr, n);
                print(arr, n);
            } else {
                System.err.println("Error");
            }

        } catch (IOException e) {
            System.err.println("Error con el archivo " + e.getMessage());
        }
    }
}
