package model;

public class OrdreLinje {
    private Produkt produkt;
    private int antal;
    private double pris;


    public OrdreLinje(int antal, double pris, Produkt produkt) {
        this.antal = antal;
        this.pris = pris;
        this.produkt = produkt;
    }

    // getters og setters
    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public double findProduktPris() {
        return 0;
    }
}
