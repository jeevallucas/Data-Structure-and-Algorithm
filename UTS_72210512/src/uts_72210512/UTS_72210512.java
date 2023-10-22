package uts_72210512;

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

public class UTS_72210512 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text txtJudul = new Text("Data Buku");
        
        Label lblNomorKoleksi = new Label("Nomor Koleksi");
        TextField txtNomorKoleksi = new TextField();
        
        Label lblJudulBuku = new Label("Judul Buku");
        TextField txtJudulBuku = new TextField();
        
        Label lblPengarang = new Label("Pengarang");
        TextField txtPengarang = new TextField();
        
        Label lblSemua = new Label("Daftar Buku");
        TextArea txtDaftar = new TextArea();
        
        Button btnTambah = new Button("Tambah");
        
        Label lblUrut = new Label("Urut");
        ComboBox cbUrut = new ComboBox();
        
        Label lblOrder = new Label("Jenis");
        ComboBox cbOrder = new ComboBox();
        
        Button btnProses = new Button("Proses");
        Button btnHapus = new Button("Hapus");
        Button btnTutup = new Button("Tutup");
        
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        
        Label lblIdentitas = new Label("72210512\nPutu Jeevallucas Jnanamaitriya Surya Gautama");
        
        txtJudul.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        lblSemua.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        
        hb1.getChildren().add(btnTambah);
        hb1.setAlignment(Pos.BASELINE_RIGHT);

        hb2.getChildren().add(btnHapus);
        hb2.setAlignment(Pos.BOTTOM_RIGHT);

        hb3.getChildren().add(btnTutup);
        hb3.setAlignment(Pos.BOTTOM_CENTER);
        
        txtNomorKoleksi.setMaxWidth(80);
        txtPengarang.setMaxWidth(200);
        txtDaftar.setMinHeight(250);
        
        cbUrut.getItems().addAll("Nomor Koleksi", "Judul Buku", "Pengarang");
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
        
        grid.add(lblNomorKoleksi, 0, 1);
        grid.add(txtNomorKoleksi, 1, 1);

        grid.add(lblJudulBuku, 0, 2);
        grid.add(txtJudulBuku, 1, 2);

        grid.add(lblPengarang, 0, 3);
        grid.add(txtPengarang, 1, 3);
        
        grid.add(hb1, 1, 4);

        grid.add(lblUrut, 0, 5);
        grid.add(cbUrut, 1, 5);
        cbUrut.setMaxWidth(109);

        grid.add(lblOrder, 0, 6);
        grid.add(cbOrder, 1, 6);

        grid.add(btnProses, 0, 7, 2, 1);
        btnProses.setMaxWidth(198);

        grid.add(lblSemua, 0, 16, 2, 1);
        grid.add(txtDaftar, 0, 17, 2, 1);
        
        grid.add(hb2, 0, 18, 2, 1);
        grid.add(hb3, 2, 18, 2, 1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Data Buku");
        primaryStage.show();
        
        grid.add(lblIdentitas, 0, 18, 2, 1);
        lblIdentitas.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        
        DaftarBuku daftarBuku = new DaftarBuku(100);
        
        btnTambah.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                daftarBuku.tambahBuku(txtNomorKoleksi.getText(), txtJudulBuku.getText(), txtPengarang.getText());
                txtDaftar.setText(daftarBuku.getAllBuku());
                
                txtNomorKoleksi.requestFocus();
                txtNomorKoleksi.setText("");
                txtJudulBuku.setText("");
                txtPengarang.setText("");
            }
        });
        
        btnProses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String urut = String.valueOf(cbUrut.getValue());
                String order = String.valueOf(cbOrder.getValue());

                if (urut.equals("Nomor Koleksi")) {
                    daftarBuku.bubbleNomorKoleksi(urut);

                    if (order.equals("Ascending")) {
                        daftarBuku.bubbleNomorKoleksi(order);
                    } else if (order.equals("Descending")) {
                        daftarBuku.bubbleNomorKoleksi(order);
                    }
                }

                if (urut.equals("Judul Buku")) {
                    daftarBuku.bubbleJudulBuku(urut);

                    if (order.equals("Ascending")) {
                        daftarBuku.bubbleJudulBuku(order);
                    } else if (order.equals("Descending")) {
                        daftarBuku.bubbleJudulBuku(order);
                    }
                }

                if (urut.equals("Pengarang")) {
                    daftarBuku.bubblePengarang(urut);

                    if (order.equals("Ascending")) {
                        daftarBuku.bubblePengarang(order);
                    } else if (order.equals("Descending")) {
                        daftarBuku.bubblePengarang(order);
                    }
                }

                txtDaftar.setText(daftarBuku.getAllBuku());
            }
        });
        
        btnHapus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                daftarBuku.hapusBuku();
                txtDaftar.setText(daftarBuku.getAllBuku());
                txtNomorKoleksi.requestFocus();
            }
        });
        
        btnTutup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                daftarBuku.saveFile();
                System.exit(0);
            }
        });
    }
    
}
