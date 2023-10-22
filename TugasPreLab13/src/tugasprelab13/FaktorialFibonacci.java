package tugasprelab13;

import java.util.Scanner;

public class FaktorialFibonacci {
    public static int faktorial(int n) {
        if (n > 1) {
            n = n * faktorial(n - 1);
        } else {
            n = 1;
        }

        return n;
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Faktorial dan Fibonacci sampai elemen ke-: ");

        int n = scanner.nextInt();

        System.out.println("\nFaktorial (" + n + ")" + " = " + faktorial(n));
        System.out.println("Fibonacci (" + n + ")" + " = " + fibonacci(n));
    }
}
