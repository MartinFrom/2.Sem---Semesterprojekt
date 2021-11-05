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
import model.*;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 */

public class OpretProduktWindow extends Stage {

    private ListView<ProduktGruppe> lwProduktGruppe;
    private ListView<Produkt> lwProdukt;
    private Produkt produkt;
    private TextField txfNytProdukt;


    public OpretProduktWindow(String title) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setTitle(title);

        BorderPane bPane = new BorderPane();
        GridPane gPane = GUIHelperClass.createGridPane(700,500,10,10,50);
        bPane.setCenter(gPane);
        this.initContent(gPane);

        Scene scene = new Scene(bPane);
        setScene(scene);
    }

    private void initContent(GridPane pane) {
        // Produktgruppe
        Label lblProduktGruppe = new Label("Produktgruppe:");
        pane.add(lblProduktGruppe, 0, 1);
        //ListView
        lwProduktGruppe = new ListView<>();
        pane.add(lwProduktGruppe, 0, 2,1,5);
        lwProduktGruppe.setPrefHeight(500);
        lwProduktGruppe.setPrefWidth(200);
        lwProduktGruppe.getItems().setAll(Controller.getProduktGrupper());

        // Listener
        ChangeListener<ProduktGruppe> produktGruppeChangeListener = (ov, oldGruppe, newGruppe) -> this.selectedProduktGruppeChanged();
        lwProduktGruppe.getSelectionModel().selectedItemProperty().addListener(produktGruppeChangeListener);

        // Produkt
        Label lblProdukt = new Label("Produkter:");
        pane.add(lblProdukt, 1, 1);
        // ListView
        lwProdukt = new ListView<>();
        pane.add(lwProdukt, 1, 2,1,5);
        lwProdukt.setPrefWidth(350);
        lwProdukt.setPrefHeight(500);

        // Select antal og tilføj
        Label lblAntal = new Label("Nyt produktnavn:");
        pane.add(lblAntal,2,2);

        txfNytProdukt = new TextField();
        pane.add(txfNytProdukt,2,3);
        txfNytProdukt.setPrefWidth(75);

        Button btnTilføjProdukt = new Button("Tilføj produkt");
        pane.add(btnTilføjProdukt,2,4);
        btnTilføjProdukt.setPrefWidth(150);
        btnTilføjProdukt.setPrefHeight(100);
        btnTilføjProdukt.setOnAction(e -> {
            produkt = Controller.createProdukt(txfNytProdukt.getText(), lwProduktGruppe.getSelectionModel().getSelectedItem());
            lwProdukt.getItems().add(produkt);
        });
    }

    //ListenerChanged
    private void selectedProduktGruppeChanged() {
        ProduktGruppe produktGruppe = lwProduktGruppe.getSelectionModel().getSelectedItem();
        lwProdukt.getItems().setAll(produktGruppe.getProdukter());
    }
}
