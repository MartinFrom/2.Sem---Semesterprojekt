package model;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 *
 * Modellerer en pris
 */

public class Pris {
    private double pris;
    private Produkt produkt;
    private Prisliste prisliste;
    private UdlejningsProdukt udlejningsProdukt = null;

    /**
     * Initialiserer en pris med prisen for et bestemt produkt og prisliste
     * @param pris
     * @param produkt
     * @param prisliste
     */
    public Pris(double pris, Produkt produkt, Prisliste prisliste) {
        this.pris = pris;
        this.produkt = produkt;
        this.prisliste = prisliste;
    }

    /**
     * Initialiserer en pris med prisen for det valgte udlejningsprodukt og prisliste
     * @param pris
     * @param udlejningsProdukt
     * @param prisliste
     */
    public Pris(double pris, UdlejningsProdukt udlejningsProdukt, Prisliste prisliste) {
        this.pris = pris;
        this.udlejningsProdukt = udlejningsProdukt;
        this.prisliste = prisliste;
    }

    //getters
    public double getPris() {
        return pris;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public Prisliste getPrisliste() {
        return prisliste;
    }

    public UdlejningsProdukt getUdlejningsProdukt() {
        return udlejningsProdukt;
    }

    //setters
    public void setPris(double pris) {
        this.pris = pris;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public void setPrisliste(Prisliste prisliste) {
        this.prisliste = prisliste;
    }

    public void setUdlejningsProdukt(UdlejningsProdukt udlejningsProdukt) {
        this.udlejningsProdukt = udlejningsProdukt;
    }

    @Override
    public String toString() {
        if (udlejningsProdukt == null) {
            return getProdukt() + " | Pris: " + getPris() + "kr";
        } else
            return getUdlejningsProdukt() + " | Pris: " + getPris() + "kr";
    }
}
