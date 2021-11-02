package GUI;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ProduktGruppe;


public class OpretProduktGruppeWindow extends Stage {

    private ListView lwProduktGruppe;
    private TextField tfxOpretProduktGruppe;
    private ProduktGruppe produktGruppe;

    public OpretProduktGruppeWindow(String title) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setTitle(title);

        BorderPane bPane = new BorderPane();
        GridPane gPane = GUIHelperClass.createGridPane(450,450,10,10,50);
        bPane.setCenter(gPane);
        this.initContent(gPane);

        Scene scene = new Scene(bPane);
        setScene(scene);
    }

    private void initContent(GridPane pane) {
        Label lblProduktGruppe= new Label("Produktgrupper:");
        pane.add(lblProduktGruppe, 0, 2);
        //ListView
        lwProduktGruppe = new ListView<>();
        pane.add(lwProduktGruppe, 0, 4);
        lblProduktGruppe.setVisible(true);
        lwProduktGruppe.setVisible(true);
        lwProduktGruppe.setPrefHeight(500);
        lwProduktGruppe.setPrefWidth(250);
        lwProduktGruppe.getItems().setAll(Controller.getProduktGrupper());

        Label lbNavn = new Label("Navn produktgruppe");
        pane.add(lbNavn, 2, 0);
        TextField txfNavn = new TextField();
        pane.add(txfNavn, 2, 1);

        //Opret produktgruppe
        Button btnOpretProduktGruppe = new Button("Opret produktgruppe");
        pane.add(btnOpretProduktGruppe, 0, 1);
        btnOpretProduktGruppe.setOnAction(e -> {
           produktGruppe = Controller.createProduktGruppe(txfNavn.getText());
           lwProduktGruppe.getItems().add(produktGruppe);

        });


    }
}


