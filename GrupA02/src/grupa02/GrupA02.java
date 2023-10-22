package grupa02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GrupA02 extends Application {
    
    final Text judulScene = new Text("Kontrol Form");
    final Label textFieldLabel = new Label("Text Field");
    
    final Label comboBoxLabel = new Label("Combo Box: ");
    final TextField inputTextField = new TextField();
    final ComboBox comboBox = new ComboBox();
    
    final TextArea text = new TextArea("");
    
    final Button btnProses = new Button("Proses");
    
    final Button btnClose = new Button("Close");

    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Kontrol Form");
        GridPane grid = new GridPane();
        
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 5, 5, 5));
        
        judulScene.setFont(Font.font("Arial Rounded MT Bold", FontWeight.NORMAL, 20));
        
        grid.add(judulScene, 0, 0, 2, 1);
        grid.add(textFieldLabel, 0, 1);
        grid.add(inputTextField, 1, 1);
        grid.add(comboBoxLabel, 0, 2);
        
        comboBox.getItems().addAll(
        
                "Pilihan 1",
                "Pilihan 2",
                "Pilihan 3"
                
        );
        
        comboBox.setValue("Pilihan 1");
        
        grid.add(comboBox, 1, 2);
        grid.add(text, 0, 3, 2, 1); 
        
        grid.add(btnProses, 0, 4, 3, 1);
        btnProses.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            
            public void handle(ActionEvent e) {
                String isi = "Pilihan: " + comboBox.getValue() + " Terima kasih...";
                text.setText(isi);
            }
        });
    
        grid.add(btnClose, 1, 4, 2, 1);
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                System.exit(0);
            }
        });

        Scene scene = new Scene(grid, 330, 200);
    
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }
}
