package GUI;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import org.w3c.dom.Text;
import storage.Storage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class OpretOrdreWindow extends Stage {

    private ListView<ProduktGruppe> lwProduktGruppe;
    private ListView<Pris> lwProdukt;
    private ListView<Betalingsform> lwBetalingsform;
    private ListView<OrdreLinje> lwOrdreLinjer;

    private TextField txfAntal;

    private ComboBox<Prisliste> cbbPrisliste;
    private Label lblSamletPris;

    private Ordre ordre;
    private Prisliste prisliste;
    private OrdreLinje ordreLinje;

    public OpretOrdreWindow(String title) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setTitle(title);

        BorderPane bPane = new BorderPane();
        GridPane gPane = GUIHelperClass.createGridPane(1300,500,10,10,50);
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
        Label lblAntal = new Label("Antal:");
        pane.add(lblAntal,2,2);

        txfAntal = new TextField();
        pane.add(txfAntal,2,3);
        txfAntal.setPrefWidth(75);
        txfAntal.setText("1");

        Button btnTilføjProdukt = new Button("Tilføj Produkt");
        pane.add(btnTilføjProdukt,2,4);
        btnTilføjProdukt.setPrefWidth(150);
        btnTilføjProdukt.setPrefHeight(100);
        btnTilføjProdukt.setOnAction(e -> {
            ordreLinje = ordre.createOrdreLinje(parseInt(txfAntal.getText()), lwProdukt.getSelectionModel().getSelectedItem());
            lwOrdreLinjer.getItems().add(ordreLinje);
            lblSamletPris.setText("Samlet pris: " + ordre.beregnPris());
        });

        Label lblBetaling = new Label("Betalingsform:");
        pane.add(lblBetaling,2,5);
        // ListView
        lwBetalingsform = new ListView<>();
        pane.add(lwBetalingsform,2,6);
        // TODO

        // ListView Kurv
        Label lblOrdreLinjer = new Label("Kurv:");
        pane.add(lblOrdreLinjer,4,1);
        // ListView
        lwOrdreLinjer = new ListView<>();
        pane.add(lwOrdreLinjer,4,2,2,5);
        lwOrdreLinjer.setPrefWidth(350);
        lwOrdreLinjer.setPrefHeight(500);

        Button btnRegistrer = new Button("Færdiggør");
        pane.add(btnRegistrer,0,7);
        btnRegistrer.setPrefWidth(100);
        btnRegistrer.setOnAction(e -> {
            close();
        });

        lblSamletPris = new Label();
        pane.add(lblSamletPris,4,7);


        // Drop Down menu til Prislister
        cbbPrisliste = new ComboBox();
        pane.add(cbbPrisliste,0,0);
        cbbPrisliste.getItems().setAll(Controller.getPrisLister());
        cbbPrisliste.setPromptText("Vælg Prisliste");

        ChangeListener<Prisliste> prislisteChangeListener = (ov, oldPrisliste, newPrisliste) -> this.startOrdre();
        cbbPrisliste.getSelectionModel().selectedItemProperty().addListener(prislisteChangeListener);
    }

    //ListenerChanged
    private void selectedProduktGruppeChanged() {
        ProduktGruppe produktGruppe = lwProduktGruppe.getSelectionModel().getSelectedItem();
        ArrayList<Pris> priser = Controller.findPrisProduktGruppe(produktGruppe,prisliste);
        if (prisliste == null && cbbPrisliste.getSelectionModel().getSelectedItem() != null) {
            prisliste = cbbPrisliste.getSelectionModel().getSelectedItem();
        }
        if (produktGruppe != null && cbbPrisliste.getSelectionModel().getSelectedItem() != null) {
            lwProdukt.getItems().setAll(priser);
        }
    }

    private void startOrdre() {
        if (prisliste == null) {
            prisliste = cbbPrisliste.getSelectionModel().getSelectedItem();
        }
        if (ordre == null && cbbPrisliste.getSelectionModel().getSelectedItem() != null) {
            ordre = Controller.createOrdre(prisliste);
        }
    }
}
