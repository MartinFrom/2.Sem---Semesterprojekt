package GUI;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class OpretUdlejningWindow extends Stage {

    private ListView<Pris> lwUdlejningsProdukt;
    private ListView<Betalingsform> lwBetalingsform;
    private ListView<OrdreLinje> lwOrdreLinjer;

    private TextField txfAntal;
    private TextField txfPris;
    private TextField txfPant;

    private Udlejning udlejning;
    private OrdreLinje ordreLinje;
    private ArrayList<Pris> udlejningspriser = new ArrayList<>();

    private DatePicker datePicker;

    public OpretUdlejningWindow(String title) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setTitle(title);

        BorderPane bPane = new BorderPane();
        GridPane gPane = GUIHelperClass.createGridPane(1400,500,10,10,50);
        bPane.setCenter(gPane);
        this.initContent(gPane);

        Scene scene = new Scene(bPane);
        setScene(scene);
    }

    private void initContent(GridPane pane) {
        // Kalender
        datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        pane.add(datePicker, 0, 0);

        // UdlejningsProdukter
        Label lblUdlejningsProdukter = new Label("Udlejningsprodukter");
        pane.add(lblUdlejningsProdukter,0,1);
        // ListView
        lwUdlejningsProdukt = new ListView<>();
        pane.add(lwUdlejningsProdukt,0,2,1,5);
        lwUdlejningsProdukt.setPrefWidth(370);
        udlejningspriser = Controller.getUdlejningsPris();
        lwUdlejningsProdukt.getItems().setAll(udlejningspriser);

        // Select antal og tilføj
        Label lblAntal = new Label("Antal:");
        pane.add(lblAntal,1,1);

        txfAntal = new TextField();
        pane.add(txfAntal,1,2);
        txfAntal.setText("1");

        Button btnTilføjProdukt = new Button("Tilføj Produkt");
        pane.add(btnTilføjProdukt,1,3);
        btnTilføjProdukt.setPrefWidth(150);
        btnTilføjProdukt.setPrefHeight(100);
        btnTilføjProdukt.setOnAction(e -> {
            startUdlejning();
            ordreLinje = udlejning.createOrdreLinje(parseInt(txfAntal.getText()), lwUdlejningsProdukt.getSelectionModel().getSelectedItem());
            lwOrdreLinjer.getItems().add(ordreLinje);
            txfPris.setText(String.valueOf(udlejning.beregnUdlejningsPris()));
            txfPant.setText(String.valueOf(udlejning.beregnPant()));
        });

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
        lwOrdreLinjer.setPrefWidth(370);
        lwOrdreLinjer.setPrefHeight(500);
        // TODO

        CheckBox cbErBetalt = new CheckBox("Er betalt");
        pane.add(cbErBetalt,2,7);

        Button btnRegistrer = new Button("Registrer Udlejning");
        pane.add(btnRegistrer,3,7);
        btnRegistrer.setOnAction(e -> {
            if (cbErBetalt.isSelected()) {
                udlejning.setErBetalt(true);
            }
            close();
        });


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

    private void startUdlejning() {
        if (udlejning == null) {
            udlejning = Controller.createUdlejning(datePicker.getValue(), datePicker.getValue(), Controller.getPrisLister().get(1));
        }
    }
}
