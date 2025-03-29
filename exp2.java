import java.util.*;

public class exp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String text = sc.nextLine();

        String key = RandomAlpha(text.length());
        String enc = OTPEncryption(text, key);

        System.out.println("Plaintext: " + text);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + OTPDecryption(enc, key));
    }

    static String RandomAlpha(int len) {
        Random rand = new Random();
        StringBuilder key = new StringBuilder();
        
        for (int x = 0; x < len; x++) {
            key.append((char) ('A' + rand.nextInt(26)));
        }
        return key.toString();
    }

    static String OTPEncryption(String text, String key) {
        return processOTP(text, key, true);
    }

    static String OTPDecryption(String text, String key) {
        return processOTP(text, key, false);
    }

    static String processOTP(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();

        for (int x = 0; x < text.length(); x++) {
            char get = text.charAt(x);
            char keyget = key.charAt(x);
            
            if (Character.isLetter(get)) {
                char base = Character.isUpperCase(get) ? 'A' : 'a';
                int offset = Character.toLowerCase(keyget) - 'a';

                if (!encrypt) {
                    offset = -offset;
                }

                char newChar = (char) (base + (get - base + offset + 26) % 26);
                result.append(newChar);
            } else {
                result.append(get);
            }
        }
        return result.toString();
    }
}
