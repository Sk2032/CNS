import java.security.*;
import javax.crypto.*;
import java.util.*;

class exp4 {
    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Message Encryption using DES Algorithm:");

            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keyGenerator.generateKey();

            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            System.out.print("Enter the string to be encrypted: ");
            String input = sc.nextLine();
            byte[] text = input.getBytes();
            System.out.println("Message (byte format): " + text);
            System.out.println("Message: " + new String(text));

            byte[] textEncrypted = desCipher.doFinal(text);
            System.out.println("Encrypted message: " + Base64.getEncoder().encodeToString(textEncrypted));


            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);

            System.out.println("Decrypted message: " + new String(textDecrypted));
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } 
        catch (InvalidKeyException e) {
            e.printStackTrace();
        } 
        catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } 
        catch (BadPaddingException e) {
            e.printStackTrace();
        }
    }
}
