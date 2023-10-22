package praktikum_06_72210512;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Praktikum_06_72210512 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    Text txtJudul = new Text("Pengurutan Metode Selection Sort");
    
    Label lblINT = new Label("Data INT");
    TextField txtINT = new TextField();
    
    Label lblElemenTersedia = new Label("Elemen Tersedia");
    TextField txtElemenTersedia = new TextField();
    
    Label lblElemenTerisi = new Label("Elemen Terisi");
    TextField txtElemenTerisi = new TextField();
    
    TextArea txtArea = new TextArea();
    
    Button btnTambah = new Button("Masukkan");
    
    Label lblIsiArray = new Label("Array");
    TextField txtIsiArray = new TextField();
    
    Button btnProses = new Button("Selection Sort");
    Button btnTutup = new Button("Tutup");
    Button btnClear = new Button("Clear");
    
    HBox hb1 = new HBox();
    
    Text txtIdentitas = new Text("72210512\nPutu Jeevallucas Jnanamaitriya Surya Gautama");
    Text txtTanggal = new Text("Yogyakarta, 18 April 2022");
    
    Text txtInput = new Text("Input");
    Text txtData = new Text("Data");
    Text txtOutput = new Text("Output");

    @Override
    public void start(Stage primaryStage) throws Exception {
        Larik lrk = new Larik(8);
        
        txtJudul.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        hb1.getChildren().add(btnTutup);
        hb1.setAlignment(Pos.BOTTOM_RIGHT);
        
        txtINT.setMaxWidth(90);
        txtArea.setMinHeight(190);
        
        txtArea.setEditable(false);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(3);
        grid.setHgap(10);
        grid.setGridLinesVisible(false);
        
        grid.add(txtJudul, 0, 0, 2, 1);
        
        grid.add(txtInput, 0, 5);
        txtInput.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        
        grid.add(lblINT, 0, 6);
        grid.add(txtINT, 1, 6);
        
        grid.add(lblElemenTersedia, 0, 7);
        grid.add(txtElemenTersedia, 1, 7);
        txtElemenTersedia.setMaxWidth(90);
        
        grid.add(btnTambah, 0, 8, 2, 1);
        btnTambah.setMaxWidth(187);
        
        grid.add(txtData, 0, 13);
        txtData.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        
        grid.add(lblElemenTerisi, 0, 14);
        grid.add(txtElemenTerisi, 1, 14);
        txtElemenTerisi.setMaxWidth(90);
        
        grid.add(lblIsiArray, 0, 15);
        grid.add(txtIsiArray, 1, 15);
        
        grid.add(btnProses, 0, 16, 2, 1);
        btnProses.setMaxWidth(90);
        
        grid.add(btnClear, 1, 16, 2, 1);
        btnClear.setMaxWidth(90);
        
        grid.add(txtOutput, 0, 21);
        txtOutput.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        
        grid.add(txtArea, 0, 22, 2, 1);
        
        grid.add(hb1, 0, 23, 2, 1);
        
        Scene scene = new Scene(grid, 700, 650);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Selection Sort");
        primaryStage.show();
        
        txtElemenTersedia.setText(String.valueOf(lrk.getMaxElement()));
        
        grid.add(txtIdentitas, 0, 24, 2, 1);
        txtIdentitas.setFont(Font.font("Arial", 12));
        
        grid.add(txtTanggal, 0, 29, 2, 1);
        txtTanggal.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        
        btnTambah.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int data = Integer.parseInt(txtINT.getText());
                lrk.addData(data);
                
                txtINT.setText("");
                txtINT.requestFocus();
                
                txtElemenTerisi.setText(String.valueOf(lrk.getByk()));
                txtIsiArray.setText(lrk.getData());
            }
        });
        
        btnProses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lrk.SelectionSort();
                txtArea.setText(String.valueOf(lrk.getProses()));
            }
        });
        
        btnTutup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtElemenTerisi.setText("");
                txtIsiArray.setText("");
                txtArea.setText("");
                
                txtINT.requestFocus();
            }
        });
    }
}