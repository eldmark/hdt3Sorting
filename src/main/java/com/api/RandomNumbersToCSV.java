package src.main.java.com.api;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumbersToCSV {
    public static void main(String[] args) {
        String fileName = "random_numbers.csv";
        int numberOfRandomNumbers = 3000;

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
