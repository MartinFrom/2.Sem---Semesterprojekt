package GUI;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Text;

import java.util.List;

public class OpretOrdreWindow extends Stage {

    private ListView lwProduktGruppe;
    private ListView lwProdukt;
    private ListView lwBetalingsform;
    private ListView lwOrdreLinjer;

    private TextField txfAntal;

    public OpretOrdreWindow(String title) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setTitle(title);

        BorderPane bPane = new BorderPane();
        GridPane gPane = GUIHelperClass.createGridPane(1200,500,10,10,50);
        bPane.setCenter(gPane);
        this.initContent(gPane);

        Scene scene = new Scene(bPane);
        setScene(scene);
    }

    private void initContent(GridPane pane) {
        // Produktgruppe
        Label lblProduktGruppe = new Label("Produktgruppe:");
        pane.add(lblProduktGruppe, 0, 0);
        //ListView
        lwProduktGruppe = new ListView<>();
        pane.add(lwProduktGruppe, 0, 1,1,5);
        lwProduktGruppe.setPrefHeight(500);
        lwProduktGruppe.setPrefWidth(200);
        lwProduktGruppe.getItems().setAll(Controller.getProduktGrupper());

        // Produkt
        Label lblProdukt = new Label("Produkter:");
        pane.add(lblProdukt, 1, 0);
        // ListView
        lwProdukt = new ListView<>();
        pane.add(lwProdukt, 1, 1,1,5);
        lwProdukt.setPrefWidth(350);
        lwProdukt.setPrefHeight(500);

        // Select antal og tilføj
        Label lblAntal = new Label("Antal:");
        pane.add(lblAntal,2,1);

        txfAntal = new TextField();
        pane.add(txfAntal,2,2);

        Button btnTilføjProdukt = new Button("Tilføj Produkt");
        pane.add(btnTilføjProdukt,2,3);
        btnTilføjProdukt.setPrefWidth(150);
        btnTilføjProdukt.setPrefHeight(100);

        Label lblBetaling = new Label("Betalingsform:");
        pane.add(lblBetaling,2,4);
        // ListView
        lwBetalingsform = new ListView<>();
        pane.add(lwBetalingsform,2,5);
        // TODO

        Label lblOrdreLinjer = new Label("Kurv:");
        pane.add(lblOrdreLinjer,4,0);
        // ListView
        lwOrdreLinjer = new ListView<>();
        pane.add(lwOrdreLinjer,4,1,2,5);
        lwOrdreLinjer.setPrefWidth(350);
        lwOrdreLinjer.setPrefHeight(500);
        // TODO

        CheckBox cbErBetalt = new CheckBox("Er betalt");
        pane.add(cbErBetalt,4,6);

        Button btnRegistrer = new Button("Registrer");
        pane.add(btnRegistrer,5,6);
        btnRegistrer.setPrefWidth(100);
    }
}
