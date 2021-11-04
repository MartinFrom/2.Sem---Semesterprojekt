package model;

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
