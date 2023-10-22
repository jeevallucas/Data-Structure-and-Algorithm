package praktikum_13_72210512;

import java.util.Collections;
import java.util.Comparator;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Praktikum_13_72210512 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    TabelAnime tabAnime = new TabelAnime();
    TabelAnime TA = new TabelAnime(100);
    
    Label lblCode = new Label("Code");
    Label lblAnimeTitle = new Label("Anime Title");
    Label lblScore = new Label("Score");
    Label lblType = new Label("Type");
    Label lblEpisodes = new Label("Episodes");
    Label lblRated = new Label("Rated");
    Label lblPremiered = new Label("Premiered");
    Label lblStudios = new Label("Studios");
    Label lblGenres = new Label("Genres");
    
    Region reg = new Region();
    
    TextField txtCode = new TextField();
    TextField txtAnimeTitle = new TextField();
    TextField txtScore = new TextField();
    TextField txtType = new TextField();
    TextField txtEpisodes = new TextField();
    TextField txtRated = new TextField();
    TextField txtPremiered = new TextField();
    TextField txtStudios = new TextField();
    TextField txtGenres = new TextField();
    
    Button btnNewSave = new Button("_New");
    Button btnEditUndo = new Button("_Edit");
    Button btnDel = new Button("_Delete");
    Button btnClose = new Button("_Close");
    
    HBox hb = new HBox();
    HBox hb1 = new HBox();
    HBox hb2 = new HBox();
    VBox vb = new VBox();
    
    GridPane grid = new GridPane();
    ComboBox cb = new ComboBox();
    
    Button btnFind = new Button("_Find");
    Button btnSort = new Button("_Quick Sort");
    Button btnFilter = new Button("_Filter");
    
    private void setGrid() {
        txtCode.setMinWidth(45);
        txtCode.setMaxWidth(45);
        
        txtAnimeTitle.setMinWidth(510);
        txtAnimeTitle.setMaxWidth(510);
        
        txtScore.setMinWidth(50);
        txtScore.setMaxWidth(50);
        
        txtType.setMinWidth(60);
        txtType.setMaxWidth(60);
        
        txtEpisodes.setMinWidth(65);
        txtEpisodes.setMaxWidth(65);
        
        txtRated.setMinWidth(50);
        txtRated.setMaxWidth(50);
        
        txtPremiered.setMinWidth(95);
        txtPremiered.setMaxWidth(95);
        
        txtStudios.setMinWidth(165);
        txtStudios.setMaxWidth(165);
        
        txtGenres.setMinWidth(95);
        txtGenres.setMaxWidth(95);
        
        cb.getItems().addAll("Code", "Anime Title", "Score", "Type", "Episodes", "Rated", "Premiered", "Studios", "Genres");
        cb.setValue("Code");
        
        hb1.getChildren().addAll(cb, btnSort);
        hb1.setPadding(new Insets(5, 5, 5, 5));
        
        hb.getChildren().addAll(btnNewSave, btnEditUndo, btnDel, btnFind, btnFilter, reg, btnClose);
        hb.setPadding(new Insets(0, 0, 5, 5));
        hb.setSpacing(5);
        
        hb1.setSpacing(5);
        
        HBox.setHgrow(reg, Priority.ALWAYS);
        
        grid.setVgap(5);
        grid.setHgap(10);
        
        hb2.getChildren().addAll(txtCode, txtAnimeTitle, txtScore, txtType, txtEpisodes, txtRated, txtPremiered, txtStudios, txtGenres);
        hb2.setPadding(new Insets(10, 5, 5, 5));
        hb2.setSpacing(5);
        
        grid.setPadding(new Insets(10));
    }
    
    void tampil() {
        Anime anime = tabAnime.getAnime();
        
        txtCode.setText(anime.getCode());
        txtAnimeTitle.setText(anime.getAnimeTitle());
        txtScore.setText(anime.getScore());
        txtType.setText(anime.getType());
        txtEpisodes.setText(anime.getEpisodes());
        txtRated.setText(anime.getRated());
        txtPremiered.setText(anime.getPremiered());
        txtStudios.setText(anime.getStudios());
        txtGenres.setText(anime.getGenres());
    }
    
    void buka() {
        txtCode.setEditable(true);
        txtAnimeTitle.setEditable(true);
        txtScore.setEditable(true);
        txtType.setEditable(true);
        txtEpisodes.setEditable(true);
        txtRated.setEditable(true);
        txtPremiered.setEditable(true);
        txtStudios.setEditable(true);
        txtGenres.setEditable(true);
        
        btnNewSave.setText("_Save");
        btnEditUndo.setText("_Undo");
        btnDel.setDisable(true);
        btnClose.setDisable(true);
        
        txtCode.requestFocus();
    }
    
    void tutup() {
        txtCode.setEditable(false);
        txtAnimeTitle.setEditable(false);
        txtScore.setEditable(false);
        txtType.setEditable(false);
        txtEpisodes.setEditable(false);
        txtRated.setEditable(false);
        txtPremiered.setEditable(false);
        txtStudios.setEditable(false);
        txtGenres.setEditable(false);
        
        btnNewSave.setText("_New");
        btnEditUndo.setText("_Edit");
        btnDel.setDisable(false);
        btnClose.setDisable(false);
    }
    
    boolean baru;
    
    void newSave() {
        if (btnNewSave.getText().equals("_New")) {
            baru = true;
            
            txtCode.clear();
            txtAnimeTitle.clear();
            txtScore.clear();
            txtType.clear();
            txtEpisodes.clear();
            txtRated.clear();
            txtPremiered.clear();
            txtStudios.clear();
            txtGenres.clear();
            
            buka();
        } else {
            String code, animeTitle, score, type, episodes, rated, premiered, studios, genres;
            
            code = txtCode.getText();
            animeTitle = txtAnimeTitle.getText();
            score = txtScore.getText();
            type = txtType.getText();
            episodes = txtEpisodes.getText();
            rated = txtRated.getText();
            premiered = txtPremiered.getText();
            studios = txtStudios.getText();
            genres = txtGenres.getText();
            
            Anime anime = new Anime(code, animeTitle, score, type, episodes, rated, premiered, studios, genres);
            
            if (baru)
                tabAnime.tambahAnime(anime);
            else
                tabAnime.ubahAnime(anime);
            
            TA.tambah(code, animeTitle, score, type, episodes, rated, premiered, studios, genres);
            
            txtCode.setText("");
            txtAnimeTitle.setText("");
            txtScore.setText("");
            txtType.setText("");
            txtEpisodes.setText("");
            txtRated.setText("");
            txtPremiered.setText("");
            txtStudios.setText("");
            txtGenres.setText("");
            
            TA.saveToFile();
            
            tutup();
        }
    }
    
    void editUndo() {
        if (btnEditUndo.getText().equals("_Edit")) {
            baru = false;
            buka();
        } else {
            tampil();
            tutup();
        }
    }
    
    void delete() {
        tabAnime.hapusAnime();
        tampil();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        txtCode.setPromptText("Code");
        txtAnimeTitle.setPromptText("Anime Title");
        txtScore.setPromptText("Score");
        txtType.setPromptText("TV");
        txtEpisodes.setPromptText("Episodes");
        txtRated.setPromptText("Rated");
        txtPremiered.setPromptText("2002");
        
        
        tabAnime.setOnMouseClicked(e -> tampil());
        setGrid();
        
        vb.getChildren().addAll(grid, tabAnime, hb1, hb2, hb);
        vb.setPadding(new Insets(10));
        
        Scene scene = new Scene(vb, 435, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Data Anime");
        primaryStage.show();
        
        tampil();
        tutup();
        
        btnSort.setOnAction(e -> quickSortRekursif());
        btnNewSave.setOnAction(e -> newSave());
        btnEditUndo.setOnAction(e -> editUndo());
        btnDel.setOnAction(e -> delete());
        btnClose.setOnAction(e -> {
            primaryStage.close();
            TA.saveToFile();
        });
        btnFind.setOnAction(e -> find());
        btnFilter.setOnAction(e -> filter());
    }
    
    private void quickSort(int kiri, int kanan) {
        int i, j, pivot;
        String sementara;
        
        ObservableList<Anime> dafAnime = tabAnime.getItems();
        int cacah = dafAnime.size();
        
        i = kiri;
        j = kanan;
        pivot = i;
        
        while (i < j) {
            if (cb.getValue().equals("Code")) {
                while (dafAnime.get(j).getCode().compareTo(dafAnime.get(pivot).getCode()) >= 0 && j > pivot) {
                    j--;
                }
                
                sementara = dafAnime.get(pivot).getCode();
                dafAnime.get(pivot).getCode().compareTo(dafAnime.get(j).getCode());
                dafAnime.get(j).getCode().compareTo(sementara);
                pivot = j;
                
                while (dafAnime.get(i).getCode().compareTo(dafAnime.get(pivot).getCode()) < 0 && i > pivot) {
                    i++;
                }
                
                sementara = dafAnime.get(pivot).getCode();
                dafAnime.get(pivot).getCode().compareTo(dafAnime.get(j).getCode());
                dafAnime.get(j).getCode().compareTo(sementara);
                pivot = i;
                
                Collections.swap(dafAnime, i, j);
            } else if (cb.getValue().equals("Anime Title")) {
                while (dafAnime.get(j).getAnimeTitle().compareTo(dafAnime.get(pivot).getAnimeTitle()) >= 0 && j > pivot) {
                    j--;
                }

                sementara = dafAnime.get(pivot).getAnimeTitle();
                dafAnime.get(pivot).getAnimeTitle().compareTo(dafAnime.get(j).getAnimeTitle());
                dafAnime.get(j).getAnimeTitle().compareTo(sementara);
                pivot = j;

                while (dafAnime.get(i).getAnimeTitle().compareTo(dafAnime.get(pivot).getAnimeTitle()) < 0 && i > pivot) {
                    i++;
                }

                sementara = dafAnime.get(pivot).getAnimeTitle();
                dafAnime.get(pivot).getAnimeTitle().compareTo(dafAnime.get(j).getAnimeTitle());
                dafAnime.get(j).getAnimeTitle().compareTo(sementara);
                pivot = i;

                Collections.swap(dafAnime, i, j);
            } else if (cb.getValue().equals("Score")) {
                while (dafAnime.get(j).getScore().compareTo(dafAnime.get(pivot).getScore()) >= 0 && j > pivot) {
                    j--;
                }

                sementara = dafAnime.get(pivot).getScore();
                dafAnime.get(pivot).getScore().compareTo(dafAnime.get(j).getScore());
                dafAnime.get(j).getScore().compareTo(sementara);
                pivot = j;

                while (dafAnime.get(i).getScore().compareTo(dafAnime.get(pivot).getScore()) < 0 && i > pivot) {
                    i++;
                }

                sementara = dafAnime.get(pivot).getScore();
                dafAnime.get(pivot).getScore().compareTo(dafAnime.get(j).getScore());
                dafAnime.get(j).getScore().compareTo(sementara);
                pivot = i;

                Collections.swap(dafAnime, i, j);
            } else if (cb.getValue().equals("Type")) {
                while (dafAnime.get(j).getType().compareTo(dafAnime.get(pivot).getType()) >= 0 && j > pivot) {
                    j--;
                }

                sementara = dafAnime.get(pivot).getType();
                dafAnime.get(pivot).getType().compareTo(dafAnime.get(j).getType());
                dafAnime.get(j).getType().compareTo(sementara);
                pivot = j;

                while (dafAnime.get(i).getType().compareTo(dafAnime.get(pivot).getType()) < 0 && i > pivot) {
                    i++;
                }

                sementara = dafAnime.get(pivot).getType();
                dafAnime.get(pivot).getType().compareTo(dafAnime.get(j).getType());
                dafAnime.get(j).getType().compareTo(sementara);
                pivot = i;

                Collections.swap(dafAnime, i, j);
            } else if (cb.getValue().equals("Episodes")) {
                while (dafAnime.get(j).getEpisodes().compareTo(dafAnime.get(pivot).getEpisodes()) >= 0 && j > pivot) {
                    j--;
                }

                sementara = dafAnime.get(pivot).getEpisodes();
                dafAnime.get(pivot).getEpisodes().compareTo(dafAnime.get(j).getEpisodes());
                dafAnime.get(j).getEpisodes().compareTo(sementara);
                pivot = j;

                while (dafAnime.get(i).getEpisodes().compareTo(dafAnime.get(pivot).getEpisodes()) < 0 && i > pivot) {
                    i++;
                }

                sementara = dafAnime.get(pivot).getEpisodes();
                dafAnime.get(pivot).getEpisodes().compareTo(dafAnime.get(j).getEpisodes());
                dafAnime.get(j).getEpisodes().compareTo(sementara);
                pivot = i;

                Collections.swap(dafAnime, i, j);
            } else if (cb.getValue().equals("Rated")) {
                while (dafAnime.get(j).getRated().compareTo(dafAnime.get(pivot).getRated()) >= 0 && j > pivot) {
                    j--;
                }

                sementara = dafAnime.get(pivot).getRated();
                dafAnime.get(pivot).getRated().compareTo(dafAnime.get(j).getRated());
                dafAnime.get(j).getRated().compareTo(sementara);
                pivot = j;

                while (dafAnime.get(i).getRated().compareTo(dafAnime.get(pivot).getRated()) < 0 && i > pivot) {
                    i++;
                }

                sementara = dafAnime.get(pivot).getRated();
                dafAnime.get(pivot).getRated().compareTo(dafAnime.get(j).getRated());
                dafAnime.get(j).getRated().compareTo(sementara);
                pivot = i;

                Collections.swap(dafAnime, i, j);
            } else if (cb.getValue().equals("Premiered")) {
                while (dafAnime.get(j).getPremiered().compareTo(dafAnime.get(pivot).getPremiered()) >= 0 && j > pivot) {
                    j--;
                }

                sementara = dafAnime.get(pivot).getPremiered();
                dafAnime.get(pivot).getPremiered().compareTo(dafAnime.get(j).getPremiered());
                dafAnime.get(j).getPremiered().compareTo(sementara);
                pivot = j;

                while (dafAnime.get(i).getPremiered().compareTo(dafAnime.get(pivot).getPremiered()) < 0 && i > pivot) {
                    i++;
                }

                sementara = dafAnime.get(pivot).getPremiered();
                dafAnime.get(pivot).getPremiered().compareTo(dafAnime.get(j).getPremiered());
                dafAnime.get(j).getPremiered().compareTo(sementara);
                pivot = i;

                Collections.swap(dafAnime, i, j);
            } else if (cb.getValue().equals("Studios")) {
                while (dafAnime.get(j).getStudios().compareTo(dafAnime.get(pivot).getStudios()) >= 0 && j > pivot) {
                    j--;
                }

                sementara = dafAnime.get(pivot).getStudios();
                dafAnime.get(pivot).getStudios().compareTo(dafAnime.get(j).getStudios());
                dafAnime.get(j).getStudios().compareTo(sementara);
                pivot = j;

                while (dafAnime.get(i).getStudios().compareTo(dafAnime.get(pivot).getStudios()) < 0 && i > pivot) {
                    i++;
                }

                sementara = dafAnime.get(pivot).getStudios();
                dafAnime.get(pivot).getStudios().compareTo(dafAnime.get(j).getStudios());
                dafAnime.get(j).getStudios().compareTo(sementara);
                pivot = i;

                Collections.swap(dafAnime, i, j);
            } else if (cb.getValue().equals("Genres")) {
                while (dafAnime.get(j).getGenres().compareTo(dafAnime.get(pivot).getGenres()) >= 0 && j > pivot) {
                    j--;
                }

                sementara = dafAnime.get(pivot).getGenres();
                dafAnime.get(pivot).getGenres().compareTo(dafAnime.get(j).getGenres());
                dafAnime.get(j).getGenres().compareTo(sementara);
                pivot = j;

                while (dafAnime.get(i).getGenres().compareTo(dafAnime.get(pivot).getGenres()) < 0 && i > pivot) {
                    i++;
                }

                sementara = dafAnime.get(pivot).getGenres();
                dafAnime.get(pivot).getGenres().compareTo(dafAnime.get(j).getGenres());
                dafAnime.get(j).getGenres().compareTo(sementara);
                pivot = i;

                Collections.swap(dafAnime, i, j);
            }
        }
        
        if (kiri < pivot - 1)
            quickSort(kiri, pivot - 1);
        if (kanan > pivot + 1)
            quickSort(pivot + 1, kanan);
    }
    
    public void quickSortRekursif() {
        ObservableList<Anime> anime = tabAnime.getItems();
        
        int cacah = anime.size();
        quickSort(0, cacah - 1);
    }
    
    private void find() {
        String cariCode = "", cariAnimeTitle, cari = dialogBox();
        ObservableList<Anime> dafAnime = tabAnime.getItems();

        dafAnime.sort(Comparator.comparing(Anime::getCode));

        int index, amount = dafAnime.size(), minimum, maximum, middle;
        minimum = 0;
        maximum = amount - 1;
        int binaryIteration = 0;

        while (minimum <= maximum) {
            binaryIteration++;
            middle = (minimum + maximum) / 2;

            cariCode = dafAnime.get(middle).getCode();
            cariAnimeTitle = dafAnime.get(middle).getAnimeTitle();

            if (cariCode.equals(cari) || cariAnimeTitle.contains(cari)) {
                break;
            }

            if (cariCode.compareTo(cari) < 0 && cariAnimeTitle.compareTo(cari) < 0) {
                minimum = middle + 1;
            } else {
                maximum = middle - 1;
            }
        }
        
        int sequentialIteration = 0;

        for (index = 0; index < amount; index++) {
            sequentialIteration++;

            if (dafAnime.get(index).getCode().equals(cari) || dafAnime.get(index).getAnimeTitle().contains(cari)) {
                break;
            }
        }

        if (cariCode.equals(cari) || index < amount) {
            tabAnime.getSelectionModel().select(index);
            tabAnime.scrollTo(index);
            tabAnime.requestFocus();

            Alert informationAlert = new Alert(Alert.AlertType.INFORMATION, "Sequential Search: " + sequentialIteration + "\n"
                    + "Binary Search: " + binaryIteration);
            informationAlert.show();

            binaryIteration = 0;
            sequentialIteration = 0;

        } else {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING, "Not Found.");
            warningAlert.show();

            binaryIteration = 0;
            sequentialIteration = 0;
        }
    }
    
    private String dialogBox() {
        ObservableList<Anime> dafAnime = tabAnime.getItems();

        dafAnime.sort(Comparator.comparing(Anime::getCode));

        TextField txtCode = new TextField();
        txtCode.setMinWidth(500);

        Button btnFind = new Button("_Find");

        ComboBox cb = new ComboBox();
        cb.getItems().addAll("Code", "Anime Title");
        cb.setValue("Code");

        cb.setOnAction((event) -> {
            if (cb.getValue().equals("Code")) {
                txtCode.setPromptText("Code");
                dafAnime.sort(Comparator.comparing(Anime::getCode));
            } else {
                txtCode.setPromptText("Anime Title");
                dafAnime.sort(Comparator.comparing(Anime::getAnimeTitle));
            }
        });

        HBox hb = new HBox(cb, txtCode, btnFind);
        hb.setPadding(new Insets(15, 10, 10, 10));
        hb.setSpacing(5);

        Stage window = new Stage();
        window.setScene(new Scene(hb));
        window.setTitle("Find a Code or an Anime Title");
        window.isFocused();
        window.setMinHeight(50);
        window.setMinWidth(500);
        window.initModality(Modality.APPLICATION_MODAL);
        btnFind.setOnAction(e -> window.close());
        window.showAndWait();

        return txtCode.getText();
    }
    
    void filter() {
        TableView<Anime> tabAnime1 = new TableView();
        TextField txtFilter = new TextField();
        txtFilter.setMinWidth(510);
        
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

        tabAnime1.getColumns().addAll(kolCode, kolAnimeTitle, kolScore, kolType, kolEpisodes, kolRated, kolPremiered, kolStudios, kolGenres);
        
        txtFilter.setPromptText("Code AnimeTitle Score Type Episodes Rated Premiered Studios Genres");

        Button btnClose = new Button("_Close");

        HBox hb = new HBox(5, txtFilter, btnClose);
        
        VBox vb = new VBox();
        
        vb.getChildren().addAll(hb, tabAnime1);
        vb.setPadding(new Insets(10));
        
        hb.setPadding(new Insets(15, 10, 10, 10));

        Stage window = new Stage();
        window.setScene(new Scene(vb));
        window.initModality(Modality.APPLICATION_MODAL);
        btnClose.setOnAction(e -> window.close());

        FilteredList<Anime> filteredData = new FilteredList<>(tabAnime.getItems(), b -> true);
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(anime -> {
                String source = anime.getCode() + anime.getAnimeTitle() + anime.getScore()
                        + anime.getType() + anime.getEpisodes() + anime.getRated()
                        + anime.getPremiered() + anime.getStudios() + anime.getGenres();
                return source.toLowerCase().contains(newValue.toLowerCase());
            });

            tabAnime1.setItems(filteredData);
        });
        
        tabAnime1.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                String code = tabAnime1.getItems().get(tabAnime1.getSelectionModel().getSelectedIndex()).getCode();
                
                int idx;
                
                for (idx = 0; idx < tabAnime.getItems().size(); idx++)
                    if (tabAnime.getItems().get(idx).getCode().equals(code))
                        break;
                
                tabAnime.scrollTo(idx);
                tabAnime.getSelectionModel().select(idx);
                window.close();
                tabAnime.requestFocus();
            }
        });

        window.setTitle("FILTER: Code, Anime Title, Score, Type, Episodes, Rated, Premiered, Studios, or Genres ");
        window.isFocused();
        window.setMinHeight(50);
        window.setMinWidth(650);
        window.showAndWait();
        filteredData.setPredicate(t -> true);
    }
}