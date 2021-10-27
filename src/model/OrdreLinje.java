package model;

public class OrdreLinje {
    private Pris pris;
    private int antal;
    private double oPris;


    public OrdreLinje(int antal, double oPris, Pris pris) {
        this.antal = antal;
        this.oPris = oPris;
        this.pris = pris;
    }

    // getters og setters
    public void setoPris(double pris) {
        this.oPris = oPris;
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
        return 0;
    }
}
