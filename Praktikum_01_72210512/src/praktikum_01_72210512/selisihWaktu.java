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
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class selisihWaktu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Menghitung Selisih Waktu");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneTitle = new Text("Menghitung Selisih Waktu");
        sceneTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        Label waktuSatuLabel = new Label("Waktu 1");
        TextField txtWaktuJamSatu = new TextField();
        txtWaktuJamSatu.setMaxWidth(30);
        TextField txtWaktuMenitSatu = new TextField();
        txtWaktuMenitSatu.setMaxWidth(30);
        TextField txtWaktuDetikSatu = new TextField();
        txtWaktuDetikSatu.setMaxWidth(30);
        grid.add(waktuSatuLabel, 0, 1);
        grid.add(txtWaktuJamSatu, 1, 1);
        grid.add(txtWaktuMenitSatu, 2, 1);
        grid.add(txtWaktuDetikSatu, 3, 1);
        
        HBox hb1 = new HBox();
        hb1.setSpacing(10);
        grid.add(hb1, 1, 1);
        hb1.getChildren().addAll(txtWaktuJamSatu, txtWaktuMenitSatu, txtWaktuDetikSatu);
        
        Label waktuDuaLabel = new Label("Waktu 2");
        TextField txtWaktuJamDua = new TextField();
        txtWaktuJamDua.setMaxWidth(30);
        TextField txtWaktuMenitDua = new TextField();
        txtWaktuMenitDua.setMaxWidth(30);
        TextField txtWaktuDetikDua = new TextField();
        txtWaktuDetikDua.setMaxWidth(30);
        grid.add(waktuDuaLabel, 0, 2);
        grid.add(txtWaktuJamDua, 1, 2);
        grid.add(txtWaktuMenitDua, 2, 2);
        grid.add(txtWaktuDetikDua, 3, 2);
        
        HBox hb2 = new HBox();
        hb2.setSpacing(10);
        grid.add(hb2, 1, 2);
        hb2.getChildren().addAll(txtWaktuJamDua, txtWaktuMenitDua, txtWaktuDetikDua);
        
        Label selisihWaktuLabel = new Label("Selisih Waktu");
        TextField txtSelisihWaktuJam = new TextField();
        txtSelisihWaktuJam.setMaxWidth(30);
        TextField txtSelisihWaktuMenit = new TextField();
        txtSelisihWaktuMenit.setMaxWidth(30);
        TextField txtSelisihWaktuDetik = new TextField();
        txtSelisihWaktuDetik.setMaxWidth(30);
        grid.add(selisihWaktuLabel, 0, 3);
        grid.add(txtSelisihWaktuJam, 1, 3);
        grid.add(txtSelisihWaktuMenit, 2, 3);
        grid.add(txtSelisihWaktuDetik, 3, 3);
        
        HBox hb3 = new HBox();
        hb3.setSpacing(10);
        grid.add(hb3, 1, 3);
        hb3.getChildren().addAll(txtSelisihWaktuJam, txtSelisihWaktuMenit, txtSelisihWaktuDetik);
        
        Button hitungBtn = new Button("Proses");
        grid.add(hitungBtn, 0, 4);
        
        hitungBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                int jamSatu = Integer.parseInt(txtWaktuJamSatu.getText());
                int menitSatu = Integer.parseInt(txtWaktuMenitSatu.getText());
                int detikSatu = Integer.parseInt(txtWaktuDetikSatu.getText());
                
                int jamDua = Integer.parseInt(txtWaktuJamDua.getText());
                int menitDua = Integer.parseInt(txtWaktuMenitDua.getText());
                int detikDua = Integer.parseInt(txtWaktuDetikDua.getText());
                
                int selisih = (jamDua - jamSatu) * 3600 + (menitDua - menitSatu) * 60 + (detikDua - detikSatu);
                
                int selisihJam = selisih / 3600;
                int selisihMenit = (selisih % 3600) / 60;
                int selisihDetik = (selisih % 3600) % 60;
                
                txtSelisihWaktuJam.setText(String.valueOf(selisihJam));
                txtSelisihWaktuMenit.setText(String.valueOf(selisihMenit));
                txtSelisihWaktuDetik.setText(String.valueOf(selisihDetik));
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