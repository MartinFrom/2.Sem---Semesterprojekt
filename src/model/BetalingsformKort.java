package model;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 */

public class BetalingsformKort implements Betalingsform {

    private String navn;
    private int kortNr;
    private int CVV;
    private int udløbsÅr;
    private int udløbsMåned;

    public BetalingsformKort(String navn, int kortNr, int CVV, int udløbsÅr, int udløbsMåned) {
        this.navn = navn;
        this.kortNr = kortNr;
        this.CVV = CVV;
        this.udløbsÅr = udløbsÅr;
        this.udløbsMåned = udløbsMåned;
    }

    @Override
    public void betaling(double pris) {

    }

    public String getNavn() {
        return navn;
    }

    public String toString() {
        return getNavn();
    }
}
