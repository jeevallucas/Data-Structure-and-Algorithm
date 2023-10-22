package praktikum_06_72210512;

public class Larik {
    private int[] data;
    private int byk;
    private String proses;
    
    public Larik(int BanyakData) {
        this.data = new int[BanyakData];
        this.byk = 0;
    }
    
    public void addData(int nilai) {
        if(this.byk < data.length)
            this.data[this.byk++] = nilai;
        else
            System.out.println("");
    }
    
    public int getByk() {
        return this.byk;
    }
    
    public int getMaxElement() {
        return this.data.length;
    }
    
    public String getData() {
        String str = "";
        
        for(int i = 0; i < this.byk; i++) {
            str = str + this.data[i] + ", ";
        }
        
        if(str.length() > 0)
            str = str.substring(0, str.length() - 2);
        
        return str;
    }
    
    public String getProses() {
        return this.proses;
    }
    
    public void SelectionSort() {
        this.proses = "Data Awal: " + this.getData() + "\n\n";
        this.proses += "Pivot Minimum --> " + this.getData() + "\n";
        
        int pivot, cari, min, titip;
        
        for(pivot = 0; pivot < this.byk - 1; pivot++) {
            min = pivot;
            
            for(cari = pivot + 1; cari < this.byk; cari++) {
                if(this.data[cari] < this.data[min])
                    min = cari;
            }
            
            titip = this.data[pivot];
            this.data[pivot] = this.data[min];
            this.data[min] = titip;
            
            this.proses += pivot + "   -   " + min + "              --> " + this.getData() + "\n";
        }
        
        this.proses += "\nData Akhir: " + this.getData() + "\n";
    }
}
