package tugasprelab13;

public class Larik {
    private int[] data;
    private int cacah;
    String proses = "";
    
    public Larik(int byk) {
        this.data = new int[byk];
        this.cacah = 0;
    }
    
    public void add(int bil) {
        if (this.cacah < this.data.length)
            this.data[cacah++] = bil;
        else
            System.out.println();
    }
    
    public String getArray() {
        String s = "";
        
        for (int idx = 0; idx < this.cacah; idx++)
            s+= this.data[idx] + ", ";
        
        s = s.substring(0, s.length() - 2);
        return s;
    }
    
    public String getProses() {
        return this.proses;
    }
    
    public void quickSortRekursif () {
        quickSort(0, this.cacah - 1);
    }
    
    public void array() {
        proses = "ARRAY: " + getArray() + "\n\n";
    }
    
    public void quickSort(int kiri, int kanan) {
        int i, j, pivot, sementara;
        
        i = kiri;
        j = kanan;
        pivot = i;
        
        proses += "KIRI: " + i +", KANAN: " + j + ", PIVOT: " + pivot + "\n";
        
        while (i < j) {
            while (data[j] >= data[pivot] && j > pivot)
                j--;
            
            sementara = data[pivot];
            data[pivot] = data[j];
            data[j] = sementara;
            proses+= "J \t: " + j + ", PIVOT: " + pivot + " <- tukar -> " + j + ", ARRAY: " + getArray() + "\n";
            pivot = j;
            
            while (data[i] < data[pivot] && i < pivot)
                i++;
            
            sementara = data[pivot];
            data[pivot] = data[i];
            data[i] = sementara;
            proses += "I \t: " + i + ", PIVOT: " + pivot + " <- tukar -> " + i + ", ARRAY: " + getArray() + "\n\n";
            pivot = i;
        }
        
        if (kiri < pivot - 1)
            quickSort(kiri, pivot - 1);
        if (kanan > pivot + 1)
            quickSort(pivot + 1, kanan);
    }
}