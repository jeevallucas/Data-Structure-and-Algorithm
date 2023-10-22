package praktikum_04_72210512;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Praktikum_04_72210512 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Text txtJudul = new Text("Data Mahasiswa");

    Label lblNIM = new Label("NIM");
    TextField txtNIM = new TextField();

    Label lblNama = new Label("Nama");
    TextField txtNama = new TextField();

    Label lblKota = new Label("Kota");
    TextField txtKota = new TextField();

    Label lblSemua = new Label("Daftar Mahasiswa");
    TextArea txtDaftar = new TextArea();

    Button btnTambah = new Button("Tambah");

    Label lblUrut = new Label("Urut");
    ComboBox cbUrut = new ComboBox();

    Label lblOrder = new Label("Jenis");
    ComboBox cbOrder = new ComboBox();

    Button btnProses = new Button("Proses");
    Button btnTutup = new Button("Hapus");
    Button btnHapus = new Button("Tutup");

    HBox hb1 = new HBox();
    HBox hb2 = new HBox();
    HBox hb3 = new HBox();

    Label lblIdentitas = new Label("72210512\nPutu Jeevallucas Jnanamaitriya Surya Gautama");

    @Override
    public void start(Stage primaryStage) throws Exception {
        txtJudul.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        lblSemua.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        hb1.getChildren().add(btnTambah);
        hb1.setAlignment(Pos.BASELINE_RIGHT);

        hb2.getChildren().add(btnTutup);
        hb2.setAlignment(Pos.BOTTOM_RIGHT);

        hb3.getChildren().add(btnHapus);
        hb3.setAlignment(Pos.BOTTOM_CENTER);

        txtNIM.setMaxWidth(80);
        txtKota.setMaxWidth(200);
        txtDaftar.setMinHeight(250);

        cbUrut.getItems().addAll("NIM", "Nama", "Kota");
        cbUrut.setValue("Pilih Urutan");

        cbOrder.getItems().addAll("Ascending", "Descending");
        cbOrder.setValue("Pilih Jenis");

        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 500, 600);

        grid.setAlignment(Pos.CENTER);
        grid.setVgap(3);
        grid.setHgap(10);
        grid.setGridLinesVisible(false);

        grid.add(txtJudul, 0, 0, 2, 1);

        grid.add(lblNIM, 0, 1);
        grid.add(txtNIM, 1, 1);

        grid.add(lblNama, 0, 2);
        grid.add(txtNama, 1, 2);

        grid.add(lblKota, 0, 3);
        grid.add(txtKota, 1, 3);

        grid.add(hb1, 1, 4);

        grid.add(lblUrut, 0, 5);
        grid.add(cbUrut, 1, 5);
        cbUrut.setMaxWidth(109);

        grid.add(lblOrder, 0, 6);
        grid.add(cbOrder, 1, 6);

        grid.add(btnProses, 0, 7, 2, 1);
        btnProses.setMaxWidth(151);

        grid.add(lblSemua, 0, 16, 2, 1);
        grid.add(txtDaftar, 0, 17, 2, 1);

        grid.add(hb2, 0, 18, 2, 1);
        grid.add(hb3, 2, 18, 2, 1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Data Mahasiswa");
        primaryStage.show();

        grid.add(lblIdentitas, 0, 18, 2, 1);
        lblIdentitas.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        DaftarMahasiswa daftarMahasiswa = new DaftarMahasiswa(100);

        btnTambah.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                daftarMahasiswa.tambahMahasiswa(txtNIM.getText(), txtNama.getText(), txtKota.getText());
                txtDaftar.setText(daftarMahasiswa.getAllMahasiswa());

                txtNIM.requestFocus();
                txtNIM.setText("");
                txtNama.setText("");
                txtKota.setText("");
            }
        });

        btnProses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String urut = String.valueOf(cbUrut.getValue());
                String order = String.valueOf(cbOrder.getValue());

                if (urut.equals("NIM")) {
                    daftarMahasiswa.bubbleNIM(urut);

                    if (order.equals("Ascending")) {
                        daftarMahasiswa.bubbleNIM(order);
                    } else if (order.equals("Descending")) {
                        daftarMahasiswa.bubbleNIM(order);
                    }
                }

                if (urut.equals("Nama")) {
                    daftarMahasiswa.bubbleNama(urut);

                    if (order.equals("Ascending")) {
                        daftarMahasiswa.bubbleNama(order);
                    } else if (order.equals("Descending")) {
                        daftarMahasiswa.bubbleNama(order);
                    }
                }

                if (urut.equals("Kota")) {
                    daftarMahasiswa.bubbleKota(urut);

                    if (order.equals("Ascending")) {
                        daftarMahasiswa.bubbleKota(order);
                    } else if (order.equals("Descending")) {
                        daftarMahasiswa.bubbleKota(order);
                    }
                }

                txtDaftar.setText(daftarMahasiswa.getAllMahasiswa());
            }
        });

        btnTutup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                daftarMahasiswa.hapusMahasiswa();
                txtDaftar.setText(daftarMahasiswa.getAllMahasiswa());
                txtNIM.requestFocus();
            }
        });

        btnHapus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }

}
