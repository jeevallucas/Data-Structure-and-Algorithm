package tugasprelab12;

public class Stack2 {
    private Batas[] data;
    private int top;

    public Stack2(int ukuran) {
        this.data = new Batas[ukuran];
        top = -1;
    }

    public void push(int kiri, int kanan) {
        if (this.top < this.data.length - 1)
            this.data[++this.top] = new Batas(kiri, kanan);
        else {
            System.out.println();
        }
    }

    public boolean habis() {
        return this.top < 0;
    }

    public Batas pop() {
        if (!this.habis())
            return this.data[this.top--];
        else {
            System.out.println();
            return new Batas(0, 0);
        }
    }
}