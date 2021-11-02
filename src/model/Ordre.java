package model;

import java.util.ArrayList;

/**
 * Modellerer en ordre
 */
public class Ordre {
    private int ordreNr;
    private double samletPris;
    private boolean erBetalt;
    private Prisliste prisliste;
    private Betalingsform betalingsform;
    private ArrayList<OrdreLinje> ordrelinjer;

    /**
     * Initialiserer en ordre med ordreNr, prisliste og betalingsform
     * @param ordreNr ordreNr for ordren
     * @param prisliste prisliste for ordren
     */
    public Ordre(int ordreNr, Prisliste prisliste) {
        this.ordreNr = ordreNr;
        this.prisliste = prisliste;
    }

    //getters

    /**
     * Returnerer ordreNr for ordren
     * @return ordreNr på ordren
     * Pre: ordre objekt eksisterer
     */
    public int getOrdreNr() {
        return ordreNr;
    }

    /**
     * Returnerer den samlede pris for ordren
     * @return samlede pris på ordren
     * Pre: ordre objekt eksisterer
     */
    public double getSamletPris() {
        return samletPris;
    }

    /**
     * Returnerer prislisten for ordren
     * @return prislisten på ordren
     * Pre: ordre objekt eksisterer
     */
    public Prisliste getPrisliste() {
        return prisliste;
    }

    /**
     * Returnerer betalingsformen for ordren
     * @return betalingsform på ordren
     * Pre: ordre objekt eksisterer
     */
    public Betalingsform getBetalingsform() {
        return betalingsform;
    }

    /**
     * Returnerer en array liste med ordre linjerne for ordren
     * @return ordrelinjerne på ordren
     * Pre: ordre objekt eksisterer, OrdreLinje klassen eksisterer
     */
    public ArrayList<OrdreLinje> getOrdrelinjer() {
        return new ArrayList<>(ordrelinjer);
    }

    public boolean isErBetalt() {
        return erBetalt;
    }

    //setters


    public void setErBetalt(boolean erBetalt) {
        this.erBetalt = erBetalt;
    }

    /**
     * Registerer ordreNr for ordren
     * @param ordreNr ordreNr på ordren
     * Pre: ordre objekt eksisterer
     */
    public void setOrdreNr(int ordreNr) {
        this.ordreNr = ordreNr;
    }

    /**
     * Registrerer den samlede pris for ordren
     * @param samletPris den samlede pris på ordren
     * Pre: ordre objekt eksisterer
     */
    public void setSamletPris(double samletPris) {
        this.samletPris = samletPris;
    }

    /**
     * Registrerer den brugte prisliste for ordren
     * @param prisliste brugte prisliste på ordren
     * Pre: ordre objekt eksisterer, Prisliste objekt eksisterer
     */
    public void setPrisliste(Prisliste prisliste) {
        this.prisliste = prisliste;
    }

    /**
     * Registrerer den brugte betalingsform for ordren
     * @param betalingsform brugte betalingsform på ordren
     * Pre: ordre objekt eksisterer, betalingsform objekt eksisterer
     */
    public void setBetalingsform(Betalingsform betalingsform) {
        this.betalingsform = betalingsform;
    }

    /**
     * Registrerer ordrelinjer for ordren
     * @param ordrelinjer liste af ordrelinjer på ordren
     * Pre: ordre objekt eksisterer, Ordrelinje objekt eksisterer
     */
    public void setOrdrelinjer(ArrayList<OrdreLinje> ordrelinjer) {
        this.ordrelinjer = ordrelinjer;
    }

    //-------------------------------------------------------------------------------------

    /**
     * Initialiserer en ordrelinje med antal og pris
     * @param antal antal af valgte produkt på ordrelinje
     * @param pris pris for det valgte produkt
     * @return ordrelinje med antal og pris
     * Pre: Produkter eksisterer, pris klassen eksisterer
     */
    public OrdreLinje createOrdreLinje(int antal, Pris pris) {
        OrdreLinje OL = new OrdreLinje(antal, pris);
        ordrelinjer.add(OL);
        return OL;
    }

    /**
     * Denne metode slette en ordrelinje fra listen af ordrelinjer
     * @param ordrelinje ordrelinje
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
     * Pre: ordre objekt eksisterer
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
        return "Nr:" + getOrdreNr() + " | Type: Salg" + " | Pris: " + getSamletPris() + " | Betalt: Ja" + " | Betalingsform: " + getBetalingsform();
    }
}
