import java.math.BigInteger;
import java.util.Scanner;

class exp7 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the 1st prime: ");
        int p = sc.nextInt();
        System.out.print("Enter the 2nd prime: ");
        int q = sc.nextInt();

        int n = p * q;
        int z = (p - 1) * (q - 1);
        System.out.println("The value of z (φ) = " + z);

        int e;
        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("The value of e (public key) = " + e);

        int d = 0;
        for (int i = 0; i < 100; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("The value of d (private key) = " + d);

        System.out.print("Enter the message (number format): ");
        int msg = sc.nextInt();

        double cipherText = Math.pow(msg, e) % n;
        System.out.println("Encrypted message: " + (int) cipherText);

        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigInteger.valueOf((int) cipherText);
        BigInteger msgBack = C.pow(d).mod(N);

        System.out.println("Decrypted message: " + msgBack);
        sc.close();
    }

    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
}
