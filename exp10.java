import java.security.*;
import java.util.Scanner;

public class exp10 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text:");
        String msg = sc.nextLine();
        sc.close();

        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey pv = pair.getPrivate();
        PublicKey pb = pair.getPublic();

        System.out.println("Private Key: " + pv);


        Signature sign = Signature.getInstance("SHA256withDSA");

        sign.initSign(pv);
        sign.update(msg.getBytes());

        byte[] signature = sign.sign();

        System.out.println("Generated Digital Signature:");
        for (byte b : signature) {
            System.out.print(b + " ");
        }
        System.out.println();

        sign.initVerify(pb);
        sign.update(msg.getBytes());
        boolean bool = sign.verify(signature);

        if (bool) {
            System.out.println("Signature verified successfully.");
        } else {
            System.out.println("Signature verification failed.");
        }
    }
}
