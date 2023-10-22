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

public class TugasPreLab3Nomor2A extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    final Text title = new Text("Bilangan\nGenap atau Ganjil tanpa Else");
        
    final Label inputBilangan = new Label("Bilangan");
    final TextField fieldInputBilangan = new TextField();
        
    final Label outputBilangan = new Label("Jenis Bilangan");
    final TextField areaOutputBilangan = new TextField();
        
    final Button buttonTentukan = new Button("Tentukan");
    final Button buttonSelesai = new Button("Selesai");
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Bilangan Genap atau Ganjil tanpa Else");
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        gridPane.add(title, 0, 0, 2, 1);
        gridPane.add(inputBilangan, 0, 1);
        gridPane.add(fieldInputBilangan, 1, 1);
        
        gridPane.add(buttonTentukan, 0, 3);
        gridPane.add(buttonSelesai, 1, 3);
        
        fieldInputBilangan.setMaxWidth(125);
        areaOutputBilangan.setMaxWidth(55);
        
        buttonTentukan.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String jenis = "Genap";
                
                int bil = Integer.parseInt(fieldInputBilangan.getText());
                
                if(bil % 2 == 1) {
                    jenis = "Ganjil";
                }
                
                areaOutputBilangan.setText(String.valueOf(jenis));
                
                gridPane.add(outputBilangan, 0, 2);
                gridPane.add(areaOutputBilangan, 1, 2);
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
