package GUI;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application{
    private int mainWindowwidth = 1000;
    private int mainWindowheight = 500;

    private ListView lwOrdre;
    private ListView lwBetalingsform;
    private ListView lwOrdreLinjer;


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

        });

        Button btnOpretProdukt = new Button ("Opret Produkt");
        pane.add(btnOpretProdukt, 0,2);
        btnOpretProdukt.setPrefWidth(150);
        btnOpretProdukt.setAlignment(Pos.CENTER_LEFT);
        btnOpretProdukt.setOnAction(e -> {

        });

        Button btnBetaling = new Button ("Registrer" +"\n"+"betaling");
        pane.add(btnBetaling,2,5);
        btnBetaling.setPrefHeight(75);
        btnBetaling.setPrefWidth(75);
        btnBetaling.setOnAction(e -> {

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
        // TODO

        Label lblBetaling = new Label("Betalingsform:");
        pane.add(lblBetaling,2,3);
        // ListView
        lwBetalingsform = new ListView<>();
        pane.add(lwBetalingsform,2,4);
        lwBetalingsform.setPrefHeight(100);
        lwBetalingsform.setPrefWidth(150);
        // TODO

        Label lblOrdrelinje = new Label("Ordrelinjer:");
        pane.add(lblOrdrelinje,3,0);
        // ListView
        lwOrdreLinjer = new ListView<>();
        pane.add(lwOrdreLinjer,3,1,1,5);
        lwOrdreLinjer.setPrefWidth(200);
        lwOrdreLinjer.setPrefHeight(500);
        // TODO
    }
}
