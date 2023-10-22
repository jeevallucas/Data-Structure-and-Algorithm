package tugasprelab5;

public class DaftarNama {
    Nama[] data;
    String proses;
    int cacah;
    
    public DaftarNama(int tampung) {
        this.data = new Nama[tampung];
        this.cacah = 0;
    }
    
    public void tambahNama(String nama) {
        Nama baru = new Nama(nama);
        
        if(this.cacah < this.data.length) {
            this.data[this.cacah++] = baru;
        }
    }
    
    public void hapusNama() {
        if(this.cacah > 0) {
            this.data[--this.cacah] = null;
        }
    }
    
    public String tampilNama() {
        String ambilSemua = "";
        
        for(int i = 0; i < this.cacah; i++) {
            ambilSemua = ambilSemua + this.data[i].getNext();
        }
        
        return ambilSemua;
    }
    
    public void bubbleNama(String order) {
        Nama titip;
        int n = this.cacah;
        int p, b;
        
        if(order.equals("Ascending")) {
            for(p = 1; p < n; p++) {
                for(b = 0; b < n - p; b++) {
                    if(this.data[b].getNama().compareTo(this.data[b + 1].getNama()) > 0) {
                        titip = this.data[b];
                        this.data[b] = this.data[b + 1];
                        this.data[b + 1] = titip;
                }
            }
        }
    }
    
        else {
            for(p = 1; p < n; p++) {
                for(b = 0; b < n - p; b++) {
                    if(this.data[b].getNama().compareTo(this.data[b + 1].getNama()) < 0) {
                        titip = this.data[b];
                        this.data[b] = this.data[b + 1];
                        this.data[b + 1] = titip;
                    }
                }
            }
        }
    }
    
    public String langkahLangkah(String order) {
        this.proses = "Isi array: \n\n";
        
        Nama titip;
        int n = this.cacah;
        int p, b = 0;
        
        if(order.equals("Ascending")) {
            for(p = 1; p < n; p++) {
                for(b = 0; b < n - p; b++) {
                    if(this.data[b].getNama().compareTo(this.data[b + 1].getNama()) > 0) {
                        titip = this.data[b];
                        this.data[b] = this.data[b + 1];
                        this.data[b + 1] = titip;
                    }
                }
            }
        }
    
        else {
            for(p = 1; p < n; p++) {
                for(b = 0; b < n - p; b++) {
                    if(this.data[b].getNama().compareTo(this.data[b + 1].getNama()) < 0) {
                        titip = this.data[b];
                        this.data[b] = this.data[b + 1];
                        this.data[b + 1] = titip;
                    }
                }
            }
        }
        
        return this.proses = this.proses + p + " - " + b + "\n" +  this.tampilNama() + "\n";
    }
}
