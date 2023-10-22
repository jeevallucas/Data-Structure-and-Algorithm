package praktikum_01_72210512;

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

public class luasKelilingLingkaran extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Menghitung Luas dan Keliling Lingkaran");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneTitle = new Text("Menghitung Luas dan Keliling Lingkaran");
        sceneTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        Label radiusLabel = new Label("Radius");
        TextField txtRadius = new TextField();
        grid.add(radiusLabel, 0, 1);
        grid.add(txtRadius, 1, 1);
        
        Label luasLabel = new Label("Luas Lingkaran");
        TextField txtLuas = new TextField();
        grid.add(luasLabel, 0, 2);
        grid.add(txtLuas, 1, 2);
        
        Label kelilingLabel = new Label("Keliling Lingkaran");
        TextField txtKeliling = new TextField();
        grid.add(kelilingLabel, 0, 3);
        grid.add(txtKeliling, 1, 3);
        
        Button hitungBtn = new Button("Proses");
        grid.add(hitungBtn, 0, 4);
        
        hitungBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                double r = Double.parseDouble(txtRadius.getText());
                
                double luas = 3.14 * (r * r);
                double keliling = 2 * 3.14 * r;
                
                txtLuas.setText(String.valueOf(luas));
                txtKeliling.setText(String.valueOf(keliling));
            }
        });
        
        Button closeBtn = new Button("Close");
        grid.add(closeBtn, 1, 4);
        
        closeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                System.exit(0);
            }
        });
        
        Label NIM = new Label("NIM: ");
        grid.add(NIM, 0, 5);
        
        Label isiNIM = new Label("72210512");
        grid.add(isiNIM, 1, 5);
        
        Label nama = new Label("Nama: ");
        grid.add(nama, 0, 6);
        
        Label isiNama = new Label("Putu Jeevallucas Jnanamaitriya Surya Gautama");
        grid.add(isiNama, 1, 6);
        
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        
        launch(args);
    }
    
}