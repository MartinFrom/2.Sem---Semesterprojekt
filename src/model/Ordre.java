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

    // getters og setters
    public int getOrdreNr() {
        return ordreNr;
    }

    public void setOrdreNr(int ordreNr) {
        this.ordreNr = ordreNr;
    }

    public double getSamletPris() {
        return samletPris;
    }

    public void setSamletPris(double samletPris) {
        this.samletPris = samletPris;
    }

    public Prisliste getPrisliste() {
        return prisliste;
    }

    public void setPrisliste(Prisliste prisliste) {
        this.prisliste = prisliste;
    }

    public Betalingsform getBetalingsform() {
        return betalingsform;
    }

    public void setBetalingsform(Betalingsform betalingsform) {
        this.betalingsform = betalingsform;
    }

    public ArrayList<OrdreLinje> getOrdrelinjer() {
        return new ArrayList<>(ordrelinjer);
    }

    public void setOrdrelinjer(ArrayList<OrdreLinje> ordrelinjer) {
        this.ordrelinjer = ordrelinjer;
    }

    public OrdreLinje opretOrdreLinje(int antal, Pris pris) {
        OrdreLinje OL = new OrdreLinje(antal, pris);
        ordrelinjer.add(OL);
        return OL;
    }

    public void sletOrdrelinje(OrdreLinje ordrelinje) {
        if (ordrelinjer.contains(ordrelinje)) {
            ordrelinjer.remove(ordrelinje);
        }
    }

    public double beregnPris() {
        double samletPris = 0;
        for (OrdreLinje o : ordrelinjer) {
            samletPris += o.samletPris();
        }
        return samletPris;
    }
}
