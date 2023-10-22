package Praktikum_08_72210512;

import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class YourAnimeList extends Application {
    boolean baru = true;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    TableView<Anime> tabel;
    
    public ObservableList<Anime> getAnime() {
        ObservableList<Anime> anime = FXCollections.observableArrayList();
        
        return anime;
    }
    
    TextField txtKode = new TextField();
    TextField txtAnimeTitle = new TextField();
    TextField txtScore = new TextField();
    TextField txtType = new TextField();
    TextField txtEpisodes = new TextField();
    TextField txtRated = new TextField();
    TextField txtPremiered = new TextField();
    TextField txtStudios = new TextField();
    TextField txtGenres = new TextField();
    
    VBox vb = new VBox();
    HBox hb = new HBox();
    HBox hb1 = new HBox();
    
    Button btnAdd = new Button("_Add");
    Button btnUpdate = new Button("_Update");
    Button btnDelete = new Button("_Delete");
    Button btnClear = new Button("_Clear");
    Button btnExit = new Button("_Exit");
    
    private void inisiasiKontrol() {
        txtKode.setMinWidth(45);
        txtKode.setMaxWidth(45);
        txtKode.setPromptText("Kode");
        
        txtAnimeTitle.setMinWidth(510);
        txtAnimeTitle.setMaxWidth(510);
        txtAnimeTitle.setPromptText("Anime Title");
        
        txtScore.setMinWidth(50);
        txtScore.setMaxWidth(50);
        txtScore.setPromptText("Score");
        
        txtType.setMinWidth(60);
        txtType.setMaxWidth(60);
        txtType.setPromptText("Type");
        
        txtEpisodes.setMinWidth(95);
        txtEpisodes.setMaxWidth(95);
        txtEpisodes.setPromptText("Episodes");
        
        txtRated.setMinWidth(50);
        txtRated.setMaxWidth(50);
        txtRated.setPromptText("Rated");
        
        txtPremiered.setMinWidth(95);
        txtPremiered.setMaxWidth(95);
        txtPremiered.setPromptText("Premiered");
        
        txtStudios.setMinWidth(165);
        txtStudios.setMaxWidth(165);
        txtStudios.setPromptText("Studios");
        
        txtGenres.setMinWidth(95);
        txtGenres.setMaxWidth(95);
        txtGenres.setPromptText("Genres");
        
        hb.getChildren().addAll(txtKode, txtAnimeTitle, txtScore, txtType, txtEpisodes, txtRated, txtPremiered, txtStudios, txtGenres);
        hb.setPadding(new Insets(0, 5, 5, 5));
        hb.setSpacing(5);
        
        hb1.getChildren().addAll(btnAdd, btnUpdate, btnDelete, btnClear, btnExit);
        hb1.setPadding(new Insets(0, 5, 5, 5));
        hb1.setSpacing(5);
        
        vb.getChildren().addAll(tabel, hb, hb1);
    }
    
    private void add() {
        String kode, animeTitle, type, rated, premiered, studios, genres;
        int score, episodes;
        
        kode = txtKode.getText();
        animeTitle = txtAnimeTitle.getText();
        score = Integer.parseInt(txtScore.getText());
        type = txtType.getText();
        episodes = Integer.parseInt(txtEpisodes.getText());
        rated = txtRated.getText();
        premiered = txtPremiered.getText();
        studios = txtStudios.getText();
        genres = txtGenres.getText();
        
        Anime anime = new Anime(kode, animeTitle, score, type, episodes, rated, premiered, studios, genres);
        
        tabel.getItems().add(anime);
        
        txtKode.clear();
        txtAnimeTitle.clear();
        txtScore.clear();
        txtType.clear();
        txtEpisodes.clear();
        txtRated.clear();
        txtPremiered.clear();
        txtStudios.clear();
        txtGenres.clear();
        
        txtKode.requestFocus();
    }
    
    private void update() {
        String kode, animeTitle, score, type, episodes, rated, premiered, studios, genres;
        
        ObservableList<Anime> pilih = tabel.getSelectionModel().getSelectedItems();
        
        kode = pilih.get(0).getKode();
        animeTitle = pilih.get(0).getAnimeTitle();
        score = String.valueOf(pilih.get(0).getScore());
        type = pilih.get(0).getType();
        episodes = String.valueOf(pilih.get(0).getEpisodes());
        rated = pilih.get(0).getRated();
        premiered = pilih.get(0).getPremiered();
        studios = pilih.get(0).getStudios();
        genres = pilih.get(0).getGenres();
        
        txtKode.setText(kode);
        txtAnimeTitle.setText(animeTitle);
        txtScore.setText(score);
        txtType.setText(type);
        txtEpisodes.setText(episodes);
        txtRated.setText(rated);
        txtPremiered.setText(premiered);
        txtStudios.setText(studios);
        txtGenres.setText(genres);
        
        delete();
        
        txtKode.requestFocus();
    }
    
    private void delete() {
        ObservableList<Anime> pilih, semua;
        
        semua = tabel.getItems();
        pilih = tabel.getSelectionModel().getSelectedItems();
        
        pilih.forEach(semua::remove);
        
        txtKode.requestFocus();
    }
    
    private void clear() {
        txtKode.clear();
        txtAnimeTitle.clear();
        txtScore.clear();
        txtType.clear();
        txtEpisodes.clear();
        txtRated.clear();
        txtPremiered.clear();
        txtStudios.clear();
        txtGenres.clear();
        
        txtKode.requestFocus();
    }
    
    private void pertamaKaliDibuka() {
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }
    
    private void berinteraksiDenganButtonAdd() {
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
        
        txtKode.requestFocus();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        tabel = new TableView<>();
        tabel.setItems(getAnime());
        
        TableColumn<Anime, String> kolKode = new TableColumn<>("Kode");
        kolKode.setCellValueFactory(new PropertyValueFactory<>("Kode"));
        kolKode.setMinWidth(60);
        kolKode.setMaxWidth(60);
        kolKode.setStyle("-fx-alignment:center");
        
        TableColumn<Anime, String> kolAnimeTitle = new TableColumn<>("Anime Title");
        kolAnimeTitle.setCellValueFactory(new PropertyValueFactory<>("AnimeTitle"));
        kolAnimeTitle.setMinWidth(510);
        kolAnimeTitle.setMaxWidth(510);
        kolAnimeTitle.setStyle("-fx-alignment:left");
        
        TableColumn<Anime, String> kolScore = new TableColumn<>("Score");
        kolScore.setCellValueFactory(new PropertyValueFactory<>("Score"));
        kolScore.setMinWidth(60);
        kolScore.setMaxWidth(60);
        kolScore.setStyle("-fx-alignment:center");
        
        TableColumn<Anime, String> kolType = new TableColumn<>("Type");
        kolType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        kolType.setMinWidth(60);
        kolType.setMaxWidth(60);
        kolType.setStyle("-fx-alignment:center");
        
        TableColumn<Anime, String> kolEpisodes = new TableColumn<>("Episodes");
        kolEpisodes.setCellValueFactory(new PropertyValueFactory<>("Episodes"));
        kolEpisodes.setMinWidth(110);
        kolEpisodes.setMaxWidth(110);
        kolEpisodes.setStyle("-fx-alignment:center");
        
        TableColumn<Anime, String> kolRated = new TableColumn<>("Rated");
        kolRated.setCellValueFactory(new PropertyValueFactory<>("Rated"));
        kolRated.setMinWidth(60);
        kolRated.setMaxWidth(60);
        kolRated.setStyle("-fx-alignment:center");
        
        TableColumn<Anime, String> kolPremiered = new TableColumn<>("Premiered");
        kolPremiered.setCellValueFactory(new PropertyValueFactory<>("Premiered"));
        kolPremiered.setMinWidth(110);
        kolPremiered.setMaxWidth(110);
        kolPremiered.setStyle("-fx-alignment:center");
        
        TableColumn<Anime, String> kolStudios = new TableColumn<>("Studios");
        kolStudios.setCellValueFactory(new PropertyValueFactory<>("Studios"));
        kolStudios.setMinWidth(160);
        kolStudios.setMaxWidth(160);
        kolStudios.setStyle("-fx-alignment:center");
        
        TableColumn<Anime, String> kolGenres = new TableColumn<>("Genres");
        kolGenres.setCellValueFactory(new PropertyValueFactory<>("Genres"));
        kolGenres.setMaxWidth(110);
        kolGenres.setMaxWidth(110);
        kolGenres.setStyle("-fx-alignment:center");
        
        tabel.setItems(getAnime());
        tabel.getColumns().addAll(kolKode, kolAnimeTitle, kolScore, kolType, kolEpisodes, kolRated, kolPremiered, kolStudios, kolGenres);
        
        inisiasiKontrol();
        
        primaryStage.setScene(new Scene(vb));
        primaryStage.setTitle("Your Anime List");
        primaryStage.show();
        
        pertamaKaliDibuka();
        
        btnAdd.setOnAction((ActionEvent event) -> {
            try {
                add();
                berinteraksiDenganButtonAdd();
            }
            
            catch(Exception e) {
                Alert alert = new Alert(AlertType.WARNING);
                
                alert.setTitle("WARNING");
                alert.setHeaderText("Attention, please.");
                alert.setContentText("Sorry, the data you want to add cannot be added. Because there are still empty fields or fields that you have not filled in.");
                alert.showAndWait();
            }
        });
        
        btnUpdate.setOnAction((ActionEvent event) -> {
            update();
        });
        
        btnDelete.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            Alert alert2 = new Alert(AlertType.INFORMATION);
            
            alert.setTitle("CONFIRMATION");
            alert.setHeaderText("Are you sure you want to remove this Anime from your list?");
            alert.setContentText("Made by:\n\n72210515\nPUTU JEEVALLUCAS JNANAMAITRIYA SURYA GAUTAMA\nDENPASAR");
            
            Optional<ButtonType> jwb = alert.showAndWait();
            
            if(jwb.get() == ButtonType.OK)
                delete();
            
            else if(jwb.get() == ButtonType.CANCEL) {
                alert2.show();
                alert2.setTitle("INFORMATION");
                alert2.setHeaderText("Data deletion is cancelled.");
                alert2.setContentText("Data was not deleted.");
            }
        });
        
        btnClear.setOnAction((ActionEvent event) -> {
            clear();
        });
        
        btnExit.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
    }
}