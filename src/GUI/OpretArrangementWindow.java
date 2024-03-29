package GUI;


import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Arrangement;
import model.Pris;
import model.Produkt;
import model.ProduktGruppe;
import storage.Storage;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 */

public class OpretArrangementWindow extends Stage {

    private ListView<ProduktGruppe> lwProduktGruppe;
    private ListView<Produkt> lwProdukt;
    private ListView<Pris> lwPriser;

    private Arrangement arr;
    private Pris pris;

    public OpretArrangementWindow(String title) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setTitle(title);

        BorderPane bPane = new BorderPane();
        GridPane gPane = GUIHelperClass.createGridPane(1000,500,10,10,50);
        bPane.setCenter(gPane);
        this.initContent(gPane);

        Scene scene = new Scene(bPane);
        setScene(scene);
    }

    private void initContent(GridPane pane) {
        // Kalender
        DatePicker DatePicker = new DatePicker();
        DatePicker.setValue(LocalDate.now());
        pane.add(DatePicker, 0, 1);

        // Variabler til Arrangement constructor
        TextField txfNavn = new TextField();
        txfNavn.setPromptText("Navn:");
        pane.add(txfNavn,1,1);

        TextField txfPladser = new TextField();
        txfPladser.setPromptText("Antal pladser:");
        pane.add(txfPladser,2,1);
        txfPladser.setPrefWidth(75);

        // Produktgruppe ListView
        Label lblProduktGruppe = new Label("Produktgruppe:");
        pane.add(lblProduktGruppe, 0, 2);
        //ListView
        lwProduktGruppe = new ListView<>();
        pane.add(lwProduktGruppe, 0, 3);
        lblProduktGruppe.setVisible(false);
        lwProduktGruppe.setVisible(false);
        lwProduktGruppe.setPrefHeight(500);
        lwProduktGruppe.setPrefWidth(200);
        lwProduktGruppe.getItems().setAll(Controller.getProduktGrupper());

        // Listener
        ChangeListener<ProduktGruppe> produktGruppeChangeListener = (ov, oldGruppe, newGruppe) -> this.selectedProduktGruppeChanged();
        lwProduktGruppe.getSelectionModel().selectedItemProperty().addListener(produktGruppeChangeListener);


        // Produkt list view (Data på bagrund af valgte kategori)
        Label lblProdukt = new Label("Produkter:");
        pane.add(lblProdukt, 1, 2);
        // ListView
        lwProdukt = new ListView<>();
        pane.add(lwProdukt, 1, 3,2,1);
        lblProdukt.setVisible(false);
        lwProdukt.setVisible(false);
        lwProdukt.setPrefWidth(350);
        lwProdukt.setPrefHeight(500);

        // NyPris txf og lbl
        Label lblNyPris = new Label("Ny Pris:");
        pane.add(lblNyPris,1,4);

        TextField txfNyPris = new TextField();
        pane.add(txfNyPris,2,4);
        txfNyPris.setPrefWidth(50);
        txfNyPris.setPromptText("");

        lblNyPris.setVisible(false);
        txfNyPris.setVisible(false);

        // Skal gemme den nye pris på lwPriser
        Button btnNyPris = new Button("Tilføj til Arrangement");
        pane.add(btnNyPris,3,4);
        btnNyPris.setVisible(false);
        btnNyPris.setPrefHeight(20);
        btnNyPris.setOnAction(e -> {
            pris = Controller.createPris(arr,lwProdukt.getSelectionModel().getSelectedItem(), parseInt(txfNyPris.getText()));
            lwPriser.getItems().add(pris);
        });

        // Viser Gemte Priser på ListView
        Label lblPriser = new Label("Produkter tilføjet til arrangement:");
        pane.add(lblPriser, 3,2);
        // ListView
        lwPriser = new ListView<>();
        pane.add(lwPriser,3,3);
        lblPriser.setVisible(false);
        lwPriser.setVisible(false);
        lwPriser.setPrefHeight(500);
        lwPriser.setPrefWidth(350);


        // Gemmer data og lukker vinduet
        Button btnGem = new Button("Gem");
        pane.add(btnGem,0,4);
        btnGem.setVisible(false);
        btnGem.setOnAction(e -> {
            Storage.addPrisliste(arr);

            close();
        });

        // Opretter Arrangement
        Button btnOpretArrangement = new Button("Videre");
        pane.add(btnOpretArrangement,3,1);
        btnOpretArrangement.setOnAction(e -> {
            arr = Controller.createArrangement(txfNavn.getText(), DatePicker.getValue(), parseInt(txfPladser.getText()));

            lblProduktGruppe.setVisible(true);
            lwProduktGruppe.setVisible(true);
            lblProdukt.setVisible(true);
            lwProdukt.setVisible(true);
            lblNyPris.setVisible(true);
            txfNyPris.setVisible(true);
            btnNyPris.setVisible(true);
            lblPriser.setVisible(true);
            lwPriser.setVisible(true);
            btnGem.setVisible(true);
        });

    }

    // ListenerChanged
    private void selectedProduktGruppeChanged() {
        ProduktGruppe prg = lwProduktGruppe.getSelectionModel().getSelectedItem();
        if (prg != null) {
            lwProdukt.getItems().setAll(prg.getProdukter());
        }
    }
}
