package model;

import java.util.ArrayList;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 *
 * Modellerer en ordre
 */
public class Ordre {
    private int ordreNr;
    private double samletPris;
    private Prisliste prisliste;
    private Betalingsform betalingsform;
    private ArrayList<OrdreLinje> ordrelinjer = new ArrayList<>();

    /**
     * Initialiserer en ordre med ordreNr og prisliste
     * @param ordreNr
     * @param prisliste
     */
    public Ordre(int ordreNr, Prisliste prisliste) {
        this.ordreNr = ordreNr;
        this.prisliste = prisliste;
    }

    //getters
    public int getOrdreNr() {
        return ordreNr;
    }

    public double getSamletPris() {
        return samletPris;
    }

    public Prisliste getPrisliste() {
        return prisliste;
    }

    public Betalingsform getBetalingsform() {
        return betalingsform;
    }

    public ArrayList<OrdreLinje> getOrdrelinjer() {
        return new ArrayList<>(ordrelinjer);
    }

    //setters
    public void setOrdreNr(int ordreNr) {
        this.ordreNr = ordreNr;
    }

    public void setSamletPris(double samletPris) {
        this.samletPris = samletPris;
    }

    public void setPrisliste(Prisliste prisliste) {
        this.prisliste = prisliste;
    }

    public void setBetalingsform(Betalingsform betalingsform) {
        this.betalingsform = betalingsform;
    }

    public void setOrdrelinjer(ArrayList<OrdreLinje> ordrelinjer) {
        this.ordrelinjer = ordrelinjer;
    }

    //-------------------------------------------------------------------------------------

    /**
     * Initialiserer en ordrelinje med antal og pris
     * @param antal
     * @param pris
     * @return ordrelinje med antal og pris
     */
    public OrdreLinje createOrdreLinje(int antal, Pris pris) {
        if (antal <= 0) {
            throw new IllegalArgumentException("Antal skal være større end 0");
        }

        OrdreLinje OL = new OrdreLinje(antal, pris);
        ordrelinjer.add(OL);
        return OL;
    }

    /**
     * Denne metode sletter en ordrelinje fra listen af ordrelinjer
     * @param ordrelinje
     * Pre: Ordrelinje eksisterer
     */
    public void removeOrdrelinje(OrdreLinje ordrelinje) {
        if (ordrelinjer.contains(ordrelinje)) {
            ordrelinjer.remove(ordrelinje);
        }
    }

    /**
     * Denne metode beregner den samlede pris for odren
     * @return samlet pris for ordren
     * Pre: Ordrelinje eksisterer
     */
    public double beregnPris() {
        this.samletPris = 0;
        for (OrdreLinje o : ordrelinjer) {
            samletPris += o.samletPris();
        }
        return samletPris;
    }

    @Override
    public String toString() {
        return "Nr:" + getOrdreNr() + " | Type: Salg" + " | Pris: " + beregnPris() + " | Betalt: True" + " | Betalingsform: " + getBetalingsform();
    }
}
