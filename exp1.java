import java.util.*;

public class exp1 {
    public static String encrypt(String message, int shiftKey) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char charPosition = message.charAt(i);

            if (Character.isLetter(charPosition)) {
                char base = Character.isUpperCase(charPosition) ? 'A' : 'a';
                char encryptedChar = (char) ((charPosition - base + shiftKey) % 26 + base);
                cipherText.append(encryptedChar);
            } else {
                cipherText.append(charPosition);
            }
        }
        return cipherText.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string to encrypt: ");
        String message = sc.nextLine();

        int shiftKey = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter shift key (integer): ");
                shiftKey = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Clear the invalid input
            }
        }

        String encryptedMessage = encrypt(message, shiftKey);
        System.out.println("Encrypted message: " + encryptedMessage);

        sc.close();
    }
}
