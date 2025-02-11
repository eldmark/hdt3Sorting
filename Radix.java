import java.io.*;
import java.nio.file.*;
import java.util.*;
//Radix sort implementado de geeksforgeeks y cambiado por Adrian 24246
class Radix {

    
    static int getMax(int arr[], int n) {
        int mx = Math.abs(arr[0]);
        for (int i = 1; i < n; i++)
            if (Math.abs(arr[i]) > mx)
                mx = Math.abs(arr[i]);
        return mx;
    }

    
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[19]; 
        Arrays.fill(count, 0);

        
        for (i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10 + 9; 
            count[digit]++;
        }

        
        for (i = 1; i < 19; i++)
            count[i] += count[i - 1];

       
        for (i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10 + 9;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        
        System.arraycopy(output, 0, arr, 0, n);
    }

    
    static void radixsort(int arr[], int n) {
        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            
            List<String> lines = Files.readAllLines(Paths.get("hdt3Sorting/random_numbers.csv"));
            List<Integer> numbers = new ArrayList<>();

            //Método raddix no acepta negativos, entonces agregué excepciones y advertencias si encontraba un número no permitivo 

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

            
            int[] arr = numbers.stream().mapToInt(i -> i).toArray();
            int n = arr.length;

            if (n > 0) {
                
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
