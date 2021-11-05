package model;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 *
 * Modellerer et udlejningsprodukt
 */

public class UdlejningsProdukt extends Produkt{
    private double pant;

    /**
     * Initialiserer et udlejningsprodukt med pant, navn og en produktgruppe
     * @param pant
     * @param navn
     * @param produktGruppe
     */
    public UdlejningsProdukt (double pant, String navn, ProduktGruppe produktGruppe) {
        super(navn, produktGruppe);
        this.pant = pant;
    }

    //getters
    public double getPant() {
        return pant;
    }

    //setters
    public void setPant(double pant) {
        this.pant = pant;
    }

    @Override
    public String toString() {
        return super.toString() + " | Pant: " + getPant();
    }
}
