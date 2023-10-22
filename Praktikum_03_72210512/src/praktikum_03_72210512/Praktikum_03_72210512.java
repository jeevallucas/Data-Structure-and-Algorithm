package praktikum_03_72210512;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Praktikum_03_72210512 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Waktu waktu = new Waktu(100);

        GridPane gridPane = new GridPane();
        HBox hBoxPertama = new HBox();
        HBox hBoxKedua = new HBox();
        HBox hBoxKetiga = new HBox();

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setTitle("Selisih Waktu");

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Text titleSelisihWaktu = new Text("Selisih Waktu");
        titleSelisihWaktu.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        gridPane.add(titleSelisihWaktu, 0, 0, 4, 1);

        Label labelWaktu = new Label("Waktu");
        gridPane.add(labelWaktu, 0, 3);
        labelWaktu.setFont(Font.font("Arial", FontWeight.BOLD, 12.5));

        Label labelWaktuPertama = new Label("Waktu 1");
        TextField textFieldWaktuPertama = new TextField();
        gridPane.add(labelWaktuPertama, 0, 4);
        gridPane.add(textFieldWaktuPertama, 1, 4);
        textFieldWaktuPertama.setMaxWidth(45);
        gridPane.add(hBoxPertama, 0, 4);
        hBoxPertama.setSpacing(24);
        hBoxPertama.getChildren().addAll(labelWaktuPertama, textFieldWaktuPertama);

        Label labelWaktuKedua = new Label("Waktu 2");
        TextField textFieldWaktuKedua = new TextField();
        gridPane.add(labelWaktuKedua, 0, 5);
        gridPane.add(textFieldWaktuKedua, 1, 5);
        textFieldWaktuKedua.setMaxWidth(45);
        gridPane.add(hBoxKedua, 0, 5);
        hBoxKedua.setSpacing(24);
        hBoxKedua.getChildren().addAll(labelWaktuKedua, textFieldWaktuKedua);

        Button buttonHitung = new Button("Hitung");
        gridPane.add(buttonHitung, 0, 6);
        buttonHitung.setMaxWidth(115);

        Label labelHasil = new Label("Hasil");
        gridPane.add(labelHasil, 3, 3);
        labelHasil.setFont(Font.font("Arial", FontWeight.BOLD, 12.5));

        Label labelSelisihWaktu = new Label("Selisih");
        TextField textFieldSelisihWaktu = new TextField();
        gridPane.add(labelSelisihWaktu, 3, 5);
        gridPane.add(textFieldSelisihWaktu, 4, 5);
        textFieldSelisihWaktu.setMaxWidth(45);
        gridPane.add(hBoxKetiga, 3, 5);
        hBoxKetiga.setSpacing(34);
        hBoxKetiga.getChildren().addAll(labelSelisihWaktu, textFieldSelisihWaktu);

        Button buttonSelesai = new Button("Selesai");
        gridPane.add(buttonSelesai, 3, 6);
        buttonSelesai.setMaxWidth(115);

        Label labelIdentitas = new Label("72210512\nPutu Jeevallucas Jnanamaitriya Surya Gautama");
        gridPane.add(labelIdentitas, 0, 9, 4, 1);

        buttonHitung.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                waktu.setWaktuPertama(textFieldWaktuPertama.getText());
                waktu.setWaktuKedua(textFieldWaktuKedua.getText());

                textFieldSelisihWaktu.setText(waktu.selisihWaktu());

                textFieldWaktuPertama.requestFocus();
            }
        });

        buttonSelesai.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }

}
