package model;

import java.util.ArrayList;

public class Ordre {
    private int ordreNr;
    private double samletPris;
    private Prisliste prisliste;
    private Betalingsform betalingsform;
    private ArrayList<OrdreLinje> ordrelinjer;

    public Ordre(int ordreNr, Prisliste prisliste, Betalingsform betalingsform) {
        this.ordreNr = ordreNr;
        this.prisliste = prisliste;
        this.betalingsform = betalingsform;
    }

    public opretOrdreLinje(int antal, Produkt produkt, double pris) {

    }

    public void sletOrdrelinje(OrdreLinje ordrelinje) {

    }

    public double beregnPris() {

    }
}
