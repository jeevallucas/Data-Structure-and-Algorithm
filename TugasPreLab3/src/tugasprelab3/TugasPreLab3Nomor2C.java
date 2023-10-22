package tugasprelab3;

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

public class TugasPreLab3Nomor2C extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    final Text title = new Text("Golongan\nberdasarkan Usia");
        
    final Label inputUsia = new Label("Usia");
    final TextField fieldInputUsia = new TextField();
        
    final Label outputGolongan = new Label("Golongan");
    final TextField areaOutputGolongan = new TextField();
        
    final Button buttonTentukan = new Button("Tentukan");
    final Button buttonSelesai = new Button("Selesai");

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Golongan berdasarkan Usia");
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        gridPane.add(title, 0, 0, 2, 1);
        gridPane.add(inputUsia, 0, 1);
        gridPane.add(fieldInputUsia, 1, 1);
        
        gridPane.add(buttonTentukan, 0, 3);
        gridPane.add(buttonSelesai, 1, 3);
        
        fieldInputUsia.setMaxWidth(35);
        areaOutputGolongan.setMaxWidth(140);
        
        buttonTentukan.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                int usia = Integer.parseInt(fieldInputUsia.getText());
                
                if(usia < 10) {
                    areaOutputGolongan.setText(String.valueOf("Anda masih anak-anak"));
                }
                
                else if(usia < 17) {
                    areaOutputGolongan.setText(String.valueOf("Anda sudah remaja"));
                }
                
                else if(usia < 25) {
                    areaOutputGolongan.setText(String.valueOf("Anda sudah pemuda"));
                }
                
                else if(usia < 50) {
                    areaOutputGolongan.setText(String.valueOf("Anda sudah dewasa"));
                }
                
                else {
                    areaOutputGolongan.setText(String.valueOf("Anda sudah usia lanjut"));
                }
                
                gridPane.add(outputGolongan, 0, 2);
                gridPane.add(areaOutputGolongan, 1, 2);
            }
        });
        
        buttonSelesai.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                System.exit(0);
            }
        });
        
        Label NIM = new Label("NIM: ");
        gridPane.add(NIM, 2, 4);
        
        Label isiNIM = new Label("72210512");
        gridPane.add(isiNIM, 3, 4);
        
        Label nama = new Label("Nama: ");
        gridPane.add(nama, 2, 5);
        
        Label isiNama = new Label("Putu Jeevallucas Jnanamaitriya Surya Gautama");
        gridPane.add(isiNama, 3, 5);
        
        Scene scene = new Scene(gridPane, 400, 300);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}