import java.io.*;
import java.util.*;

// Selection sort implementado de geeksforgeeks cambiado por Adrian 24146
/**
 * The Selection class provides methods to read a CSV file containing integers,
 * sort them using the selection sort algorithm, and print the sorted array.
 */
public class Selection {
    public static void main(String[] args) {
        String fileName = "hdt3Sorting/random_numbers.csv";
        List<Integer> numbers = readCSV(fileName);

        if (numbers.isEmpty()) {
            System.out.println("No se encontraron números válidos en el archivo.");
            return;
        }

        int[] arr = numbers.stream().mapToInt(i -> i).toArray();
        selectionSort(arr);
        printArray(arr);
    }

    public static List<Integer> readCSV(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        File file = new File(fileName);
            //Prompt: 
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String num : line.split(",")) {
                    try {
                        numbers.add(Integer.parseInt(num.trim()));
                    } catch (NumberFormatException ignored) {
                        
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

        return numbers;
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
