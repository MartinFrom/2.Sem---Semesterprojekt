package GUI;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Text;

import java.time.LocalDate;

public class OpretUdlejningWindow extends Stage {

    private ListView lwUdlejningsProdukt;
    private ListView lwBetalingsform;
    private ListView lwOrdreLinjer;

    private TextField txfAntal;
    private TextField txfPris;
    private TextField txfPant;

    public OpretUdlejningWindow(String title) {
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
        // Kalender
        DatePicker DatePicker = new DatePicker();
        DatePicker.setValue(LocalDate.now());
        pane.add(DatePicker, 0, 0);

        // UdlejningsProdukter
        Label lblUdlejningsProdukter = new Label("Udlejningsprodukter");
        pane.add(lblUdlejningsProdukter,0,1);
        // ListView
        lwUdlejningsProdukt = new ListView<>();
        pane.add(lwUdlejningsProdukt,0,2,1,5);

        // Select antal og tilføj
        Label lblAntal = new Label("Antal:");
        pane.add(lblAntal,1,1);

        txfAntal = new TextField();
        pane.add(txfAntal,1,2);

        Button btnTilføjProdukt = new Button("Tilføj Produkt");
        pane.add(btnTilføjProdukt,1,3);
        btnTilføjProdukt.setPrefWidth(150);
        btnTilføjProdukt.setPrefHeight(100);

        Label lblBetaling = new Label("Betalingsform:");
        pane.add(lblBetaling,1,4);
        // ListView
        lwBetalingsform = new ListView<>();
        pane.add(lwBetalingsform,1,5);

        // ListView Kurv
        Label lblOrdreLinjer = new Label("Kurv:");
        pane.add(lblOrdreLinjer,2,1);
        // ListView
        lwOrdreLinjer = new ListView<>();
        pane.add(lwOrdreLinjer,2,2,2,5);
        lwOrdreLinjer.setPrefWidth(350);
        lwOrdreLinjer.setPrefHeight(500);
        // TODO

        CheckBox cbErBetalt = new CheckBox("Er betalt");
        pane.add(cbErBetalt,2,7);

        Button btnRegistrer = new Button("Registrer Udlejning");
        pane.add(btnRegistrer,3,7);
        btnRegistrer.setPrefWidth(100);

        // Pris og pant
        Label lblPris = new Label ("Samlet Pris:");
        pane.add(lblPris,4,2);

        Label lblPant = new Label ("Samlet Pant:");
        pane.add(lblPant,4,3);

        txfPris = new TextField();
        pane.add(txfPris,5,2);

        txfPant = new TextField();
        pane.add(txfPant,5,3);
    }
}
