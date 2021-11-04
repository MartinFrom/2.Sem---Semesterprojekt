package model;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 */

public class BetalingsformKontant implements Betalingsform {

    private String navn;

    public BetalingsformKontant(String navn) {
        this.navn = navn;
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
