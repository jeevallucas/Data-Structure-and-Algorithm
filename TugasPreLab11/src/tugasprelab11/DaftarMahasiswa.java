package tugasprelab11;

public class DaftarMahasiswa {
    private Mahasiswa[] data;
    private int banyak;
    
    public DaftarMahasiswa(int banyakData) {
        this.data = new Mahasiswa[banyakData];
        this.banyak = 0;
    }

    public void tambahData(String nim, String nama, String kota, String grup) {
        Mahasiswa mhs = new Mahasiswa(nim, nama, kota, grup);
        if (this.banyak < data.length) {
            this.data[this.banyak++] = mhs;
        } else {
            System.out.println("Array sudah penuh");
        }
    }

    public void hapusData() {
        if (this.banyak > 0) {
            this.data[--this.banyak] = null;
        } else {
            System.out.println("Array sudah kosong");
        }
    }

    public String getData() {
        String str = "";
        for (int i = 0; i < this.banyak; i++) {
            str += this.data[i].getMhs();
            System.out.println(str);
        }
        return str;
    }
}
