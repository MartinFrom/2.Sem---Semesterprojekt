package GUI;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;

import java.awt.*;
import java.util.ArrayList;

public class MainApp extends Application{
    private int mainWindowwidth = 1200;
    private int mainWindowheight = 500;

    private ListView<Ordre> lwOrdre;
    private ListView<Betalingsform> lwBetalingsform;
    private ListView<OrdreLinje> lwOrdreLinjer;

    private Ordre ordre;


    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("SalgsSystem");
        stage.setResizable(false);

        BorderPane bPane = new BorderPane();
        GridPane gPane = GUIHelperClass.createGridPane(mainWindowwidth, mainWindowheight, 25 ,20,50);
        bPane.setCenter(gPane);
        this.initContent(gPane);

        Scene scene = new Scene(bPane);

        stage.setScene(scene);
        stage.show();
    }

    //------------------------------------------------------
    private void initContent(GridPane pane) {
        // Buttons
        Button btnOpretUdlejning = new Button("Opret Udlejning");
        pane.add(btnOpretUdlejning, 0,0);
        btnOpretUdlejning.setPrefWidth(150);
        btnOpretUdlejning.setAlignment(Pos.CENTER_LEFT);
        btnOpretUdlejning.setOnAction(e -> {
            OpretUdlejningWindow opretUdlWin = new OpretUdlejningWindow("Udlejning");
            opretUdlWin.showAndWait();
        });

        Button btnOpretArrangement = new Button("Opret Arrangement");
        pane.add(btnOpretArrangement, 1, 0);
        btnOpretArrangement.setPrefWidth(150);
        btnOpretArrangement.setAlignment(Pos.CENTER_LEFT);
        btnOpretArrangement.setOnAction(e -> {
            OpretArrangementWindow opretArrWin = new OpretArrangementWindow("Opret Arrangement");
            opretArrWin.showAndWait();
        });

        Button btnOpretOrdre = new Button("Opret Ordre");
        pane.add(btnOpretOrdre,1,1);
        btnOpretOrdre.setPrefWidth(150);
        btnOpretOrdre.setAlignment(Pos.CENTER_LEFT);
        btnOpretOrdre.setOnAction(e -> {
            OpretOrdreWindow opretOrdWin = new OpretOrdreWindow("Ordre");
            opretOrdWin.showAndWait();
        });

        Button btnOpretProduktGruppe = new Button ("Opret Produktgruppe");
        pane.add(btnOpretProduktGruppe, 0,1);
        btnOpretProduktGruppe.setPrefWidth(150);
        btnOpretProduktGruppe.setAlignment(Pos.CENTER_LEFT);
        btnOpretProduktGruppe.setOnAction(e -> {
            OpretProduktGruppeWindow opretPGWindow = new OpretProduktGruppeWindow("ProduktGruppe");
            opretPGWindow.showAndWait();
        });

        Button btnOpretProdukt = new Button ("Opret Produkt");
        pane.add(btnOpretProdukt, 0,2);
        btnOpretProdukt.setPrefWidth(150);
        btnOpretProdukt.setAlignment(Pos.CENTER_LEFT);
        btnOpretProdukt.setOnAction(e -> {
            OpretProduktWindow opretPWindow = new OpretProduktWindow("Produkt");
            opretPWindow.showAndWait();

        });

        Button btnBetaling = new Button ("Registrer" +"\n"+"betaling");
        pane.add(btnBetaling,2,5);
        btnBetaling.setPrefHeight(75);
        btnBetaling.setPrefWidth(75);
        btnBetaling.setOnAction(e -> {
           // RegistrerBetalingWindow betalingsWindow = new RegistrerBetalingWindow(ordre);
         //   betalingsWindow.showAndWait();
          setLwOrdre();
          lwOrdre.getSelectionModel().getSelectedItem().setErBetalt(true);
        });

        // ListView Ordre/Udlejninger
        // Label
        Label lblOrdre = new Label("Ordre/Udlejninger");
        pane.add(lblOrdre,0,3);
        // ListView
        lwOrdre = new ListView<>();
        pane.add(lwOrdre,0,4,2,2);
        lwOrdre.setPrefHeight(150);
        lwOrdre.setPrefWidth(500);
        setLwOrdre();

        // ListView Ordre Listener
        ChangeListener<Ordre> ordreChangeListener = (ov, oldOrdre, newOrdre) -> this.selectedOrdreChanged();
        lwOrdre.getSelectionModel().selectedItemProperty().addListener(ordreChangeListener);

        Label lblBetaling = new Label("Vælg betalingsform:");
        pane.add(lblBetaling,2,3);
        // ListView
        lwBetalingsform = new ListView<>();
        pane.add(lwBetalingsform,2,4);
        lwBetalingsform.setPrefHeight(100);
        lwBetalingsform.setPrefWidth(150);
        lwBetalingsform.getItems().setAll(Controller.getBetalingsformer());


        Label lblOrdrelinje = new Label("Ordrelinjer:");
        pane.add(lblOrdrelinje,3,0);
        // ListView
        lwOrdreLinjer = new ListView<>();
        pane.add(lwOrdreLinjer,3,1,1,5);
        lwOrdreLinjer.setPrefWidth(350);
        lwOrdreLinjer.setPrefHeight(500);
        // TODO


    }
    // ListenerChanged
    private void selectedOrdreChanged() {
        Ordre ordre = lwOrdre.getSelectionModel().getSelectedItem();
        if (ordre != null) {
            lwOrdreLinjer.getItems().clear();
            lwOrdreLinjer.getItems().setAll(ordre.getOrdrelinjer());
            if (lwOrdre.getItems().size() != Controller.getOrdrer().size() + Controller.getUdlejninger().size()) {
                setLwOrdre();
            }
        }
    }

    private void setLwOrdre() {
        lwOrdre.getItems().setAll(samletOrdreUdlejning());
    }

    private ArrayList<Ordre> samletOrdreUdlejning() {
        ArrayList<Ordre> result1;
        result1 = Controller.getOrdrer();
        ArrayList<Udlejning> result2;
        result2 = Controller.getUdlejninger();

        ArrayList<Ordre> result = new ArrayList<>();
        result.addAll(result1);
        result.addAll(result2);

        return result;
    }
}
