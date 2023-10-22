package tugasprelab13;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TugasPreLab13 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    TextField txtData = new TextField();
    TextField txtArray = new TextField();
    TextArea txtProses = new TextArea();

    Button btnClose = new Button("_Close");
    Button btnAdd = new Button("_Add");
    Button btnQuick = new Button("_Quick Sort");

    VBox vb1 = new VBox();
    VBox vb2 = new VBox();
    VBox vb3 = new VBox();
    VBox vb4 = new VBox();
    VBox vb5 = new VBox();
    HBox hb1 = new HBox();
    HBox hb2 = new HBox();
    HBox hb3 = new HBox();

    Label txtTitle = new Label("QUICK SORT of AN ARRAY");
    Label lblData = new Label("Masukkan Bilangan Integer");
    Label lblArray = new Label("Array");

    Label lblInformasi = new Label("programmed and designed by:");
    Label lblIdentitas = new Label("72210512\nPutu Jeevallucas Jnanamaitriya Surya Gautama");

    Region reg = new Region();

    Stack tumpukan = new Stack(10);
    Larik lrk = new Larik(100);

    @Override
    public void start(Stage primaryStage) throws Exception {
        txtData.setPromptText("Masukkan Bilangan Integer");

        HBox.setHgrow(reg, Priority.ALWAYS);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(10);

        Scene scene = new Scene(gridPane, 500, 580);
        primaryStage.setTitle("QUICK SORT of AN ARRAY");
        primaryStage.setScene(scene);
        primaryStage.show();

        txtData.setMinWidth(100);
        txtData.setPromptText("// integer values");

        txtArray.setPromptText("// array of input");
        txtArray.setMinWidth(100);
        txtArray.setDisable(true);
        txtArray.setEditable(false);

        lblData.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        hb1.getChildren().addAll(txtData, btnAdd);
        hb1.setSpacing(5);

        lblArray.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        btnQuick.setDisable(true);
        hb2.getChildren().addAll(txtArray, btnQuick);
        hb2.setSpacing(5);

        hb3.getChildren().addAll(reg, btnClose);

        txtTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        gridPane.add(txtTitle, 0, 0, 6, 1);
        gridPane.add(vb5, 0, 4, 1, 1);
        gridPane.add(hb2, 0, 7);

        txtProses.setPromptText("// process and results from quick sort");
        txtProses.setEditable(false);
        gridPane.add(txtProses, 5, 4, 5, 1);
        txtProses.setMinHeight(500);
        txtProses.setMinWidth(500);

        gridPane.add(hb3, 9, 5);

        vb1.getChildren().addAll(lblData, hb1);
        vb1.setSpacing(5);

        lblIdentitas.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        vb2.getChildren().addAll(lblArray, hb2);
        vb2.setSpacing(5);

        vb3.getChildren().addAll(vb1, vb2);
        vb3.setSpacing(20);

        lblInformasi.setFont(Font.font("Arial", FontPosture.ITALIC, 10));
        vb4.getChildren().addAll(lblInformasi, lblIdentitas);
        vb4.setSpacing(10);

        vb5.getChildren().addAll(vb3, vb4);
        vb5.setSpacing(100);

        btnAdd.setOnAction(e -> add());
        btnQuick.setOnAction(e -> quickSortRekursif());
        btnClose.setOnAction(e -> close());
    }

    void push() {
        tumpukan.push(Integer.parseInt(txtData.getText()));
        txtData.clear();
        txtData.requestFocus();
    }

    void pop() {
        txtData.setText(String.valueOf(tumpukan.pop()));
    }

    void peek() {
        txtData.setText(String.valueOf(tumpukan.peek()));
    }

    void add() {
        btnQuick.setDisable(false);

        lrk.add(Integer.parseInt(txtData.getText()));
        txtData.clear();
        txtData.requestFocus();
        
        txtArray.setText(lrk.getArray());
    }

    void quickSortRekursif() {
        lrk.array();
        lrk.quickSortRekursif();
        txtProses.setText(lrk.proses);
    }

    void close() {
        System.exit(0);
    }
}