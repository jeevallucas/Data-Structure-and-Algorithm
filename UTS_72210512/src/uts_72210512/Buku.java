package uts_72210512;

public final class Buku {
    private String nomorKoleksi, judulBuku, pengarang;
    
    public String getNomorKoleksi() {
        return nomorKoleksi;
    }
    
    public void setNomorKoleksi(String nomorKoleksi) {
        boolean angka = true;
        
        if(nomorKoleksi.length() > 3) {
            nomorKoleksi = nomorKoleksi.substring(0, 3);
        }
        
        for(int i = 0; i < nomorKoleksi.length(); i++) {
            String baca = nomorKoleksi.substring(i, i + 1);
            
            if(!(baca.compareTo("0") >= 0 && baca.compareTo("4") <= 0)) {
                angka = false;
                break;
            }
            
            if(!angka) {
                judulBuku = "Invalid";
            }
            
            this.nomorKoleksi = nomorKoleksi;
        }
        
        this.nomorKoleksi = nomorKoleksi;
    }
    
    public String getJudulBuku() {
        return judulBuku;
    }
    
    public void setJudulBuku(String judulBuku) {
        String pertama = judulBuku.substring(0, 1).toUpperCase();
        judulBuku = "'" + pertama + judulBuku.substring(1) + "'";
        
        this.judulBuku = judulBuku;
    }
    
    public String getPengarang() {
        return pengarang;
    }
    
    public void setPengarang(String pengarang) {
        pengarang = "oleh: " + pengarang.toUpperCase();
        
        this.pengarang = pengarang;
    }
    
    public String getBuku() {
        return nomorKoleksi + ", " + judulBuku + ", " + pengarang + "\n";
    }
    
    public Buku(String nomorKoleksi, String judulBuku, String pengarang) {
        setNomorKoleksi(nomorKoleksi);
        setJudulBuku(judulBuku);
        setPengarang(pengarang);
    }
}
