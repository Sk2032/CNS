import java.util.Scanner;
import java.math.BigInteger;

class exp6 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the prime number (P): ");
        int P = sc.nextInt();
        System.out.print("Enter the primitive root (G): ");
        int G = sc.nextInt();

        System.out.print("Enter private key of User A (x): ");
        int x = sc.nextInt();
        System.out.print("Enter private key of User B (y): ");
        int y = sc.nextInt();

        BigInteger XS = BigInteger.valueOf(G).modPow(BigInteger.valueOf(x), BigInteger.valueOf(P));
        BigInteger YS = BigInteger.valueOf(G).modPow(BigInteger.valueOf(y), BigInteger.valueOf(P));

        BigInteger XC = YS.modPow(BigInteger.valueOf(x), BigInteger.valueOf(P));
        BigInteger YC = XS.modPow(BigInteger.valueOf(y), BigInteger.valueOf(P));
        System.out.println("\nSimulation of Diffie-Hellman Key Exchange:");
        System.out.println("User A sends: " + XS);
        System.out.println("User B sends: " + YS);
        System.out.println("User A computes: " + XC);
        System.out.println("User B computes: " + YC);
        System.out.println("Shared Secret Key: " + XC);

        if (XC.equals(YC)) {
            System.out.println("Success: Secure Key Exchange Completed.");
        } else {
            System.out.println("Error: Key Exchange Failed.");
        }

        sc.close();
    }
}
