package tugasprelab6;

public final class Data {
    private final int[] data;
    private int banyak;
    private final FileTXT file;
    
    public Data(int banyakData) {
        this.data = new int[banyakData];
        this.banyak = 0;
        this.file = new FileTXT("src/tugasprelab6/Data.txt");
        isiNilai();
    }

    public void menambahData(int nilai) {
        if(this.banyak < this.data.length) {
            this.data[this.banyak++] = nilai;
        }
    }

    public void menghapusData() {
        if(this.banyak > 0) {
            this.data[--this.banyak] = 0;
        }
    }

    public String membacaSemuaData() {
        String string = "";
        
        for (int i = 0; i < this.banyak; i++) {
            string += this.data[i] + ", ";
        }
        
        if (string.length() > 0) {
            string = string.substring(0, string.length() - 2);
        }
        
        return string;
    }
    
    public void isiNilai() {
        String[] arrayTXT = this.file.baca();
        String isiData;
        
        if(!arrayTXT[0].equals("")) {
            for(int i = 0; i < arrayTXT.length; i++) {
                isiData = arrayTXT[i];
                
                this.menambahData(Integer.valueOf(isiData));
            }
        }
    }

    public void saveFile() {
        this.file.tulis(this.membacaSemuaData());
    }
}