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

    public OrdreLinje opretOrdreLinje(int antal, Produkt produkt, double pris) {
        return null;
    }

    public void sletOrdrelinje(OrdreLinje ordrelinje) {

    }

    public double beregnPris() {
        return 0;
    }
}
