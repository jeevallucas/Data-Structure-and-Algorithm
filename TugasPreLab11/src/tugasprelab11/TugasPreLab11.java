package tugasprelab11;

import java.util.Comparator;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TugasPreLab11 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    TableView<Mahasiswa> tabel;
    DaftarMahasiswa mhs = new DaftarMahasiswa(50);

    public ObservableList<Mahasiswa> getMhs() {
        ObservableList<Mahasiswa> mhs = FXCollections.observableArrayList();
        mhs.add(new Mahasiswa("72210670", "Nadya", "Semarang", "B"));
        mhs.add(new Mahasiswa("72210575", "Faradisa", "Surabaya", "A"));
        mhs.add(new Mahasiswa("72190672", "Alkan", "Magelang", "B"));
        mhs.add(new Mahasiswa("72200365", "Samudera", "Solo", "A"));
        mhs.add(new Mahasiswa("72190234", "Ayunda", "Bogor", "B"));
        mhs.add(new Mahasiswa("72200478", "Bethsheba", "Pekanbaru", "B"));
        mhs.add(new Mahasiswa("72219023", "Jerome", "Medan", "A"));
        mhs.add(new Mahasiswa("72200123", "Maura", "Bandung", "A"));
        mhs.add(new Mahasiswa("72190623", "Vachry", "Depok", "A"));
        mhs.add(new Mahasiswa("72200012", "Erlangga", "Sleman", "B"));
        return mhs;
    }

    boolean baru = true;
    int iterasiBiner = 0, iterasiSequent = 0;

    TextField txtNim = new TextField();
    TextField txtNama = new TextField();
    TextField txtKota = new TextField();
    TextField txtGrup = new TextField();
    ComboBox combo = new ComboBox();
    VBox vb = new VBox(5);
    HBox hb = new HBox(5);
    HBox hb1 = new HBox(5);
    Button btnAdd = new Button("_Add");
    Button btnUpdate = new Button("_Update");
    Button btnDelete = new Button("_Delete");
    Button btnFind = new Button("_Find");
    Button btnFilter = new Button("_Filter");
    Button btnClose = new Button("_Close");

    private void inisialisasiKontrol() {
        txtNim.setMaxWidth(80);
        txtNim.setPromptText("NIM");

        txtNama.setMaxWidth(150);
        txtNama.setPromptText("nama mahasiswa");

        txtKota.setMaxWidth(100);
        txtKota.setPromptText("kota");

        txtGrup.setMaxWidth(80);
        txtGrup.setPromptText("grup");

        hb.getChildren().addAll(txtNim, txtNama, txtKota, txtGrup);
        hb1.getChildren().addAll(btnAdd, btnUpdate, btnDelete, btnFind, btnFilter, btnClose);
        hb.setPadding(new Insets(0, 5, 5, 5));
        vb.getChildren().addAll(tabel, hb, hb1);
    }

    private void inisialisasiKolom() {
        //kolom NIM
        TableColumn<Mahasiswa, String> kolNim = new TableColumn("Nim");
        kolNim.setCellValueFactory(new PropertyValueFactory<>("NIM"));
        kolNim.setMaxWidth(120);
        kolNim.setStyle("-fx-alignment:center");

        //kolom nama
        TableColumn<Mahasiswa, String> kolNama = new TableColumn("Nama Mahasiswa");
        kolNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolNama.setMinWidth(150);

        //kolom kota
        TableColumn<Mahasiswa, String> kolKota = new TableColumn("Kota");
        kolKota.setCellValueFactory(new PropertyValueFactory<>("kota"));
        kolKota.setMinWidth(60);

        //kolom grup
        TableColumn<Mahasiswa, String> kolGrup = new TableColumn("Grup");
        kolGrup.setCellValueFactory(new PropertyValueFactory<>("grup"));
        kolGrup.setMinWidth(60);
        tabel = new TableView<>();
        tabel.setItems(getMhs());
        tabel.getColumns().addAll(kolNim, kolNama, kolKota, kolGrup);
    }

    void buka() {
        txtNim.setEditable(true);
        txtNama.setEditable(true);
        txtGrup.setEditable(true);
        txtKota.setEditable(true);
        btnFilter.setDisable(false);
        btnFind.setDisable(false);
        btnAdd.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
        btnClose.setDisable(false);
        txtNama.requestFocus();
    }

    private void add() {
        ObservableList<Mahasiswa> daftarMhs = tabel.getItems();
        String grup, nama, kota, nim;
        nim = txtNim.getText();
        kota = txtKota.getText();
        nama = txtNama.getText();
        grup = txtGrup.getText();
        Mahasiswa mhs = new Mahasiswa(nim, nama, kota, grup);
        int idx, cacah = daftarMhs.size();
        for (idx = 0; idx < cacah; idx++) {
            if (daftarMhs.get(idx).getNIM().compareTo(nim) > 0) {
                break;
            }
        }
        if (idx <= cacah) {
            tabel.getItems().add(idx, mhs);
            buka();
            txtNim.clear();
            txtNama.clear();
            txtKota.clear();
            txtGrup.clear();
        }
    }

    private void update() {
        String nim, nama, kota, grup;
        ObservableList<Mahasiswa> pilih = tabel.getSelectionModel().getSelectedItems();
        nim = pilih.get(0).getNIM();
        nama = pilih.get(0).getNama();
        kota = pilih.get(0).getKota();
        grup = pilih.get(0).getGrup();
        txtNim.setText(nim);
        txtNama.setText(nama);
        txtKota.setText(kota);
        txtGrup.setText(grup);
        delete();
        txtNama.requestFocus();
    }

    private void delete() {
        ObservableList<Mahasiswa> pilih, semua;
        semua = tabel.getItems();
        pilih = tabel.getSelectionModel().getSelectedItems();
        pilih.forEach(semua::remove);
    }

    String dialogBox() {
        ObservableList<Mahasiswa> daftarMhs = tabel.getItems();
        daftarMhs.sort(Comparator.comparing(Mahasiswa::getNIM));
        Label lblNama = new Label("Kunci Pencarian");
        TextField txtCari = new TextField();
        txtCari.setMaxWidth(180);
        Button btnCari = new Button("_Find");
        ComboBox cb = new ComboBox();
        cb.getItems().addAll("Nim", "Nama");
        cb.setValue("Nim");
        cb.setOnAction((event) -> {
            if (cb.getValue().equals("Nim")) {
                txtCari.setPromptText("tulis nim yang dicari");
                daftarMhs.sort(Comparator.comparing(Mahasiswa::getNIM));
            } else {
                txtCari.setPromptText("tulis nama yang dicari");
                daftarMhs.sort(Comparator.comparing(Mahasiswa::getNama));
            }
        });

        HBox hb = new HBox(5, lblNama, cb, txtCari, btnCari);
        hb.setPadding(new Insets(15, 10, 10, 10));
        Stage window = new Stage();
        window.setScene(new Scene(hb));
        window.initModality(Modality.APPLICATION_MODAL);
        btnCari.setOnAction(e -> window.close());
        window.showAndWait();
        return txtCari.getText();
    }

    public void cari() {
        String baca = "", read = "", cari = dialogBox();
        ObservableList<Mahasiswa> daftarMhs = tabel.getItems();
        daftarMhs.sort(Comparator.comparing(Mahasiswa::getNIM));
        int idx, cacah = daftarMhs.size();
        int min, max, mid = 0;
        min = 0;
        max = cacah - 1;
        while (min <= max) {
            iterasiBiner++;
            mid = (min + max) / 2;
            baca = daftarMhs.get(mid).getNIM();
            read = daftarMhs.get(mid).getNama();
            if (baca.equals(cari) || read.contains(cari)) {
                break;
            }
            if (baca.compareTo(cari) < 0 && read.compareTo(cari) < 0) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        for (idx = 0; idx < cacah; idx++) {
            iterasiSequent++;
            if (daftarMhs.get(idx).getNIM().equals(cari) || daftarMhs.get(idx).getNama().contains(cari)) {
                break;
            }
        }
        if (baca.equals(cari) || idx < cacah) {
            tabel.getSelectionModel().select(idx);
            tabel.scrollTo(idx);
            tabel.requestFocus();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Sequential Search: " + iterasiSequent + " kali iterasi" + "\nBiner Search: " + iterasiBiner + " kali iterasi");
            a.show();
            iterasiSequent = 0;
            iterasiBiner = 0;
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING, "Nim " + cari + " tidak ditemukan!");
            a.show();
            iterasiSequent = 0;
            iterasiBiner = 0;
        }
    }

    private void close() {
        System.exit(0);
    }

    void dialogBoxFilter() {
        TextField txtFilter = new TextField();
        txtFilter.setMinWidth(275);
        txtFilter.setPromptText("nim nama kota");
        Button btnClose = new Button("Close");
        HBox hb = new HBox(5, txtFilter, btnClose);
        hb.setPadding(new Insets(15, 10, 10, 10));
        Stage window = new Stage();
        window.setScene(new Scene(hb));
        window.initModality(Modality.APPLICATION_MODAL);
        btnClose.setOnAction(e -> window.close());

        FilteredList<Mahasiswa> dataTersaring = new FilteredList<>(tabel.getItems(), b -> true);
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            dataTersaring.setPredicate(psn -> {
                String sumber = psn.getNIM() + psn.getNama() + psn.getKota() + psn.getGrup();
                if (sumber.toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else {
                    return false;
                }
            });
            tabel.setItems(dataTersaring);
        });
        window.setTitle("Nim, Nama, Kota, Grup");
        window.setX(500);
        window.setY(100);
        window.showAndWait();
        dataTersaring.setPredicate(t -> true);
    }

    public String getDataMhs() {
        String all = "";
        for (int i = 0; i < this.tabel.getItems().size(); i++) {
            String nim = String.valueOf(tabel.getItems().get(i).getNIM());
            String nama = String.valueOf(tabel.getItems().get(i).getNama());
            String kota = String.valueOf(tabel.getItems().get(i).getKota());
            String grup = String.valueOf(tabel.getItems().get(i).getGrup());

            all += nim + ", " + nama + ", " + kota + ", " + grup + "\n";
        }
        return all;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        tabel = new TableView<>();

        inisialisasiKolom();
        inisialisasiKontrol();
        primaryStage.setScene(new Scene(vb, 600, 500));
        primaryStage.setTitle("Daftar Mahasiswa");
        primaryStage.show();

        btnAdd.setOnAction(e -> add());
        btnUpdate.setOnAction(e -> update());
        btnDelete.setOnAction((event) -> {
            ObservableList<Mahasiswa> dt = tabel.getSelectionModel().getSelectedItems();
            String nim = dt.get(0).getNIM();
            String nama = dt.get(0).getNama();
            String kota = dt.get(0).getKota();
            String grup = dt.get(0).getGrup();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi");
            alert.setHeaderText("Apakah Anda yakin ingin mendelete data ?");
            alert.setContentText(String.valueOf("Nim: " + nim + "\nNama: " + nama + "\nKota: " + kota + "\nGrup: " + grup));
            Optional<ButtonType> jwb = alert.showAndWait();
            if (jwb.get() == ButtonType.OK) {
                delete();
                Alert alert1 = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Data Telah dihapus");
                alert.setContentText("Data anda telah dihapus");
                alert.showAndWait();
            } else {
                Alert alert2 = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Data Tidak Jadi dihapus");
                alert.setContentText("Data anda tidak jadi dihapus");
                alert.showAndWait();
            }
        });
        btnFind.setOnAction(e -> cari());
        btnFilter.setOnAction(e -> dialogBoxFilter());
        btnClose.setOnAction(e -> close());
    }
}
