package praktikum_10_72210512;

public class Table {
    private final Anime[] animeList;
    private int amount, selectElement;
    TextFile file;

    public Table(int manyElements) {
        animeList = new Anime[manyElements];
        amount = 0;
        selectElement = 0;
        this.file = new TextFile("src/praktikum_10_72210512/Anime.csv");
    }
    
    public void addAnime(Anime anime) {
        if(amount < animeList.length) {
            String code;
            code = anime.getCode();
            animeList[amount++] = anime;
            
            int pivot, search, min;
            Anime entrusted;
            
            for(pivot = 0; pivot < this.amount - 1; pivot++) {
                min = pivot;
                for(search = pivot + 1; search < this.amount; search++) {
                    if(this.animeList[search].getCode().compareTo(this.animeList[min].getCode()) < 0) {
                        min = search;
                    }
                }
                
                entrusted = this.animeList[pivot];
                this.animeList[pivot] = this.animeList[min];
                this.animeList[min] = entrusted;
            }
            
            anime.code = code;
            this.selectElement++;
        }
        
        else {
            System.out.println();
        }
    }
    
    public Anime readAnime() {
        if(selectElement >= 0 && selectElement < amount)
            return this.animeList[selectElement];
        else
            return new Anime("", "", "", "", "", "", "", "", "");
    }
    
    public void changeAnime(Anime anime) {
        animeList[selectElement] = anime;
    }
    
    public void deleteAnime() {
        if(amount > 0) {
            for(int index = selectElement; index < amount; index++)
                animeList[index] = animeList[index + 1];
            amount--;
            
            if(amount > 0)
                selectElement = 0;
            else
                selectElement = -1;
        }
        
        else
            System.out.println();
    }
    
    public String getAll() {
        String getAnime = "";
        for(int index = 0; index < this.amount; index++)
            getAnime += this.animeList[index].getAnimeTitle() + "\n";
        System.out.println();
        return getAnime;
    }
    
    public void saveToFile() throws Exception {
        this.file.write(String.valueOf(this.getAll()));
    }
}