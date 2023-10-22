package praktikum_13_72210512;

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

    public void tulis(String teks) {
        try {
            FileWriter myWriter = new FileWriter(namaFile);
            myWriter.write(teks);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Terdapat Error");
            e.printStackTrace();
        }
    }

    public String[] baca() {
        String s = "";
        try {
            File myObj = new File(namaFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                s += myReader.nextLine() + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error Occured");
            e.printStackTrace();
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