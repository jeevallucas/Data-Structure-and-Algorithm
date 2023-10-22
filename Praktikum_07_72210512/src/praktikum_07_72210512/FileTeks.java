package praktikum_07_72210512;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTeks {
    private String namaFile;
    
    public FileTeks(String namaFile) {
        this.namaFile = namaFile;
    }
    
    public void tulis(String teks) throws IOException {
        try {
            try (FileWriter myWriter = new FileWriter(namaFile)) {
                myWriter.write(teks);
            }
        }
        
        catch(IOException e) {
            System.out.println("");
        }
    }
    
    public String[] baca() {
        String s = "";
        
        try {
            File myObj = new File(namaFile);
            try (Scanner myReader = new Scanner(myObj)) {
                while(myReader.hasNextLine()) {
                    s += myReader.hasNextLine() + "\n";
                }
            }
        }
        
        catch(FileNotFoundException e) {
            System.out.println("");
        }
        
        return s.split("\n");
    }
    
    public String getNamaFile() {
        return namaFile;
    }
    
    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }
}