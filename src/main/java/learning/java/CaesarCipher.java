package learning.java;

public class CaesarCipher {
    private final int key;

    public CaesarCipher(int key) {
        this.key = key;
    }

    public String decrypt(String text) {
        StringBuilder decryptedText = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                // Зсув назад для розшифрування
                c = (char) ((c - base - key + 26) % 26 + base);
            }
            decryptedText.append(c);
        }

        return decryptedText.toString();
    }
}
