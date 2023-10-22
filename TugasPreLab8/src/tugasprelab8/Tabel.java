package tugasprelab8;

import java.io.IOException;

public class Tabel {
    private final Mahasiswa[] dafMhs;
    private int cacah;
    private int pilihElemen;
    FileTeks file;
    
    public Tabel(int bykElemen) {
        dafMhs = new Mahasiswa[bykElemen];
        cacah = 0;
        pilihElemen = -1;
        this.file = new FileTeks("src/tugasprelab8/Data Mahasiswa.csv");
    }
    
    public void tambahMhs(Mahasiswa mhs) {
        if(cacah < dafMhs.length) {
            String nim, grup;
            
            if(cacah == 0)
                nim = "72210001";
            else
                nim = String.valueOf(Integer.parseInt(dafMhs[cacah - 1].nim) + 1);
            
            if(Integer.parseInt(nim) % 2 == 1)
                grup = "A";
            else
                grup = "B";
            
            mhs.nim = nim;
            mhs.grup = grup;
            
            pilihElemen = cacah;
            dafMhs[cacah++] = mhs;
        }
        
        else {
            System.out.println("");
        }
    }
    
    public Mahasiswa bacaMhs() {
        if(pilihElemen >= 0 && pilihElemen < cacah)
            return this.dafMhs[pilihElemen];
        else
            return new Mahasiswa("", "", "", "");
    }
    
    public void ubahMhs(Mahasiswa mhs) {
        dafMhs[pilihElemen] = mhs;
    }
    
    public void hapusMhs() {
        if(cacah > 0) {
            for(int idx = pilihElemen; idx < cacah; idx++)
                dafMhs[idx] = dafMhs[idx + 1];
            
            cacah--;
            
            if(cacah > 0)
                pilihElemen = 0;
            else
                pilihElemen = -1;
        }
        
        else {
            System.out.println("");
        }
    }
    
    public void moveFirst() {
        pilihElemen = 0;
    }
    
    public void movePrevious() {
        if(pilihElemen > 0)
            pilihElemen--;
        else
            System.out.println("");
    }
    
    public void moveNext() {
        if(pilihElemen < cacah - 1)
            pilihElemen++;
        else
            System.out.println("");
    }
    
    public void moveLast() {
        pilihElemen = cacah - 1;
    }
    
    public String getAll() {
        String getMhs = "";
        
        for(int i = 0; i < this.cacah; i++)
            getMhs += (i + 1) + ". " + this.dafMhs[i].getMhs() + "\n";
        
        System.out.println("");
        return getMhs;
    }
    
    public void saveToFile() throws IOException {
        this.file.tulis(String.valueOf(this.getAll()));
    }
}