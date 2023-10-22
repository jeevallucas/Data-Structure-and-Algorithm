package praktikum_12_72210512;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SoalNomor1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    String s = "";
    
    Label lblFak = new Label("Faktorial");
    Label lblIterasi = new Label("Proses Secara Iterasi");
    Label lblRekursi = new Label("Proses Secara Rekursi");
    
    TextField txtFak = new TextField();
    TextArea txtIterasi = new TextArea();
    TextArea txtRekursi = new TextArea();
    
    Button btnHitung = new Button("_Hitung");
    Button btnClose = new Button("_Close");
    
    HBox hb1 = new HBox(5);
    HBox hb2 = new HBox(5);
    HBox reg = new HBox();
    
    VBox vb = new VBox(5);
    
    public int rekursi(int num) {
        int fak;
        
        if (num == 0)
            fak = 1;
        else
            fak = num * rekursi(num - 1);
        
        for (int idx = 1; idx <= num; idx++) 
            s += "Faktorial (" + (idx = num) + ") = " + fak + "\n";
        
        return fak;
    }
    
    public void faktorial() {
        rekursi(Integer.parseInt(txtFak.getText()));
        txtRekursi.setText(s);
    }
    
    public String iterasi(int n) {
        int hasil = 1, idx;
        String s = "";
        
        for (idx = n; idx > 0; idx--) {
            s += idx + " x ";
            hasil *= idx;
        }
        
        return s + " = " + hasil;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        txtFak.setMaxWidth(50);
        
        txtIterasi.setMaxHeight(110);
        txtIterasi.setMaxWidth(300);
        
        txtRekursi.setMaxHeight(110);
        txtRekursi.setMaxWidth(300);
        
        hb1.getChildren().addAll(lblFak, txtFak, btnHitung);
        HBox.setHgrow(reg, Priority.ALWAYS);
        
        hb2.getChildren().addAll(reg, btnClose);
        
        vb.getChildren().addAll(hb1, lblIterasi, txtIterasi, lblRekursi, txtRekursi, hb2);
        vb.setPadding(new Insets(10));
        
        btnHitung.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                faktorial();
                txtIterasi.setText(iterasi(Integer.parseInt(txtFak.getText())));
                s += "\n";
            }
        });
        
        btnClose.setOnAction(e -> System.exit(0));
        
        primaryStage.setTitle("Menghitung Faktorial");
        primaryStage.setScene(new Scene(vb));
        primaryStage.show();
    }
}