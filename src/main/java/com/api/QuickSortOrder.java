package src.main.java.com.api;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
