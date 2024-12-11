package learning.java;

import java.io.*;
import java.util.Scanner;

public class CaesarCipherApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть шлях до зашифрованого файлу:");
        String inputFilePath = scanner.nextLine();

        System.out.println("Введіть шлях для збереження розшифрованого файлу:");
        String outputFilePath = scanner.nextLine();

        System.out.println("Введіть ключ для розшифрування:");
        int key = scanner.nextInt();

        CaesarCipher cipher = new CaesarCipher(key);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = cipher.decrypt(line);
                writer.write(decryptedLine);
                writer.newLine();
            }

            System.out.println("Розшифрування завершено. Результат збережено у файл: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Сталася помилка під час обробки файлів: " + e.getMessage());
        }
    }
}
