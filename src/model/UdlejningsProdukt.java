package model;

public class UdlejningsProdukt extends Produkt{
    private double pant;

    public UdlejningsProdukt (double pant, String navn, ProduktGruppe produktGruppe) {
        super(navn, produktGruppe);
        this.pant = pant;
    }

    public double getPant() {
        return pant;
    }

    public void setPant(double pant) {
        this.pant = pant;
    }

    @Override
    public String toString() {
        return super.toString() + " | Pant: " + getPant();
    }
}
