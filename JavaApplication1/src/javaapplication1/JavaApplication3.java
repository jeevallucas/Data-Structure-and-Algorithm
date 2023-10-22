package javaapplication1;

import java.util.Scanner;

public class JavaApplication3 {
    
    public static void main(String[] args) {
        
        int bil, bagi;
        
        System.out.print("Masukkan bilangan bulat positif (bil): ");
        Scanner scanner = new Scanner(System.in);
        bil = scanner.nextInt();
        
        boolean prima = true;
        
        for(bagi = 2; bagi < bil; bagi++) {
            if(bil % bagi == 0) {
                prima = false;
                break;
            }
            
            bagi = bagi + 1;
        }
        
        System.out.println("");
        
        if(prima == true) {
            System.out.println(bil + " bilangan Prima");
        }
        
        else if(prima == false) {
            System.out.println(bil + " bukan Prima");
        }
        
    }
    
}
