package model;

public class UdlejningsProdukt extends Produkt{
    private double pant;

    public UdlejningsProdukt (double pant, String navn, ProduktGruppe produktGruppe, Pris pris) {
        super(navn, produktGruppe, pris);
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
}
