package praktikum_03_72210512;

public class Waktu {

    private String waktuPertama, waktuKedua;

    public Waktu(int totalWaktu) {
    }

    public String getWaktuPertama() {
        return waktuPertama;
    }

    public void setWaktuPertama(String waktuPertama) {
        if (this.cekJam(waktuPertama)) {
            this.waktuPertama = waktuPertama;
        } else {
            this.waktuPertama = "00:" + waktuPertama.substring(3, 5);
        }

        if (this.cekMenit(waktuPertama)) {
            this.waktuPertama = this.waktuPertama.substring(0, 2) + ":" + waktuPertama.substring(3, 5);
        } else {
            this.waktuPertama = this.waktuPertama.substring(0, 2) + ":00";
        }
    }

    public String getWaktuKedua() {
        return waktuKedua;
    }

    public void setWaktuKedua(String waktuKedua) {
        if (this.cekJam(waktuKedua)) {
            this.waktuKedua = waktuKedua;
        } else {
            this.waktuKedua = "00:" + waktuKedua.substring(3, 5);
        }

        if (this.cekMenit(waktuKedua)) {
            this.waktuKedua = this.waktuKedua.substring(0, 2) + ":" + waktuKedua.substring(3, 5);
        } else {
            this.waktuKedua = this.waktuKedua.substring(0, 2) + ":00";
        }
    }

    private boolean cekJam(String waktu) {
        String jam = waktu.substring(0, 3);

        if (jam.compareTo("00") > 0 && jam.compareTo("24") < 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean cekMenit(String waktu) {
        String menit = waktu.substring(3, 5);

        if (menit.compareTo("00") > 0 && menit.compareTo("60") < 0) {
            return true;
        } else {
            return false;
        }
    }

    public int jadiMenit(String waktu) {
        String jam, menit;
        int menitHasil;

        jam = waktu.substring(0, 2);
        menit = waktu.substring(3, 5);

        menitHasil = Integer.parseInt(jam) * 60 + Integer.parseInt(menit);

        return menitHasil;
    }

    public String jadiWaktu(int menit) {
        int jam, men;
        String jamStr, menStr, hh, mm, waktu;

        jam = menit / 60;
        men = menit % 60;

        jamStr = "0" + jam;
        menStr = "0" + men;

        hh = jamStr.substring(jamStr.length() - 2, jamStr.length());
        mm = menStr.substring(menStr.length() - 2, menStr.length());

        waktu = hh + ":" + mm;

        return waktu;
    }

    public String selisihWaktu() {
        int waktu1, waktu2, selisih;
        String selisihWaktu;

        waktu1 = this.jadiMenit(this.getWaktuPertama());
        waktu2 = this.jadiMenit(this.getWaktuKedua());

        selisih = Math.abs(waktu2 - waktu1);
        selisihWaktu = this.jadiWaktu(selisih);

        return selisihWaktu;
    }
}
