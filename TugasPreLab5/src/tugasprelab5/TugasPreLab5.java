package tugasprelab5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TugasPreLab5 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 500, 450);
        
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Nama Teman Kuliah");
        primaryStage.show();
        
        Text judul = new Text("Nama Teman Kuliah");
        judul.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        Label lblNama = new Label("Nama");
        TextField txtNama = new TextField();
        
        TextArea txtHasil = new TextArea();
        
        Text langkahLangkah = new Text("Langkah-Langkah");
        TextArea txtLangkahLangkah = new TextArea();
        
        Button btnTambah = new Button("Tambah");
        Button btnProses = new Button("Mulai Mengurutkan");
        Button btnHapus = new Button("Hapus");
        Button btnClose = new Button("Selesai");
        
        ComboBox comboBoxUrut = new ComboBox();
        
        Text nim = new Text("72210512");
        Text nama = new Text("Putu Jeevallucas Jnanamaitriya Surya Gautama");
        
        gridPane.add(judul, 0, 0, 2, 1);
        gridPane.add(lblNama, 0, 1);
        gridPane.add(txtNama, 1, 1, 2, 1);
        gridPane.add(btnTambah, 1, 2);
        gridPane.add(btnHapus, 1, 4);
        gridPane.add(btnProses, 0, 4);
        gridPane.add(btnClose, 2, 4);
        gridPane.add(comboBoxUrut, 0, 2);
        gridPane.add(txtHasil, 0, 3, 3, 1);
        gridPane.add(langkahLangkah, 4, 2);
        gridPane.add(txtLangkahLangkah, 4, 3);
        gridPane.add(nim, 5, 5);
        gridPane.add(nama, 5, 6);
        
        langkahLangkah.setFont(Font.font("Arial", FontWeight.BOLD, 12.5));
        
        txtHasil.setMinHeight(300);
        txtLangkahLangkah.setMaxWidth(350);
        
        comboBoxUrut.getItems().addAll("Ascending", "Descending");
        comboBoxUrut.setValue("Pilih Urutan...");
        
        DaftarNama daftarNama = new DaftarNama(70);
        
        btnTambah.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nama = txtNama.getText(), d = String.valueOf(comboBoxUrut.getValue());
                
                daftarNama.tambahNama(nama);
                txtNama.setText("");
                txtHasil.setText(daftarNama.tampilNama());
                txtNama.requestFocus();
                
                txtLangkahLangkah.setText(daftarNama.langkahLangkah(d));
            }
        });
        
        btnProses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String d = String.valueOf(comboBoxUrut.getValue());
                
                if(d.equals("Ascending")) {
                    daftarNama.bubbleNama(d);
                }
                
                else if(d.equals(("Descending"))) {
                    daftarNama.bubbleNama(d);
                }
                
                txtHasil.setText(daftarNama.tampilNama());
                txtNama.requestFocus();
                
                txtLangkahLangkah.setText(daftarNama.langkahLangkah(d));
            }
        });
        
        btnHapus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                daftarNama.hapusNama();
                
                txtHasil.setText(daftarNama.tampilNama());
                txtNama.requestFocus();
                
                txtLangkahLangkah.setText("");
            }
        });
        
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }
    
}
