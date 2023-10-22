package praktikum_02_72210512;

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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Statistik extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    String data = "";
    int cacah = 0, byk_ganjil = 0, byk_genap = 0;
    double jum = 0, max = Double.MAX_VALUE, min = Double.MIN_VALUE;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Perhitungan Statistik");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 5, 5, 5));

        Text title = new Text("Perhitungan Statistik");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        title.setFill(Color.DARKGOLDENROD);
        grid.add(title, 0, 0, 3, 1);

        Label labelData = new Label("Masukan Data");
        grid.add(labelData, 0, 1);
        TextField txtData = new TextField();
        grid.add(txtData, 1, 1);
        txtData.setMaxWidth(100);

        Label title2 = new Label("Hasil Perhitungan");
        grid.add(title2, 0, 3, 6, 1);
        title2.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        Label allData = new Label("Semua Data");
        grid.add(allData, 0, 4, 6, 1);
        TextField txtAll = new TextField();
        grid.add(txtAll, 1, 4, 5, 1);
        txtAll.disableProperty();
        txtAll.setMaxWidth(215);

        Label labelByk = new Label("Banyak Data");
        grid.add(labelByk, 0, 5, 6, 1);
        TextField txtByk = new TextField();
        grid.add(txtByk, 1, 5);
        txtByk.setMaxWidth(80);

        Label labelJum = new Label("Jumlah");
        grid.add(labelJum, 0, 6, 6, 1);
        TextField txtJum = new TextField();
        grid.add(txtJum, 1, 6);
        txtJum.setMaxWidth(80);

        Label labelAvg = new Label("Rata Rata");
        grid.add(labelAvg, 0, 7, 6, 1);
        TextField txtAvg = new TextField();
        grid.add(txtAvg, 1, 7);
        txtAvg.setMaxWidth(80);

        Label labelKecil = new Label("Terkecil");
        grid.add(labelKecil, 0, 8, 6, 1);
        TextField txtKecil = new TextField();
        grid.add(txtKecil, 1, 8);
        txtKecil.setMaxWidth(80);

        Label labelBesar = new Label("Terbesar");
        grid.add(labelBesar, 0, 9, 6, 1);
        TextField txtBesar = new TextField();
        grid.add(txtBesar, 1, 9);
        txtBesar.setMaxWidth(80);

        Label labelGenap = new Label("Genap");
        grid.add(labelGenap, 0, 10, 6, 1);
        TextField txtGenap = new TextField();
        grid.add(txtGenap, 1, 10);
        txtGenap.setMaxWidth(80);

        Label labelGanjil = new Label("Ganjil");
        grid.add(labelGanjil, 0, 11, 6, 1);
        TextField txtGanjil = new TextField();
        grid.add(txtGanjil, 1, 11);
        txtGanjil.setMaxWidth(80);

        PerhitunganStatistik s = new PerhitunganStatistik(99999999);
        Button btnProses = new Button("Proses");
        grid.add(btnProses, 0, 12, 6, 1);
        btnProses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int nilai = Integer.parseInt(txtData.getText());
                s.addData(nilai);
                if (nilai % 2 == 0) {
                    byk_genap++;
                } else {
                    byk_ganjil++;
                }

                txtAll.setText(String.valueOf(s.ambilData()));
                txtJum.setText(String.valueOf((int) s.sum()));
                txtGenap.setText(String.valueOf(byk_genap));
                txtGanjil.setText(String.valueOf(byk_ganjil));
                txtAvg.setText(String.valueOf(s.avg()));
                txtByk.setText(String.valueOf(s.banyakData()));
                txtBesar.setText(String.valueOf(s.maksimum()));
                txtKecil.setText(String.valueOf(s.minimum()));

                txtData.requestFocus();
                txtData.setText("");
            }
        });

        Button btnClose = new Button("Selesai");
        grid.add(btnClose, 1, 12, 6, 1);
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        Scene scene = new Scene(grid, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        Text nama = new Text("72210512\nPutu Jeevallucas Jnanamaitriya Surya Gautama");
        nama.setFont(Font.font("Arial", FontWeight.BOLD, 12.5));
        nama.setFill(Color.YELLOWGREEN);
        grid.add(nama, 0, 16, 6, 1);
    }

}
