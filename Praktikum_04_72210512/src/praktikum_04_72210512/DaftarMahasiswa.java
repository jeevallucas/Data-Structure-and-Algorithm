package praktikum_04_72210512;

public class DaftarMahasiswa {

    private final Mahasiswa[] data;
    private int cacah;

    public DaftarMahasiswa(int banyak) {
        this.data = new Mahasiswa[banyak];
        this.cacah = 0;
    }

    public void tambahMahasiswa(String nim, String nama, String kota) {
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, kota);

        if (this.cacah < this.data.length) {
            this.data[this.cacah++] = mahasiswa;
        } else {
            System.out.println("Array sudah penuh");
        }
    }

    public void hapusMahasiswa() {
        if (this.cacah > 0) {
            this.data[--this.cacah] = null;
        } else {
            System.out.println("Array sudah kosong");
        }
    }

    public String getAllMahasiswa() {
        String s = "";

        for (int i = 0; i < this.cacah; i++) {
            s = s + (i + 1) + ". " + this.data[i].getMhs();
        }

        return s;
    }

    public void bubbleNIM(String order) {
        if (order.equals("Ascending")) {
            int p, b;
            Mahasiswa titip;

            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < this.cacah - p; b++) {
                    if (data[b].getNIM().compareTo(data[b + 1].getNIM()) > 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        } else {
            int p, b;
            Mahasiswa titip;

            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < this.cacah - p; b++) {
                    if (data[b].getNIM().compareTo(data[b + 1].getNIM()) < 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
    }

    public void bubbleNama(String order) {
        if (order.equals("Ascending")) {
            int p, b;
            Mahasiswa titip;

            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < this.cacah - p; b++) {
                    if (data[b].getNama().compareTo(data[b + 1].getNama()) > 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        } else {
            int p, b;
            Mahasiswa titip;

            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < this.cacah - p; b++) {
                    if (data[b].getNama().compareTo(data[b + 1].getNama()) < 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
    }

    public void bubbleKota(String order) {
        if (order.equals("Ascending")) {
            int p, b;
            Mahasiswa titip;

            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < this.cacah - p; b++) {
                    if (data[b].getKota().compareTo(data[b + 1].getKota()) > 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        } else {
            int p, b;
            Mahasiswa titip;

            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < this.cacah - p; b++) {
                    if (data[b].getKota().compareTo(data[b + 1].getKota()) < 0) {
                        titip = data[b];
                        data[b] = data[b + 1];
                        data[b + 1] = titip;
                    }
                }
            }
        }
    }
}
