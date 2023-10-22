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
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TugasPreLab3Nomor2F extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    final Text title = new Text("Celcius\nke Reamur, Fahrenheit, dan Kelvin dengan Do-While");
    
    final Label pertanyaan = new Label("Apakah ingin menghitung konversi lagi?");
    final Button buttonIya = new Button("Iya");
    final Button buttonTidak = new Button("Tidak");
        
    final Label inputCelcius = new Label("Celcius");
    final TextField fieldInputCelcius = new TextField();
        
    final Label outputReamur = new Label("Reamur");
    final TextField areaOutputReamur = new TextField();
    
    final Label outputFahrenheit = new Label("Fahrenheit");
    final TextField areaOutputFahrenheit = new TextField();
    
    final Label outputKelvin = new Label("Kelvin");
    final TextField areaOutputKelvin = new TextField();
        
    final Button buttonTentukan = new Button("Tentukan");

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Celcius ke Reamur, Fahrenheit, dan Kelvin dengan Do-While");
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        gridPane.add(title, 0, 0, 2, 1);
        
        gridPane.add(inputCelcius, 0, 1);
        gridPane.add(fieldInputCelcius, 1, 1);
        
        gridPane.add(buttonTentukan, 0, 3);
        
        fieldInputCelcius.setMaxWidth(100);
        
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        gridPane.add(hBox1, 1, 2);
        
        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        gridPane.add(hBox2, 1, 3);
        
        buttonTentukan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                    double c = Double.parseDouble(fieldInputCelcius.getText());
                    double r = c * 4 / 5;
                    double f = c * 9 / 5 + 32;
                    double k = c + 273;
                    areaOutputReamur.setText(String.valueOf(r + "°R"));
                    areaOutputFahrenheit.setText(String.valueOf(f + "°F"));
                    areaOutputKelvin.setText(String.valueOf(k + "°K"));
                    
                    gridPane.add(areaOutputReamur, 1, 2);
                    gridPane.add(areaOutputFahrenheit, 1, 3);
                    gridPane.add(areaOutputKelvin, 1, 4);
                    
                    hBox1.getChildren().addAll(areaOutputReamur, areaOutputFahrenheit, areaOutputKelvin);
                    
                    pertanyaan.setOpacity(1);
                    buttonIya.setOpacity(1);
                    buttonTidak.setOpacity(1);
                    
                    gridPane.add(pertanyaan, 0, 3);
                    gridPane.add(buttonIya, 1, 3);
                    gridPane.add(buttonTidak, 2, 3);
                    
                    hBox2.getChildren().addAll(pertanyaan, buttonIya, buttonTidak);
                    
                    areaOutputReamur.setMaxWidth(100);
                    areaOutputFahrenheit.setMaxWidth(100);
                    areaOutputKelvin.setMaxWidth(100);
                    
                    buttonTentukan.setOpacity(0);
                    
                    buttonIya.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            
                            buttonTentukan.setOpacity(1);
                            pertanyaan.setOpacity(0);
                            buttonIya.setOpacity(0);
                            buttonTidak.setOpacity(0);
                            
                            fieldInputCelcius.setText(String.valueOf(""));
                            areaOutputReamur.setText(String.valueOf(""));
                            areaOutputFahrenheit.setText(String.valueOf(""));
                            areaOutputKelvin.setText(String.valueOf(""));
                        }
                    });
            }
        });
        
        buttonTidak.setOnAction(new EventHandler<ActionEvent>() {
            
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