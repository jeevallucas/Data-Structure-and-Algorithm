package tugasprelab5;

public class Nama {
    String nama;
    
    public Nama(String nama) {
        setNama(nama);
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        String p = nama.substring(0, 1).toUpperCase();
        nama = p + nama.substring(1);
        this.nama = nama;
    }
    
    public String getNext() {
        return nama + "\n";
    }
}
