package src.main.java.com.api;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * The RandomNumbersToCSV class generates a specified number of random integers
 * and writes them to a CSV file.
 * 
 * <p>This class contains a main method which performs the following steps:
 * <ul>
 *   <li>Defines the name of the CSV file to be created.</li>
 *   <li>Specifies the number of random integers to generate.</li>
 *   <li>Uses a FileWriter to create and write to the CSV file.</li>
 *   <li>Generates random integers using the Random class and writes each integer to the file.</li>
 *   <li>Handles any IOExceptions that may occur during file operations.</li>
 * </ul>
 * </p>
 * 
 * <p>Upon successful execution, a message is printed to the console indicating
 * that the CSV file has been created and the random numbers have been saved.
 * If an error occurs, an error message is printed to the console.</p>
 * 
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * public static void main(String[] args) {
 *     RandomNumbersToCSV.main(args);
 * }
 * }
 * </pre>
 * 
 * @author Alejandro
 * @version 1.0
 */
public class RandomNumbersToCSV {
    public static void main(String[] args) {
        String fileName = "random_numbers.csv";
        int numberOfRandomNumbers = 100;

        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            for (int i = 0; i < numberOfRandomNumbers; i++) {
                int randomNumber = random.nextInt();
                writer.write(randomNumber + "\n");
            }
            System.out.println("Archivo CSV creado y números aleatorios guardados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al crear o escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
