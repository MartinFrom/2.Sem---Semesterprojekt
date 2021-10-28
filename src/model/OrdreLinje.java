package model;

public class OrdreLinje {
    private Pris pris;
    private int antal;

    public OrdreLinje(int antal, Pris pris) {
        this.antal = antal;
        this.pris = pris;
    }

    //getters

    public int getAntal() {
        return antal;
    }

    public Pris getPris() {
        return pris;
    }

    //setters

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public void setPris(Pris pris) {
        this.pris = pris;
    }

    //-------------------------------------------------------------------------

    /**
     * Denne metode finder prisen på et enkelt produkt
     * @return pris på enkelt produkt
     */
    public double findProduktPris() {
        return pris.getPris();
    }

    /**
     * Denne metode finder den samlede pris for ordrelinjen
     * @return samlet pris på ordrelinjen
     */
    public double samletPris() {
        double oPris = 0;
        oPris = findProduktPris() * antal;
        return oPris;
    }
}
