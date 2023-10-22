package tugasprelab8;

public class Mahasiswa {
    String nim, nama, kota, grup;
    
    public Mahasiswa(String nim, String nama, String kota, String grup) {
        this.nim = nim;
        this.nama = nama;
        this.kota = kota;
        this.grup = grup;
    }

    public String getMhs() {
        return nim + ", " + grup + ", " + nama + ", " + kota + "\n";
    }
}