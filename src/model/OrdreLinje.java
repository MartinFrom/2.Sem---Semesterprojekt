package model;

public class OrdreLinje {
    private Pris pris;
    private int antal;
    private double oPris;

    public OrdreLinje(int antal, Pris pris) {
        this.antal = antal;
        this.pris = pris;
    }

    // getters og setters
    public void setoPris(double pris) {
        this.oPris = pris;
    }

    public double getoPris() {
        return oPris;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public Pris getPris() {
        return pris;
    }

    public void setPris(Pris pris) {
        this.pris = pris;
    }

    public double findProduktPris() {
        return pris.getPris();
    }

    public double samletPris() {
        oPris = findProduktPris() * antal;
        return oPris;
    }
}
