package tugasprelab3;

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

public class TugasPreLab3Nomor3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    final Text sceneTitle = new Text("Konversi\nSistem Bilangan");
    
    final Label bilanganDesimal = new Label("Bilangan");
    final TextField fieldBilanganDesimal = new TextField();
    
    final Label konversiKe = new Label("Konversi");
    final ComboBox comboBoxKonversiKe = new ComboBox();
    
    final Label hasilKonversi = new Label("Hasil");
    final TextField fieldHasilKonversi = new TextField();
    
    final Button konversi = new Button("Konversi");
    final Button close = new Button("Selesai");

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Konversi Sistem Bilangan");
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        sceneTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        gridPane.add(sceneTitle, 0, 0, 2, 1);
        
        gridPane.add(bilanganDesimal, 0, 1);
        gridPane.add(fieldBilanganDesimal, 1, 1);
        
        gridPane.add(konversiKe, 0, 2);
        gridPane.add(comboBoxKonversiKe, 1, 2);
        
        gridPane.add(konversi, 0, 4);
        gridPane.add(close, 1, 4);
        
        fieldBilanganDesimal.setMaxWidth(152);
        
        comboBoxKonversiKe.getItems().addAll("Binary", "Octal", "Hexadecimal");
        comboBoxKonversiKe.setValue("Pilih Sistem Bilangan");
        
        konversi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                int desimal = Integer.parseInt(fieldBilanganDesimal.getText());
                
                if(comboBoxKonversiKe.getValue() == "Binary") {
                    String binary = Integer.toBinaryString(desimal);
                    fieldHasilKonversi.setText(String.valueOf(binary));
                }
                
                else if(comboBoxKonversiKe.getValue() == "Octal") {
                    String octal = Integer.toOctalString(desimal);
                    fieldHasilKonversi.setText(String.valueOf(octal));
                }
                
                else if(comboBoxKonversiKe.getValue() == "Hexadecimal") {
                    String hexadecimal = Integer.toHexString(desimal);
                    fieldHasilKonversi.setText(String.valueOf(hexadecimal));
                }
                
                gridPane.add(hasilKonversi, 0, 3);
                gridPane.add(fieldHasilKonversi, 1, 3);
                
                fieldHasilKonversi.setMaxWidth(152);
            }
        });
        
        Label NIM = new Label("NIM: ");
        gridPane.add(NIM, 2, 6);
        
        Label isiNIM = new Label("72210512");
        gridPane.add(isiNIM, 3, 6);
        
        Label nama = new Label("Nama: ");
        gridPane.add(nama, 2, 7);
        
        Label isiNama = new Label("Putu Jeevallucas Jnanamaitriya Surya Gautama");
        gridPane.add(isiNama, 3, 7);
        
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
