package praktikum_05_72210512;

public final class Mahasiswa {
    private String nim, nama, kota;

    public String getNIM() {
        return nim;
    }
    
    public void setNIM(String nim) {
        boolean angka = true;
        
        if(nim.length() > 8) {
            nim = nim.substring(0, 8);
        }
        
        for(int i = 0; i < nim.length(); i++) {
            String baca = nim.substring(i, i + 1);
            
            if(! (baca.compareTo("0") >= 0 && baca.compareTo("9") <= 0)) {
                angka = false;
                break;
            }
            
            if (!angka) {
                nama = "Invalid";
            }

            this.nim = nim;
        }
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        String pertama = nama.substring(0, 1).toUpperCase();
        nama = pertama + nama.substring(1);
        
        this.nama = nama;
    }
    
    public String getKota() {
        return kota;
    }
    
    public void setKota(String kota) {
        kota = kota.toUpperCase();
        this.kota = kota;
    }
    
    public String getMhs() {
        return nim + ", " + nama + ", " + kota + "\n";
    }
    
    public Mahasiswa(String nim, String nama, String kota) {
        setNIM(nim);
        setNama(nama);
        setKota(kota);
    }
}
