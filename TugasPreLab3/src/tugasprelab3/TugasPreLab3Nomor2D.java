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

public class TugasPreLab3Nomor2D extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    final Text title = new Text("Urutan Hari (1 - 7)\nmenjadi Nama Hari");
        
    final Label inputUrutanHari = new Label("Urutan hari");
    final TextField fieldInputUrutanHari = new TextField();
        
    final Label outputHari = new Label("Hari");
    final TextField areaOutputHari = new TextField();
        
    final Button buttonTentukan = new Button("Tentukan");
    final Button buttonSelesai = new Button("Selesai");

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Urutan Hari (1 - 7) menjadi Nama Hari");
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        gridPane.add(title, 0, 0, 2, 1);
        gridPane.add(inputUrutanHari, 0, 1);
        gridPane.add(fieldInputUrutanHari, 1, 1);
        
        gridPane.add(buttonTentukan, 0, 3);
        gridPane.add(buttonSelesai, 1, 3);
        
        fieldInputUrutanHari.setMaxWidth(30);
        
        areaOutputHari.setMaxHeight(1);
        areaOutputHari.setMaxWidth(80);
        
        buttonTentukan.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                int hari_ke = Integer.parseInt(fieldInputUrutanHari.getText());
                String namaHari = "Tidak ada :)";
                
                switch(hari_ke) {
                    case 1:
                        namaHari = "Minggu";
                        break;
                    case 2:
                        namaHari = "Senin";
                        break;
                    case 3:
                        namaHari = "Selasa";
                        break;
                    case 4:
                        namaHari = "Rabu";
                        break;
                    case 5:
                        namaHari = "Kamis";
                        break;
                    case 6:
                        namaHari = "Jumat";
                        break;
                    case 7:
                        namaHari = "Sabtu";
                        break;
                }
                
                areaOutputHari.setText(String.valueOf(namaHari));
                
                gridPane.add(outputHari, 0, 2);
                gridPane.add(areaOutputHari, 1, 2);
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