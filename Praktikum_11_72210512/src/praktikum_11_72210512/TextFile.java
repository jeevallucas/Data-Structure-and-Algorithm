package praktikum_11_72210512;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFile {

    private String fileName;

    TextFile(String fileName) {
        this.fileName = fileName;
    }

    public void write(String text) throws IOException {
        try {
            try (FileWriter myWriter = new FileWriter(fileName)) {
                myWriter.write(text);
            }
        } catch (IOException e) {
            System.out.println();
        }
    }

    public String[] readLine() {
        String string = "";
        try {
            File myObj = new File(fileName);
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    string += myReader.hasNextLine() + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("");
        }

        return string.split("\n");
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}