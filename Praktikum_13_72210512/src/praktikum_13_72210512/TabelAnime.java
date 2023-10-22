package praktikum_13_72210512;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TabelAnime extends TableView<Anime> {
    private int recordPointer;
    Anime[] data;
    int cacah;
    private String proses;
    private FileTeks file;
    
    public TabelAnime() {
        aturKolom();
        openFile();
        
        this.setOnMousePressed(e -> {
            this.recordPointer = this.getSelectionModel().getSelectedIndex();
            System.out.println(recordPointer);
        });
    }
    
    public TabelAnime(int tampung) {
        this.data = new Anime[tampung];
        this.cacah = 0;
        this.file = new FileTeks("src/praktikum_13_72210512/Anime.csv");
        isiAnime();
    }
    
    public void isiAnime() {
        String[] arrCSV = this.file.baca();
        String[] row;
        
        String code, animeTitle, score, type, episodes, rated, premiered, studios, genres;
        
        for (int i = 0; i < arrCSV.length; i++) {
            row = arrCSV[i].split(", ");
            code = row[0];
            animeTitle = row[1];
            score = row[2];
            type = row[3];
            episodes = row[4];
            rated = row[5];
            premiered = row[6];
            studios = row[7];
            genres = row[8];
            
            this.tambah(code, animeTitle, score, type, episodes, rated, premiered, studios, genres);
        }
    }
    
    public void tambah(String code, String animeTitle, String score, String type, String episodes, String rated, String premiered, String studios, String genres) {
        Anime baru = new Anime(code, animeTitle, score, type, episodes, rated, premiered, studios, genres);
        
        if (cacah < this.data.length)
            this.data[this.cacah++] = baru;
        else
            System.out.println("");
    }
    
    public void saveToFile() {
        this.file.tulis(this.getAll());
    }
    
    public String getAll() {
        String semua = "";
        
        for (int i = 0; i < this.cacah; i++)
            semua += this.data[i].getAnime() + "\n";
        
        return semua;
    }
    
    private void aturKolom() {
        TableColumn<Anime, String> kolCode = new TableColumn("Code");
        kolCode.setCellValueFactory(new PropertyValueFactory<>("Code"));
        kolCode.setMinWidth(60);
        kolCode.setMaxWidth(60);
        kolCode.setStyle("-fx-alignment:center");

        TableColumn<Anime, String> kolAnimeTitle = new TableColumn("Anime Title");
        kolAnimeTitle.setCellValueFactory(new PropertyValueFactory<>("AnimeTitle"));
        kolAnimeTitle.setMinWidth(510);
        kolAnimeTitle.setMaxWidth(510);

        TableColumn<Anime, String> kolScore = new TableColumn("Score");
        kolScore.setCellValueFactory(new PropertyValueFactory<>("Score"));
        kolScore.setMinWidth(60);
        kolScore.setMaxWidth(60);
        kolScore.setStyle("-fx-alignment:center");

        TableColumn<Anime, String> kolType = new TableColumn("Type");
        kolType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        kolType.setMinWidth(60);
        kolType.setMaxWidth(60);
        kolType.setStyle("-fx-alignment:center");

        TableColumn<Anime, String> kolEpisodes = new TableColumn("Episodes");
        kolEpisodes.setCellValueFactory(new PropertyValueFactory<>("Episodes"));
        kolEpisodes.setMinWidth(65);
        kolEpisodes.setMaxWidth(65);
        kolEpisodes.setStyle("-fx-alignment:center");

        TableColumn<Anime, String> kolRated = new TableColumn("Rated");
        kolRated.setCellValueFactory(new PropertyValueFactory<>("Rated"));
        kolRated.setMinWidth(60);
        kolRated.setMaxWidth(60);
        kolRated.setStyle("-fx-alignment:center");

        TableColumn<Anime, String> kolPremiered = new TableColumn("Premiered");
        kolPremiered.setCellValueFactory(new PropertyValueFactory<>("Premiered"));
        kolPremiered.setMinWidth(110);
        kolPremiered.setMaxWidth(110);
        kolPremiered.setStyle("-fx-alignment:center");

        TableColumn<Anime, String> kolStudios = new TableColumn("Studios");
        kolStudios.setCellValueFactory(new PropertyValueFactory<>("Studios"));
        kolStudios.setMinWidth(160);
        kolStudios.setMaxWidth(160);
        kolStudios.setStyle("-fx-alignment:center");

        TableColumn<Anime, String> kolGenres = new TableColumn("Genres");
        kolGenres.setCellValueFactory(new PropertyValueFactory<>("Genres"));
        kolGenres.setMaxWidth(110);
        kolGenres.setMaxWidth(110);
        kolGenres.setStyle("-fx-alignment:center");
        
        this.getColumns().addAll(kolCode, kolAnimeTitle, kolScore, kolType, kolEpisodes, kolRated, kolPremiered, kolStudios, kolGenres);
    }
    
    private void openFile() {
        FileTeks file = new FileTeks("src/praktikum_13_72210512/Anime.csv");
        String[] baris, daftar = file.baca();
        
        if (daftar[0].length() > 0) {
            int banyakBaris = daftar.length;
            
            String code, animeTitle, score, type, episodes, rated, premiered, studios, genres;
            
            for (int idx = 0; idx < banyakBaris; idx++) {
                baris = daftar[idx].split(", ");
                code = baris[0];
                animeTitle = baris[1];
                score = baris[2];
                type = baris[3];
                episodes = baris[4];
                rated = baris[5];
                premiered = baris[6];
                studios = baris[7];
                genres = baris[8];

                this.getItems().add(new Anime(code, animeTitle, score, type, episodes, rated, premiered, studios, genres));
            }
        }
    }
    
    public Anime getAnime() {
        return this.getItems().get(recordPointer);
    }
    
    public void tambahAnime(Anime anime) {
        this.getItems().add(anime);
    }
    
    public void ubahAnime(Anime anime) {
        this.getItems().set(recordPointer, anime);
    }
    
    public void hapusAnime() {
        ObservableList<Anime> pilih, semua;
        
        semua = this.getItems();
        pilih = this.getSelectionModel().getSelectedItems();
        pilih.forEach(semua::remove);
    }
}