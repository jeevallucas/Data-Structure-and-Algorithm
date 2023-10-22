package tugasprelab11;

public class Mahasiswa {
    private String NIM, nama, kota, grup;

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    public Mahasiswa(String NIM, String nama, String kota, String grup) {
        this.NIM = NIM;
        this.nama = nama;
        this.kota = kota;
        this.grup = grup;
    }
    
    public String getMhs() {
        return NIM + ", " + nama + ", " + kota + ", " + grup + "\n";
    }
}