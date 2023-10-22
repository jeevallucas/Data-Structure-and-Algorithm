package uts_72210512;

public final class DaftarBuku {
    private final Buku[] data;
    private int cacah;
    private final FileTXT file;
    
    public DaftarBuku(int banyak) {
        this.data = new Buku[banyak];
        this.cacah = 0;
        this.file = new FileTXT("src/uts_72210512/Data Buku.txt");
        isiBuku();
    }
    
    public void tambahBuku(String nomorKoleksi, String judulBuku, String pengarang) {
        Buku buku = new Buku(nomorKoleksi, judulBuku, pengarang);
        this.data[this.cacah++] = buku;
    }
    
    public void hapusBuku() {
        this.data[--this.cacah] = null;
    }
    
    public String getAllBuku() {
        String s = "";
        
        for(int i = 0; i < this.cacah; i++) {
            s = s + this.data[i].getBuku();
        }
        
        return s;
    }
    
    public void bubbleNomorKoleksi(String order) {
        if (order.equals("Ascending")) {
            int p, b;
            Buku titip;

            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < this.cacah - p; b++) {
                    if (data[b].getNomorKoleksi().compareTo(data[b + 1].getNomorKoleksi()) > 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        } else {
            int p, b;
            Buku titip;

            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < this.cacah - p; b++) {
                    if (data[b].getNomorKoleksi().compareTo(data[b + 1].getNomorKoleksi()) < 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
    }
    
    public void bubbleJudulBuku(String order) {
        if (order.equals("Ascending")) {
            int p, b;
            Buku titip;

            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < this.cacah - p; b++) {
                    if (data[b].getJudulBuku().compareTo(data[b + 1].getJudulBuku()) > 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        } else {
            int p, b;
            Buku titip;

            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < this.cacah - p; b++) {
                    if (data[b].getJudulBuku().compareTo(data[b + 1].getJudulBuku()) < 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
    }
    
    public void bubblePengarang(String order) {
        if(order.equals("Ascending")) {
            int p, b;
            Buku titip;
            
            for(p = 1; p < this.cacah; p++) {
                for(b = 0; b < this.cacah - p; b++) {
                    if(data[b].getPengarang().compareTo(data[b + 1].getPengarang()) > 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
        
        else {
            int p, b;
            Buku titip;
            
            for(p = 1; p < this.cacah; p++) {
                for(b = 0; b < this.cacah - p; b++) {
                    if(data[b].getPengarang().compareTo(data[b + 1].getPengarang()) < 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
    }
    
    public void isiBuku() {
        String[] arrayTXT = this.file.baca(), deret;
        String bukuNomorKoleksi, bukuJudulBuku, bukuPengarang;
        
        for(int i = 0; i < arrayTXT.length; i++) {
            deret = arrayTXT[i].split(", ");
            
            bukuNomorKoleksi = deret[0];
            bukuJudulBuku = deret[1];
            bukuPengarang = deret[2];
            
            this.tambahBuku(bukuNomorKoleksi, bukuJudulBuku, bukuPengarang);
        }
    }
    
    public void saveFile() {
        this.file.tulis(this.getAllBuku());
    }
}
