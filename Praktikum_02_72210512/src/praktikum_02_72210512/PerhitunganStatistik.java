package praktikum_02_72210512;

public class PerhitunganStatistik {

    private int[] data;
    private int cacah;

    public PerhitunganStatistik(int banyak) {
        this.data = new int[banyak];
        this.cacah = 0;
    }

    public int banyakData() {
        return this.cacah;
    }

    public void addData(int elemen) {
        this.data[this.cacah] = elemen;
        this.cacah++;
    }

    public void delData() {
        this.cacah = this.cacah - 1;
        this.data[this.cacah] = 0;
    }

    public double sum() {
        double jum = 0;
        for (int idx = 0; idx <= cacah; idx++) {
            jum += this.data[idx];
        }
        return jum;
    }

    public double avg() {
        double rata = this.sum() / this.cacah;
        return rata;
    }

    public String ambilData() {
        String sambung = "";
        int idx;
        for (idx = 0; idx < this.cacah; idx++) {
            sambung = sambung + this.data[idx] + " ";
        }
        return sambung;
    }

    public int minimum() {
        int min = this.data[0];
        for (int i = 0; i < cacah; i++) {
            if (min > this.data[i]) {
                min = this.data[i];
            }
        }

        return min;
    }

    public int maksimum() {
        int max = this.data[0];
        for (int i = 0; i < cacah; i++) {
            if (max < this.data[i]) {
                max = this.data[i];
            }
        }

        return max;
    }
}
