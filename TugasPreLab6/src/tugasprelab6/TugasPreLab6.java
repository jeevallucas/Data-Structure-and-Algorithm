package tugasprelab6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TugasPreLab6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        Data kelasData = new Data(100);
        Scene scene = new Scene(gridPane, 400, 170);
        
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        
        primaryStage.setTitle("Mengelola Array");
        primaryStage.setScene(scene);
        primaryStage.show();

        Text textMengelolaArray = new Text("Mengelola Array");
        textMengelolaArray.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        textMengelolaArray.setFill(Paint.valueOf("Orange"));
        gridPane.add(textMengelolaArray, 0, 0, 3, 1);
        
        Label labelData = new Label("Data");
        gridPane.add(labelData, 0, 1);
        
        TextField fieldData = new TextField();
        gridPane.add(fieldData, 1, 1, 3, 1);
        
        Button buttonAdd = new Button("Add");
        gridPane.add(buttonAdd, 4, 1);
        buttonAdd.setMaxWidth(350);
        
        TextField fieldHasil = new TextField();
        gridPane.add(fieldHasil, 1, 2, 3, 1);
        
        Button buttonBackspace = new Button("-");
        gridPane.add(buttonBackspace, 4, 2);
        buttonBackspace.setMaxWidth(350);
        
        Button buttonClose = new Button("Close");
        gridPane.add(buttonClose, 4, 3);
        
        Text textIdentitas = new Text("72210512\nPutu Jeevallucas Jnanamaitriya Surya Gautama");
        textIdentitas.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        gridPane.add(textIdentitas, 0, 7, 2, 1);

        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int data = Integer.parseInt(fieldData.getText());
                
                kelasData.menambahData(data);
                fieldHasil.setText(kelasData.membacaSemuaData());
                fieldData.requestFocus();
                fieldData.setText("");
            }
        });
        
        buttonBackspace.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                kelasData.menghapusData();
                fieldHasil.setText(kelasData.membacaSemuaData());
                fieldData.requestFocus();
            }
        });

        buttonClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                kelasData.saveFile();
                System.exit(0);
            }
        });
    }
}