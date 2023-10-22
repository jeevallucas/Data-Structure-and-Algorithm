package tugasprelab4;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class soalNomorTiga extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Statistik statistik = new Statistik(99999999);

        primaryStage.setTitle("Perhitungan Statistik");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Perhitungan Statistik");
        sceneTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        gridPane.add(sceneTitle, 0, 0, 2, 1);

        Label labelData = new Label("Data");
        TextField fieldData = new TextField();
        gridPane.add(labelData, 0, 1);
        gridPane.add(fieldData, 1, 1);

        Button buttonProses = new Button("Proses");
        gridPane.add(buttonProses, 2, 1);

        Label labelHasilPerhitungan = new Label("Hasil Perhitungan");

        Label labelSemuaData = new Label("Semua Data");
        TextField fieldSemuaData = new TextField();

        Label labelBanyakData = new Label("Banyak Data");
        TextField fieldBanyakData = new TextField();

        Label labelJumlah = new Label("Jumlah");
        TextField fieldJumlah = new TextField();

        Label labelRataRata = new Label("Rata-Rata");
        TextField fieldRataRata = new TextField();

        Label labelMinimum = new Label("Minimum");
        TextField fieldMinimum = new TextField();

        Label labelMaksimum = new Label("Maksimum");
        TextField fieldMaksimum = new TextField();

        Label labelNIM = new Label("72210512");
        Label labelNama = new Label("Putu Jeevallucas Jnanamaitriya Surya Gautama");
        gridPane.add(labelNIM, 4, 11);
        gridPane.add(labelNama, 4, 12);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        buttonProses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double data = Double.parseDouble(fieldData.getText());
                statistik.addData(data);

                fieldSemuaData.setText(String.valueOf(statistik.ambilData()));
                fieldRataRata.setText(String.valueOf(statistik.avg()));
                fieldJumlah.setText(String.valueOf(statistik.sum()));
                fieldBanyakData.setText(String.valueOf(statistik.banyakData()));
                fieldMaksimum.setText(String.valueOf(statistik.maksimum()));
                fieldMinimum.setText(String.valueOf(statistik.minimum()));

                fieldData.setText("");
                fieldData.requestFocus();

                gridPane.add(labelHasilPerhitungan, 0, 4);
                labelHasilPerhitungan.setFont(Font.font("Arial", FontWeight.BOLD, 15));

                gridPane.add(labelSemuaData, 0, 5);
                gridPane.add(fieldSemuaData, 1, 5);

                gridPane.add(labelBanyakData, 0, 6);
                gridPane.add(fieldBanyakData, 1, 6);

                gridPane.add(labelJumlah, 0, 7);
                gridPane.add(fieldJumlah, 1, 7);

                gridPane.add(labelRataRata, 0, 8);
                gridPane.add(fieldRataRata, 1, 8);

                gridPane.add(labelMinimum, 2, 7);
                gridPane.add(fieldMinimum, 3, 7);

                gridPane.add(labelMaksimum, 2, 8);
                gridPane.add(fieldMaksimum, 3, 8);
            }
        });
    }
}
