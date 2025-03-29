import java.io.*;
import java.util.*;

public class exp3 {
    public static char normalChars[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static char codedChars[] = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    public static String Encryption(String s) {
        String encryptedString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == normalChars[j]) {
                    encryptedString += codedChars[j];
                    break;
                }
            }
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                encryptedString += s.charAt(i);
            }
        }
        return encryptedString;
    }

    public static String Decryption(String s) {
        String decryptedString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == codedChars[j]) {
                    decryptedString += normalChars[j];
                    break;
                }
            }
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                decryptedString += s.charAt(i);
            }
        }
        return decryptedString;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plain text: ");
        String str = sc.nextLine();
        System.out.println("Plain text: " + str);

        String encryptedString = Encryption(str.toUpperCase());
        System.out.println("Encrypted message: " + encryptedString);

        String decryptedString = Decryption(encryptedString);
        System.out.println("Decrypted message: " + decryptedString);

        sc.close();
    }
}
