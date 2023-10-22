package praktikum_05_72210512;

public final class DaftarMahasiswa {
    private final Mahasiswa[] data;
    private int cacah;
    private final FileTXT file;
    
    public DaftarMahasiswa(int banyak) {
        this.data = new Mahasiswa[banyak];
        this.cacah = 0;
        this.file = new FileTXT("src/praktikum_05_72210512/Data.txt");
        isiMahasiswa();
    }
    
    public void tambahMahasiswa(String nim, String nama, String kota) {
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, kota);
        this.data[this.cacah++] = mahasiswa;
    }
    
    public void hapusMahasiswa() {
        this.data[--this.cacah] = null;
    }
    
    public String getAllMahasiswa() {
        String s = "";
        
        for(int i = 0; i < this.cacah; i++) {
            s = s + this.data[i].getMhs();
        }
        
        return s;
    }
    
    public void bubbleNIM(String order) {
        if(order.equals("Ascending")) {
            int p, b;
            Mahasiswa titip;
            
            for(p = 1; p < this.cacah; p++) {
                for(b = 0; b < this.cacah - p; b++) {
                    if(data[b].getNIM().compareTo(data[b + 1].getNIM()) > 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
        
        else {
            int p, b;
            Mahasiswa titip;
            
            for(p = 1; p < this.cacah; p++) {
                for(b = 0; b < this.cacah - p; b++) {
                    if(data[b].getNIM().compareTo(data[b + 1].getNIM()) < 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
    }
    
    public void bubbleNama(String order) {
        if(order.equals("Ascending")) {
            int p, b;
            Mahasiswa titip;
            
            for(p = 1; p < this.cacah; p++) {
                for(b = 0; b < this.cacah - p; b++) {
                    if(data[b].getNama().compareTo(data[b + 1].getNama()) > 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
        
        else {
            int p, b;
            Mahasiswa titip;
            
            for(p = 1; p < this.cacah; p++) {
                for(b = 0; b < this.cacah - p; b++) {
                    if(data[b].getNama().compareTo(data[b + 1].getNama()) < 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
    }
    
    public void bubbleKota(String order) {
        if(order.equals("Ascending")) {
            int p, b;
            Mahasiswa titip;
            
            for(p = 1; p < this.cacah; p++) {
                for(b = 0; b < this.cacah - p; b++) {
                    if(data[b].getKota().compareTo(data[b + 1].getKota()) > 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
        
        else {
            int p, b;
            Mahasiswa titip;
            
            for(p = 1; p < this.cacah; p++) {
                for(b = 0; b < this.cacah - p; b++) {
                    if(data[b].getKota().compareTo(data[b + 1].getKota()) < 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
    }
    
    public void isiMahasiswa() {
        String[] arrayTXT = this.file.baca(), deret;
        String nimMahasiswa, namaMahasiswa, kotaMahasiswa;
        
        for(int i = 0; i < arrayTXT.length; i++) {
            deret = arrayTXT[i].split(", ");
            
            nimMahasiswa = deret[0];
            namaMahasiswa = deret[1];
            kotaMahasiswa = deret[2];
            
            this.tambahMahasiswa(nimMahasiswa, namaMahasiswa, kotaMahasiswa);
        }
    }
    
    public void saveFile() {
        this.file.tulis(this.getAllMahasiswa());
    }
}
