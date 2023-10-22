package javaapplication1;

import java.util.Scanner;

public class JavaApplication2 {
    
    public static void main(String[] args) {
        
        int n, i, fib3;
        
        System.out.print("Ingin mencetak deret Fibonacci hingga elemen ke berapa (n): ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        
        int fib0 = 0;
        int fib1 = 1;
        
        System.out.println("");
        
        System.out.println("fib0 = " + fib0);
        System.out.println("fib1 = " + fib1);
        
        for(i = 2; i <= n; i++) {
            fib3 = fib0 + fib1;
            
            System.out.println("fib" + i + " = " + fib3);
            
            fib0 = fib1;
            fib1 = fib3;
        }
        
        i = i + 1;
    }
    
}
