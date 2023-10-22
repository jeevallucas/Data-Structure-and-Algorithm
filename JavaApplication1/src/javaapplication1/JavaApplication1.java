package javaapplication1;

import java.util.Scanner;

public class JavaApplication1 {

    public static void main(String[] args) {
        
        int fak = 1, i, n;
        
        System.out.print("Masukkan bilangan yang akan dihitung Faktorialnya (n): ");
        
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        
        System.out.println("");
        
        for(i = 2; i <= n; i++) {
            fak = fak * i;
            System.out.println("Fak " + i + " = " + fak);
        }
    }
}
        
