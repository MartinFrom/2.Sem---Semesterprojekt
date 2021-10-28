package model;

public class OrdreLinje {
    private Pris pris;
    private int antal;

    public OrdreLinje(int antal, Pris pris) {
        this.antal = antal;
        this.pris = pris;
    }

    // getters og setters

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

    public double samletPris() {
        double oPris = pris.getPris() * antal;
        return oPris;
    }
}
