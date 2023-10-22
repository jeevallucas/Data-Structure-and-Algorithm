package uts_72210512;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTXT {
    private String namaFile;

    public FileTXT(String namaFile) {
        this.namaFile = namaFile;
    }

    public void tulis(String teks) {
        try {
            try (FileWriter fileWriter = new FileWriter(namaFile)) {
                fileWriter.write(teks);
            }
        }
        
        catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public String[] baca() {
        String string = "";
        
        try {
            File file = new File(namaFile);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    string += scanner.nextLine() + "\n";
                }
            }
        }
        
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return string.split("\n");
    }
    
    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }
}
