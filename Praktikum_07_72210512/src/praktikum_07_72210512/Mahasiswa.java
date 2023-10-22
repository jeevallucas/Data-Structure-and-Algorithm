package praktikum_07_72210512;

public class Mahasiswa {
    String nim, nama, kota, grup;
    
    public Mahasiswa(String nim, String nama, String kota, String grup) {
        this.nim = nim;
        this.nama = nama;
        this.kota = kota;
        this.grup = grup;
    }

    public String getMhs() {
        return getNim() + ", " + getGrup() + ", " + getNama() + ", " + getKota() + "\n";
    }
    
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
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
}