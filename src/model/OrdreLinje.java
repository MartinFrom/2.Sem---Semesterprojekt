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

    public double findProduktPris() {
        return 0;
    }
}
