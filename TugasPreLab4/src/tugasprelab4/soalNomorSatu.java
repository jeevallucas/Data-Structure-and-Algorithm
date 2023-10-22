package tugasprelab4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class soalNomorSatu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Manipulasi String");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Manipulasi String");
        sceneTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        gridPane.add(sceneTitle, 0, 0, 2, 1);

        Label labelString = new Label("String");
        TextField fieldString = new TextField();
        gridPane.add(labelString, 0, 1);
        gridPane.add(fieldString, 1, 1);

        Label labelManipulasi = new Label("Manipulasi");
        ComboBox comboBoxManipulasi = new ComboBox();
        comboBoxManipulasi.getItems().addAll("Balik Kalimat", "Huruf Kapital", "Huruf Kecil");
        comboBoxManipulasi.setValue("Pilih Manipulasi");
        gridPane.add(labelManipulasi, 0, 2);
        gridPane.add(comboBoxManipulasi, 1, 2);
        comboBoxManipulasi.setMaxWidth(500);

        Label labelHasil = new Label("Hasil");
        TextField fieldHasil = new TextField();

        Button buttonProses = new Button("Proses");
        gridPane.add(buttonProses, 0, 4);

        Label labelNIM = new Label("72210512");
        Label labelNama = new Label("Putu Jeevallucas Jnanamaitriya Surya Gautama");
        gridPane.add(labelNIM, 2, 5);
        gridPane.add(labelNama, 2, 6);

        buttonProses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (comboBoxManipulasi.getValue() == "Balik Kalimat") {
                    String huruf, hasil = " ";
                    huruf = fieldString.getText();

                    int jumlah = huruf.length();
                    int jumlahHuruf = jumlah - 1;

                    for (int i = 0; i < jumlah; i++) {
                        hasil = hasil + huruf.charAt(jumlahHuruf);
                        jumlahHuruf--;
                    }

                    fieldHasil.setText(String.valueOf(hasil));
                } else if (comboBoxManipulasi.getValue() == "Huruf Kapital") {
                    String huruf;
                    huruf = fieldString.getText();
                    String str1 = huruf.toUpperCase();

                    fieldHasil.setText(String.valueOf(str1));
                } else if (comboBoxManipulasi.getValue() == "Huruf Kecil") {
                    String huruf;
                    huruf = fieldString.getText();
                    String str1 = huruf.toLowerCase();

                    fieldHasil.setText(String.valueOf(str1));
                }

                gridPane.add(labelHasil, 0, 3);
                gridPane.add(fieldHasil, 1, 3);

                fieldString.requestFocus();
            }
        });

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
