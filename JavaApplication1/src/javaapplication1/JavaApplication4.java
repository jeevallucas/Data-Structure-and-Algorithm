package javaapplication1;

import java.util.Scanner;

public class JavaApplication4 {
    
    public static void main(String[] args) {
        
        int gaji, seratusanRibu, limaPuluhanRibu, duaPuluhanRibu, sePuluhanRibu, limaRibuan, duaRibuan, seRibuan, limaRatusan, seRatusan;
        
        System.out.print("Masukkan gaji yang akan diberikan (gaji): ");
        Scanner scanner = new Scanner(System.in);
        gaji = scanner.nextInt();
        
        seratusanRibu = gaji / 100000;
        gaji = gaji % 100000;
        
        limaPuluhanRibu = gaji / 50000;
        gaji = gaji % 50000;
        
        duaPuluhanRibu = gaji / 20000;
        gaji = gaji % 20000;
        
        sePuluhanRibu = gaji / 10000;
        gaji = gaji % 10000;
        
        limaRibuan = gaji / 5000;
        gaji = gaji % 5000;
        
        duaRibuan = gaji / 2000;
        gaji = gaji % 2000;
        
        seRibuan = gaji / 1000;
        gaji = gaji % 1000;
        
        limaRatusan = gaji / 500;
        gaji = gaji % 500;
        
        seRatusan = gaji / 100;
        gaji = gaji % 100;
        
        System.out.println("");
        
        System.out.println("Seratusan Ribu    : " + seratusanRibu);
        System.out.println("Lima Puluhan Ribu : " + limaPuluhanRibu);
        System.out.println("Dua Puluhan Ribu  : " + duaPuluhanRibu);
        System.out.println("Sepuluhan Ribu    : " + sePuluhanRibu);
        System.out.println("Lima Ribuan       : " + limaRibuan);
        System.out.println("Dua Ribuan        : " + duaRibuan);
        System.out.println("Seribuan          : " + seRibuan);
        System.out.println("Lima Ratusan      : " + limaRatusan);
        System.out.println("Seratusan         : " + seRatusan);
    }
    
}
