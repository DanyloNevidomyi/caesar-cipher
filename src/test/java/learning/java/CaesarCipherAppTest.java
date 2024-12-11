package learning.java;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherAppTest {
    private Path inputFile;
    private Path outputFile;

    @BeforeEach
    public void setUp() throws IOException {
        inputFile = Files.createTempFile("encrypted", ".txt");
        outputFile = Files.createTempFile("decrypted", ".txt");
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(inputFile);
        Files.deleteIfExists(outputFile);
    }

    @Test
    public void testDecryption() throws IOException {
        String encryptedText = "Wkdw'v Fdhvdu flskhu whvw. L uhdoob krsh wkdw lw zloo zrun !)";
        String expectedDecryptedText = "That's Caesar cipher test. I really hope that it will work !)";
        int key = 3;

        Files.writeString(inputFile, encryptedText, StandardOpenOption.WRITE);

        CaesarCipher cipher = new CaesarCipher(key);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile.toFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile.toFile()))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = cipher.decrypt(line);
                writer.write(decryptedLine);
                writer.newLine();
            }
        }

        String decryptedText = Files.readString(outputFile);
        assertEquals(expectedDecryptedText.trim(), decryptedText.trim(), "Розшифрування не співпадає з очікуваним результатом");
    }

}