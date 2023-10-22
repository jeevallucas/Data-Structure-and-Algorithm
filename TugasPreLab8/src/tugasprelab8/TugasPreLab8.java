package tugasprelab8;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class TugasPreLab8 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    Text txtJudul = new Text("DATA MAHASISWA");
    
    Label lblNIM = new Label("NIM");
    Label lblNama = new Label("Nama");
    Label lblKota = new Label("Kota");
    Label lblGrup = new Label("Grup");
    
    Label lblKetNIM = new Label("(diisi oleh sistem)");
    Label lblKetGrup = new Label("(diisi oleh sistem)");
    
    Label lblSpasi1 = new Label("                  ");
    Label lblSpasi2 = new Label("                                                               ");
    
    TextField txtNIM = new TextField();
    TextField txtNama = new TextField();
    TextField txtKota = new TextField();
    TextField txtGrup = new TextField();
    
    Button btnTop = new Button("|<");
    Button btnBack = new Button("<");
    Button btnNext = new Button(">");
    Button btnEnd = new Button(">|");
    
    Button btnNew = new Button("New");
    Button btnEdit = new Button("Edit");
    Button btnSave = new Button("Save");
    Button btnUndo = new Button("Undo");
    Button btnDel = new Button("Delete");
    Button btnClose = new Button("Close");
    
    Text txtInputData = new Text("Input Data");
    
    Text txtIdentitas = new Text("72210512\nPutu Jeevallucas Jnanamaitriya Surya Gautama");
    
    HBox hb1 = new HBox();
    HBox hb2 = new HBox();
    
    boolean baru = true;
    
    void buka() {
        txtNama.setEditable(true);
        txtNama.setDisable(false);
        txtKota.setEditable(true);
        txtKota.setDisable(false);
        
        btnTop.setDisable(true);
        btnBack.setDisable(true);
        btnNext.setDisable(true);
        btnEnd.setDisable(true);
        btnNew.setDisable(true);
        btnEdit.setDisable(true);
        btnSave.setDisable(false);
        btnUndo.setDisable(false);
        
        txtNama.requestFocus();
    }
    
    void tutup() {
        txtNama.setEditable(false);
        txtNama.setDisable(true);
        txtKota.setEditable(false);
        txtKota.setDisable(true);
        
        btnTop.setDisable(false);
        btnBack.setDisable(false);
        btnNext.setDisable(false);
        btnEnd.setDisable(false);
        btnNew.setDisable(false);
        btnEdit.setDisable(false);
        btnDel.setDisable(false);
        btnSave.setDisable(true);
        btnUndo.setDisable(true);
    }
    
    Tabel dafMhs = new Tabel(15);
    
    void tampil() {
        Mahasiswa mhs = dafMhs.bacaMhs();
        
        txtNIM.setText(mhs.nim);
        txtNama.setText(mhs.nama);
        txtKota.setText(mhs.kota);
        txtGrup.setText(mhs.grup);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        txtJudul.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        txtNIM.setMaxWidth(300);
        txtNIM.setEditable(false);
        
        txtNama.setMinWidth(300);
        
        txtKota.setMaxWidth(300);
        
        txtGrup.setMaxWidth(300);
        txtGrup.setEditable(false);
        
        hb1.getChildren().addAll(btnNew, btnSave, btnEdit, btnUndo, lblSpasi1, btnDel);
        lblKetNIM.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 10));
        hb1.setSpacing(5);
        
        lblKetGrup.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 10));
        
        hb2.getChildren().addAll(btnTop, btnBack, btnNext, btnEnd, lblSpasi2, btnClose);
        hb2.setSpacing(5);
        
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 400, 200);
        
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(10);
        
        grid.add(txtJudul, 0, 0, 2, 1);
        
        grid.add(txtInputData, 0, 5);
        txtInputData.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        
        grid.add(hb1, 1, 5, 2, 1);
        
        grid.add(lblNIM, 0, 6);
        grid.add(txtNIM, 1, 6);
        grid.add(lblKetNIM, 2, 6);
        
        grid.add(lblGrup, 0, 7);
        grid.add(txtGrup, 1, 7);
        grid.add(lblKetGrup, 2, 7);
        
        grid.add(lblNama, 0, 10);
        grid.add(txtNama, 1, 10);
        
        grid.add(lblKota, 0, 11);
        grid.add(txtKota, 1, 11);
        
        grid.add(hb2, 0, 12, 2, 1);
        
        grid.add(txtIdentitas, 0, 17, 2, 1);
        txtIdentitas.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Data Mahasiswa");
        primaryStage.show();
        
        btnSave.setDisable(true);
        btnEdit.setDisable(true);
        btnUndo.setDisable(true);
        btnDel.setDisable(true);
        
        txtNIM.setDisable(true);
        txtGrup.setDisable(true);
        txtNama.setDisable(true);
        txtKota.setDisable(true);
        
        btnNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                baru = true;
                buka();
                
                txtNIM.setText("");
                txtNama.setText("");
                txtKota.setText("");
                txtGrup.setText("");
            }
        });
        
        btnEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                baru = false;
                buka();
            }
        });
        
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nim, nama, kota, grup;
                
                nim = txtNIM.getText();
                nama = txtNama.getText();
                kota = txtKota.getText();
                grup = txtGrup.getText();
                
                Mahasiswa mhs = new Mahasiswa(nim, nama, kota, grup);
                
                if(baru)
                    dafMhs.tambahMhs(mhs);
                else
                    dafMhs.ubahMhs(mhs);
                
                tutup();
                tampil();
                
                try {
                    dafMhs.saveToFile();
                } catch (IOException ex) {
                    Logger.getLogger(TugasPreLab8.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnUndo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tampil();
                tutup();
            }
        });
        
        btnTop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dafMhs.moveFirst();
                tampil();
            }
        });
        
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dafMhs.movePrevious();
                tampil();
            }
        });
        
        btnNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dafMhs.moveNext();
                tampil();
            }
        });
        
        btnEnd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dafMhs.moveLast();
                tampil();
            }
        });
        
        btnDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dafMhs.hapusMhs();
                tampil();
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