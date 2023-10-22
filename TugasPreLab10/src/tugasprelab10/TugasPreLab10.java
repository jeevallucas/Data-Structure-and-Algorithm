package tugasprelab10;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TugasPreLab10 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    TableView animeTable = new TableView<>();
    
    TextField codeField = new TextField();
    TextField animeTitleField = new TextField();
    TextField scoreField = new TextField();
    TextField typeField = new TextField();
    TextField episodesField = new TextField();
    TextField ratedField = new TextField();
    TextField premieredField = new TextField();
    TextField studiosField = new TextField();
    TextField genresField = new TextField();
    
    Button newButton = new Button("_New");
    Button editButton = new Button("_Edit");
    Button deleteButton = new Button("_Delete");
    Button searchButton = new Button("_Search");
    Button filterButton = new Button("_Filter");
    Button saveButton = new Button("_Save");
    Button undoButton = new Button("_Undo");
    Button closeButton = new Button("_Close");
    
    HBox hb = new HBox();
    HBox hb1 = new HBox();
    HBox hb2 = new HBox();
    VBox vb = new VBox();

    private void tableInitialization() {
        TableColumn<Object, String> codeColumn = new TableColumn("Code");
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("Code"));
        codeColumn.setMinWidth(60);
        codeColumn.setMaxWidth(60);
        codeColumn.setStyle("-fx-alignment:center");
        
        TableColumn<Object, String> animeTitleColumn = new TableColumn("Anime Title");
        animeTitleColumn.setCellValueFactory(new PropertyValueFactory<>("AnimeTitle"));
        animeTitleColumn.setMinWidth(510);
        animeTitleColumn.setMaxWidth(510);
        animeTitleColumn.setStyle("-fx-alignment:left");
        
        TableColumn<Object, String> scoreColumn = new TableColumn("Score");
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("Score"));
        scoreColumn.setMinWidth(60);
        scoreColumn.setMaxWidth(60);
        scoreColumn.setStyle("-fx-alignment:center");
        
        TableColumn<Object, String> typeColumn = new TableColumn("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));
        typeColumn.setMinWidth(60);
        typeColumn.setMaxWidth(60);
        typeColumn.setStyle("-fx-alignment:center");
        
        TableColumn<Object, String> episodesColumn = new TableColumn("Episodes");
        episodesColumn.setCellValueFactory(new PropertyValueFactory<>("Episodes"));
        episodesColumn.setMinWidth(65);
        episodesColumn.setMaxWidth(65);
        episodesColumn.setStyle("-fx-alignment:center");
        
        TableColumn<Object, String> ratedColumn = new TableColumn("Rated");
        ratedColumn.setCellValueFactory(new PropertyValueFactory<>("Rated"));
        ratedColumn.setMinWidth(60);
        ratedColumn.setMaxWidth(60);
        ratedColumn.setStyle("-fx-alignment:center");
        
        TableColumn<Object, String> premieredColumn = new TableColumn("Premiered");
        premieredColumn.setCellValueFactory(new PropertyValueFactory<>("Premiered"));
        premieredColumn.setMinWidth(110);
        premieredColumn.setMaxWidth(110);
        premieredColumn.setStyle("-fx-alignment:center");
        
        TableColumn<Object, String> studiosColumn = new TableColumn("Studios");
        studiosColumn.setCellValueFactory(new PropertyValueFactory<>("Studios"));
        studiosColumn.setMinWidth(160);
        studiosColumn.setMaxWidth(160);
        studiosColumn.setStyle("-fx-alignment:center");
        
        TableColumn<Object, String> genresColumn = new TableColumn("Genres");
        genresColumn.setCellValueFactory(new PropertyValueFactory<>("Genres"));
        genresColumn.setMaxWidth(110);
        genresColumn.setMaxWidth(110);
        genresColumn.setStyle("-fx-alignment:center");
        
        animeTable.getColumns().addAll(codeColumn, animeTitleColumn, scoreColumn, typeColumn, episodesColumn, ratedColumn,
                premieredColumn, studiosColumn, genresColumn);
    }

    void firstTimeOpen() {
        codeField.setEditable(false);
        animeTitleField.setEditable(false);
        scoreField.setEditable(false);
        typeField.setEditable(false);
        episodesField.setEditable(false);
        ratedField.setEditable(false);
        premieredField.setEditable(false);
        studiosField.setEditable(false);
        genresField.setEditable(false);
        
        codeField.setDisable(true);
        animeTitleField.setDisable(true);
        scoreField.setDisable(true);
        typeField.setDisable(true);
        episodesField.setDisable(true);
        ratedField.setDisable(true);
        premieredField.setDisable(true);
        studiosField.setDisable(true);
        genresField.setDisable(true);
        
        newButton.setDisable(false);
        editButton.setDisable(true);
        deleteButton.setDisable(true);
        searchButton.setDisable(true);
        filterButton.setDisable(true);
        saveButton.setDisable(true);
        undoButton.setDisable(true);
    }

    void beginning() {
        codeField.setEditable(false);
        animeTitleField.setEditable(false);
        scoreField.setEditable(false);
        typeField.setEditable(false);
        episodesField.setEditable(false);
        ratedField.setEditable(false);
        premieredField.setEditable(false);
        studiosField.setEditable(false);
        genresField.setEditable(false);
        
        codeField.setDisable(true);
        animeTitleField.setDisable(true);
        scoreField.setDisable(true);
        typeField.setDisable(true);
        episodesField.setDisable(true);
        ratedField.setDisable(true);
        premieredField.setDisable(true);
        studiosField.setDisable(true);
        genresField.setDisable(true);
        
        newButton.setDisable(false);
        editButton.setDisable(false);
        deleteButton.setDisable(false);
        searchButton.setDisable(false);
        filterButton.setDisable(false);
        saveButton.setDisable(true);
        undoButton.setDisable(true);
    }

    void open() {
        codeField.setEditable(true);
        animeTitleField.setEditable(true);
        scoreField.setEditable(true);
        typeField.setEditable(true);
        episodesField.setEditable(true);
        ratedField.setEditable(true);
        premieredField.setEditable(true);
        studiosField.setEditable(true);
        genresField.setEditable(true);
        
        codeField.setDisable(false);
        animeTitleField.setDisable(false);
        scoreField.setDisable(false);
        typeField.setDisable(false);
        episodesField.setDisable(false);
        ratedField.setDisable(false);
        premieredField.setDisable(false);
        studiosField.setDisable(false);
        genresField.setDisable(false);
        
        newButton.setDisable(true);
        editButton.setDisable(true);
        deleteButton.setDisable(true);
        searchButton.setDisable(true);
        filterButton.setDisable(true);
        saveButton.setDisable(false);
        undoButton.setDisable(false);
        codeField.requestFocus();
    }
    
    private void emptyFieldReaction() {
        codeField.setEditable(true);
        animeTitleField.setEditable(true);
        scoreField.setEditable(true);
        typeField.setEditable(true);
        episodesField.setEditable(true);
        ratedField.setEditable(true);
        premieredField.setEditable(true);
        studiosField.setEditable(true);
        genresField.setEditable(true);
        
        codeField.setDisable(false);
        animeTitleField.setDisable(false);
        scoreField.setDisable(false);
        typeField.setDisable(false);
        episodesField.setDisable(false);
        ratedField.setDisable(false);
        premieredField.setDisable(false);
        studiosField.setDisable(false);
        genresField.setDisable(false);
        
        newButton.setDisable(true);
        editButton.setDisable(true);
        deleteButton.setDisable(true);
        searchButton.setDisable(false);
        filterButton.setDisable(false);
        saveButton.setDisable(false);
        undoButton.setDisable(false);
    }

    private void emptyFieldWarning() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Attention, please...");
        alert.setContentText("Sorry, the data you want to add cannot be added. Because there are still empty fields or fields that you"
                + "have not filled in.");
        
        if (codeField.getText().isEmpty()) {
            alert.showAndWait();
            emptyFieldReaction();
            codeField.requestFocus();
        }
        
        else if (animeTitleField.getText().isEmpty()) {
            alert.showAndWait();
            emptyFieldReaction();
            animeTitleField.requestFocus();
        }
        
        else if (scoreField.getText().isEmpty()) {
            alert.showAndWait();
            emptyFieldReaction();
            scoreField.requestFocus();
        }
        
        else if (typeField.getText().isEmpty()) {
            alert.showAndWait();
            emptyFieldReaction();
            typeField.requestFocus();
        }
        
        else if (episodesField.getText().isEmpty()) {
            alert.showAndWait();
            emptyFieldReaction();
            episodesField.requestFocus();
        }
        
        else if (ratedField.getText().isEmpty()) {
            alert.showAndWait();
            emptyFieldReaction();
            ratedField.requestFocus();
        }
        
        else if (premieredField.getText().isEmpty()) {
            alert.showAndWait();
            emptyFieldReaction();
            premieredField.requestFocus();
        }
        
        else if (studiosField.getText().isEmpty()) {
            alert.showAndWait();
            emptyFieldReaction();
            studiosField.requestFocus();
        }
        
        else if (genresField.getText().isEmpty()) {
            alert.showAndWait();
            emptyFieldReaction();
            genresField.requestFocus();
        }
        
        else {
            save();
        }
    }

    void undo() {
        codeField.clear();
        animeTitleField.clear();
        scoreField.clear();
        typeField.clear();
        episodesField.clear();
        ratedField.clear();
        premieredField.clear();
        studiosField.clear();
        genresField.clear();
        
        beginning();
    }

    private void save() {
        String code, animeTitle, score, type, episodes, rated, premiered, studios, genres;
        
        code = codeField.getText();
        animeTitle = animeTitleField.getText();
        score = scoreField.getText();
        type = typeField.getText();
        episodes = episodesField.getText();
        rated = ratedField.getText();
        premiered = premieredField.getText();
        studios = studiosField.getText();
        genres = genresField.getText();
        
        Anime anime = new Anime(code, animeTitle, score, type, episodes, rated, premiered, studios, genres);
        
        animeTable.getItems().add(anime);
        
        codeField.clear();
        animeTitleField.clear();
        scoreField.clear();
        typeField.clear();
        episodesField.clear();
        ratedField.clear();
        premieredField.clear();
        studiosField.clear();
        genresField.clear();
        
        beginning();
    }

    void edit() {
        String code, animeTitle, score, type, episodes, rated, premiered, studios, genres;
        
        ObservableList<Anime> select = animeTable.getSelectionModel().getSelectedItems();
        
        code = select.get(0).getCode();
        animeTitle = select.get(0).getAnimeTitle();
        score = String.valueOf(select.get(0).getScore());
        type = select.get(0).getType();
        episodes = String.valueOf(select.get(0).getEpisodes());
        rated = select.get(0).getRated();
        premiered = select.get(0).getPremiered();
        studios = select.get(0).getStudios();
        genres = select.get(0).getGenres();
        
        codeField.setText(code);
        animeTitleField.setText(animeTitle);
        scoreField.setText(score);
        typeField.setText(type);
        episodesField.setText(episodes);
        ratedField.setText(rated);
        premieredField.setText(premiered);
        studiosField.setText(studios);
        genresField.setText(genres);
        
        codeField.setEditable(true);
        animeTitleField.setEditable(true);
        scoreField.setEditable(true);
        typeField.setEditable(true);
        episodesField.setEditable(true);
        ratedField.setEditable(true);
        premieredField.setEditable(true);
        studiosField.setEditable(true);
        genresField.setEditable(true);
        
        codeField.setDisable(false);
        animeTitleField.setDisable(false);
        scoreField.setDisable(false);
        typeField.setDisable(false);
        episodesField.setDisable(false);
        ratedField.setDisable(false);
        premieredField.setDisable(false);
        studiosField.setDisable(false);
        genresField.setDisable(false);
        
        newButton.setDisable(true);
        editButton.setDisable(true);
        deleteButton.setDisable(true);
        searchButton.setDisable(true);
        filterButton.setDisable(true);
        saveButton.setDisable(false);
        undoButton.setDisable(false);
        
        delete();
        
        codeField.requestFocus();
    }

    private void delete() {
        ObservableList<Anime> select, all;
        
        all = animeTable.getItems();
        select = animeTable.getSelectionModel().getSelectedItems();
        
        select.forEach(all::remove);
        open();
    }

    void search() {
        String animeTitleSearch = dialogBox();
        ObservableList<Anime> animeList = animeTable.getItems();
        int index, amount = animeList.size();
        
        for (index = 0; index < amount; index++) {
            if (animeList.get(index).getAnimeTitle().contains(animeTitleSearch)) {
                break;
            }
        }
        
        if (index < amount) {
            animeTable.getSelectionModel().select(index);
            animeTable.scrollTo(index);
            animeTable.requestFocus();
            
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Anime with the code '" + animeTitleSearch + "' was found.");
            a.show();
        }
        
        else {
            Alert a = new Alert(Alert.AlertType.WARNING, "Anime with the code '" + animeTitleSearch + "'  was not found.");
            a.show();
        }
    }

    String dialogBox() {
        TextField codeField = new TextField();
        codeField.setMinWidth(500);
        codeField.setPromptText("Anime Title");
        
        Button searchButton = new Button("_Search");
        
        HBox hb = new HBox(5, codeField, searchButton);
        hb.setPadding(new Insets(15, 10, 10, 10));
        
        Stage window = new Stage();
        window.setScene(new Scene(hb));
        window.setTitle("Search an Anime Title");
        window.isFocused();
        window.setMinHeight(50);
        window.setMinWidth(500);
        window.initModality(Modality.APPLICATION_MODAL);
        
        searchButton.setOnAction(e -> window.close());
        
        window.showAndWait();
        return codeField.getText();
    }

    void filterDialogBox() {
        TextField filterField = new TextField();
        filterField.setMinWidth(510);
        filterField.setPromptText("Code AnimeTitle Score Type Episodes Rated Premiered Studios Genres");
        
        Button closeButton = new Button("_Close");
        
        HBox hb = new HBox(5, filterField, closeButton);
        hb.setPadding(new Insets(15, 10, 10, 10));
        
        Stage window = new Stage();
        window.setScene(new Scene(hb));
        window.initModality(Modality.APPLICATION_MODAL);
        
        closeButton.setOnAction(e -> window.close());
        
        FilteredList<Anime> filteredData = new FilteredList<>(animeTable.getItems(), b -> true);
        
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(anime -> {
                String source = anime.getCode() + anime.getAnimeTitle() + anime.getScore() + anime.getType()+ anime.getEpisodes()
                        + anime.getRated() + anime.getPremiered() + anime.getStudios() + anime.getGenres();
                
                return source.toLowerCase().contains(newValue.toLowerCase());
            });
            
            animeTable.setItems(filteredData);
        });
        
        window.setTitle("FILTER: Code, Anime Title, Score, Type, Episodes, Rated, Premiered, Studios, or Genres ");
        window.isFocused();
        window.setMinHeight(50);
        window.setMinWidth(650);
        window.showAndWait();
        
        filteredData.setPredicate(t -> true);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        codeField.setMinWidth(45);
        codeField.setMaxWidth(45);
        codeField.setPromptText("Code");
        
        animeTitleField.setMinWidth(510);
        animeTitleField.setMaxWidth(510);
        animeTitleField.setPromptText("Anime Title");
        
        scoreField.setMinWidth(50);
        scoreField.setMaxWidth(50);
        scoreField.setPromptText("Score");
        
        typeField.setMinWidth(60);
        typeField.setMaxWidth(60);
        typeField.setPromptText("Type");
        
        episodesField.setMinWidth(65);
        episodesField.setMaxWidth(65);
        episodesField.setPromptText("Episodes");
        
        ratedField.setMinWidth(50);
        ratedField.setMaxWidth(50);
        ratedField.setPromptText("Rated");
        
        premieredField.setMinWidth(95);
        premieredField.setMaxWidth(95);
        premieredField.setPromptText("Premiered");
        
        studiosField.setMinWidth(165);
        studiosField.setMaxWidth(165);
        studiosField.setPromptText("Studios");
        
        genresField.setMinWidth(95);
        genresField.setMaxWidth(95);
        genresField.setPromptText("Genres");
        
        hb.getChildren().addAll(codeField, animeTitleField, scoreField, typeField, episodesField, ratedField, premieredField,
                studiosField, genresField, saveButton, undoButton, closeButton);
        hb.setPadding(new Insets(10, 5, 5, 5));
        hb.setSpacing(5);
        
        hb1.getChildren().addAll(newButton, editButton, deleteButton, searchButton, filterButton);
        hb1.setPadding(new Insets(0, 0, 5, 5));
        hb1.setSpacing(5);
        
        vb.getChildren().addAll(animeTable, hb, hb1, hb2);
        
        tableInitialization();
        
        primaryStage.setScene(new Scene(vb));
        primaryStage.setTitle("Your Anime Title");
        primaryStage.show();
        firstTimeOpen();
        
        newButton.setOnAction((ActionEvent event) -> {
            open();
        });
        
        editButton.setOnAction((ActionEvent event) -> {
            edit();
        });
        
        deleteButton.setOnAction((ActionEvent event) -> {
            delete();
        });
        
        searchButton.setOnAction((ActionEvent event) -> {
            search();
        });
        
        filterButton.setOnAction((ActionEvent event) -> {
            filterDialogBox();
        });
        
        saveButton.setOnAction((ActionEvent event) -> {
            emptyFieldWarning();
        });
        
        undoButton.setOnAction((ActionEvent event) -> {
            undo();
        });
        
        closeButton.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
    }
}
