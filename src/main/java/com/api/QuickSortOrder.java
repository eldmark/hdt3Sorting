package src.main.java.com.api;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The QuickSortOrder class provides a method to read integers from a CSV file,
 * sort them using the QuickSort algorithm, and print the sorted numbers.
 * 
 * <p>This implementation is based on the tutorial from TutosPOO:
 * https://tutospoo.jimdofree.com/tutoriales-java/m%C3%A9todos-de-ordenaci%C3%B3n/ordenaci%C3%B3n-r%C3%A1pida-quicksort/
 * </p>
 * 
 * <p>Usage:</p>
 * <pre>
 * {@code
 * java QuickSortOrder
 * }
 * </pre>
 * 
 * <p>The CSV file should contain one integer per line.</p>
 * 
 * <p>Example CSV file content:</p>
 * <pre>
 * 5
 * 3
 * 8
 * 1
 * 2
 * </pre>
 * 
 * <p>Example output:</p>
 * <pre>
 * 1
 * 2
 * 3
 * 5
 * 8
 * </pre>
 * 
 * <p>Methods:</p>
 * <ul>
 * <li>{@link #main(String[])} - Reads integers from a CSV file, sorts them, and prints the sorted numbers.</li>
 * <li>{@link #quickSort(int[], int, int)} - Sorts an array using the QuickSort algorithm.</li>
 * <li>{@link #partition(int[], int, int)} - Partitions the array for the QuickSort algorithm.</li>
 * </ul>
 * 
 * <p>Exceptions:</p>
 * <ul>
 * <li>{@link IOException} - If an I/O error occurs while reading the CSV file.</li>
 * <li>{@link NumberFormatException} - If the CSV file contains non-integer values.</li>
 * </ul>
 * 
 * @see java.io.BufferedReader
 * @see java.io.FileReader
 * @see java.io.IOException
 * @see java.util.ArrayList
 * @see java.util.List
 */
public class QuickSortOrder {
    public static void main(String[] args) {
        // Nombre del archivo CSV (numeros ordernados)
        String fileName = "numbers.csv";
        List<Integer> numbersList = new ArrayList<>();

        // Leer los números del archivo CSV y guardarlos en una lista
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbersList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            return;
        }

        // Convertir la lista a un arreglo
        int[] numbers = numbersList.stream().mapToInt(i -> i).toArray();

        // Ordenar el arreglo usando QuickSort
        quickSort(numbers, 0, numbers.length - 1);


        // Imprimir los números ordenados
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    // Implementación basada en TutosPOO
    // Fuente: https://tutospoo.jimdofree.com/tutoriales-java/m%C3%A9todos-de-ordenaci%C3%B3n/ordenaci%C3%B3n-r%C3%A1pida-quicksort/
    // Implementación del algoritmo QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
