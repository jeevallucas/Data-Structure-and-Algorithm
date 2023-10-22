package praktikum_02_72210512;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class nomorDua extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Deret Fibonnaci");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        Text title = new Text("Deret Fibonnaci");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        title.setFill(Color.BLUE);
        grid.add(title, 0, 0, 3, 1);
        
        Label labelData = new Label("Panjang Deret");
        grid.add(labelData, 0, 2);
        TextField txtData = new TextField();
        grid.add(txtData, 1, 2);
        txtData.setMaxWidth(80);
        
        Label title2 = new Label("Fibonacci");
        grid.add(title2, 0, 4);
        title2.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        
        Label labelHasil = new Label("Hasil");
        grid.add(labelHasil, 0, 5);
        TextArea txtHasil = new TextArea();
        grid.add(txtHasil, 1, 5);
        txtHasil.setMaxWidth(165);
        txtHasil.setMaxHeight(0);
        
        Matematika mat = new Matematika();
        Button btnProses = new Button("Proses");
        grid.add(btnProses, 0, 6);
        btnProses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {   
                txtHasil.setText(String.valueOf(mat.fibo(Integer.parseInt(txtData.getText()))));
                txtData.requestFocus();
                txtData.setText("");
            }
        });
        
        Button btnClose = new Button("Selesai");
        grid.add(btnClose, 1, 6);
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        Scene scene = new Scene(grid, 460, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Text nama = new Text("72210512 - Putu Jeevallucas Jnanamaitriya Surya Gautama");
        nama.setFont(Font.font("Arial", FontWeight.BOLD, 12.5));
        nama.setFill(Color.ORANGE);
        grid.add(nama, 0, 1, 7, 1);
    }
}