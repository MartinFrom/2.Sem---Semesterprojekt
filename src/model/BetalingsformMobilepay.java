package model;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 */

public class BetalingsformMobilepay implements Betalingsform {

    private String navn;
    private int mobilNr;

    public BetalingsformMobilepay(String navn, int mobilNr) {
        this.navn = navn;
        this.mobilNr = mobilNr;
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
