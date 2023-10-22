package tugasprelab4;

public class Statistik {

    private double data[];
    private int cacah;

    public Statistik(int data) {
        this.data = new double[data];
        this.cacah = 0;
    }

    public int banyakData() {
        return this.cacah;
    }

    public void addData(double elemen) {
        this.data[this.cacah] = elemen;
        this.cacah = this.cacah + 1;
    }

    public void delData() {
        this.cacah = this.cacah - 1;
        this.data[this.cacah] = 0;
    }

    public double sum() {
        double jumlah = 0;

        for (int index = 0; index < cacah; index++) {
            jumlah = jumlah + this.data[index];
        }

        return jumlah;
    }

    public double avg() {
        double rataRata = this.sum() / this.cacah;
        return rataRata;
    }

    public String ambilData() {
        String ambilData = "";
        for (int index = 0; index < this.cacah; index++) {
            ambilData = ambilData + this.data[index] + " ";
        }

        return ambilData;
    }

    public double minimum() {
        double min = this.data[0];

        for (int index = 0; index <= this.data[index]; index++) {
            if (this.data[index] <= min) {
                min = this.data[index];
            }
            System.out.println(min);
        }

        return min;
    }

    public double maksimum() {
        double max = this.data[0];

        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] > max) {
                max = this.data[i];
            }
        }

        return max;
    }
}
