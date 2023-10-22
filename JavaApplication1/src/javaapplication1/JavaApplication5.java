package javaapplication1;

import java.util.Scanner;

public class JavaApplication5 {
    
    public static void main(String[] args) {
        
        double usd, sgd, aud, rp;
        double rp_to_usd, rp_to_sgd, rp_to_aud;
        
        System.out.print("Berapa Rupiah harga per 1 USD (usd): ");
        Scanner scannerUSD = new Scanner(System.in);
        usd = scannerUSD.nextInt();
        
        System.out.print("Berapa Rupiah harga per 1 SGD (sgd): ");
        Scanner scannerSGD = new Scanner(System.in);
        sgd = scannerSGD.nextInt();
        
        System.out.print("Berapa Rupiah harga per 1 AUD (aud): ");
        Scanner scannerAUD = new Scanner(System.in);
        aud = scannerAUD.nextInt();
        
        System.out.println("");
        
        System.out.print("Berapa Rupiah uang yang akan dikonversikan (rp): ");
        Scanner scannerRP = new Scanner(System.in);
        rp = scannerRP.nextInt();
        
        rp_to_usd = rp / usd;
        rp_to_sgd = rp / sgd;
        rp_to_aud = rp /aud;
        
        System.out.println("");
        
        System.out.printf("Rp %.0f setara dengan USD $ %.2f", rp, rp_to_usd);
        System.out.println("");
        
        System.out.printf("Rp %.0f setara dengan SGD $ %.2f", rp, rp_to_sgd);
        System.out.println("");
        
        System.out.printf("Rp %.0f setara dengan AUD $ %.2f", rp, rp_to_aud);
    }
    
}
