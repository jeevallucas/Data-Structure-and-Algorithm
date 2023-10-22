package tugasprelab3;

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
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TugasPreLab3Nomor2G extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    final Text title = new Text("Celcius\nke Reamur, Fahrenheit, dan Kelvin");
    
    final Label inputCelcius = new Label("Celcius");
    final TextField fieldInputCelcius = new TextField();
        
    final Label outputReamur = new Label("Reamur");
    final TextArea areaOutputReamur = new TextArea();
    
    final Label outputFahrenheit = new Label("Fahrenheit");
    final TextArea areaOutputFahrenheit = new TextArea();
    
    final Label outputKelvin = new Label("Kelvin");
    final TextArea areaOutputKelvin = new TextArea();
        
    final Button buttonTentukan = new Button("Tentukan");
    final Button buttonSelesai = new Button("Selesai");

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Celcius ke Reamur, Fahrenheit, dan Kelvin");
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        gridPane.add(title, 0, 0, 2, 1);
                
        gridPane.add(inputCelcius, 0, 2);
        gridPane.add(fieldInputCelcius, 1, 2);
                
        fieldInputCelcius.setMaxWidth(100);
                
        gridPane.add(buttonTentukan, 0, 4);
        gridPane.add(buttonSelesai, 1, 4);
                
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        gridPane.add(hBox1, 1, 3);
        
        buttonTentukan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                areaOutputReamur.setText(String.valueOf(""));
                areaOutputFahrenheit.setText(String.valueOf(""));
                areaOutputKelvin.setText(String.valueOf(""));
                
                double c, celcius = Double.parseDouble(fieldInputCelcius.getText());
                
                for(c = celcius; c <= 100; c = c + 10) {
                    double r = c * 4 / 5;
                    double f = c * 9 / 5 + 32;
                    double k = c + 273;
                    
                    if(c == 100) {
                        areaOutputReamur.appendText(String.valueOf("Maaf,\nsatuan suhu\nReamur\ntidak dapat\ndikonversi"));
                        areaOutputFahrenheit.appendText(String.valueOf("Maaf,\nsatuan suhu\nFahrenheit\ntidak dapat\ndikonversi"));
                        areaOutputKelvin.appendText(String.valueOf("Maaf,\nsatuan suhu\nKelvin\ntidak dapat\ndikonversi"));
                    }
                    
                    else {
                        areaOutputReamur.appendText(String.valueOf(r + "°R\n"));
                        areaOutputFahrenheit.appendText(String.valueOf(f + "°F\n"));
                        areaOutputKelvin.appendText(String.valueOf(k + "°K\n"));
                    }
                }
                            
                gridPane.add(areaOutputReamur, 1, 3);
                gridPane.add(areaOutputFahrenheit, 2, 3);
                gridPane.add(areaOutputKelvin, 3, 3);
                            
                hBox1.getChildren().addAll(areaOutputReamur, areaOutputFahrenheit, areaOutputKelvin);
                
                fieldInputCelcius.setMaxWidth(100);
                
                areaOutputReamur.setMaxHeight(500);
                areaOutputReamur.setMaxWidth(100);
                
                areaOutputFahrenheit.setMaxHeight(500);
                areaOutputFahrenheit.setMaxWidth(100);

                areaOutputKelvin.setMaxHeight(500);
                areaOutputKelvin.setMaxWidth(100);
            }
        });
        
        buttonSelesai.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                System.exit(0);
            }
        });
        
        Label NIM = new Label("NIM: ");
        gridPane.add(NIM, 2, 5);
        
        Label isiNIM = new Label("72210512");
        gridPane.add(isiNIM, 3, 5);
        
        Label nama = new Label("Nama: ");
        gridPane.add(nama, 2, 6);
        
        Label isiNama = new Label("Putu Jeevallucas Jnanamaitriya Surya Gautama");
        gridPane.add(isiNama, 3, 6);
        
        Scene scene = new Scene(gridPane, 400, 300);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}