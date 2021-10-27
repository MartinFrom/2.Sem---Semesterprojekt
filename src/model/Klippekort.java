package model;

public class Klippekort extends Produkt{
    private int klipSolgt;
    private int klipBrugt;

    public Klippekort (int klipSolgt, String navn, ProduktGruppe produktGruppe, Pris pris) {
        super(navn, produktGruppe, pris);
        this.klipSolgt = klipSolgt;
    }

    //getters og setters

    public int getKlipSolgt() {
        return klipSolgt;
    }

    public void setKlipSolgt(int klipSolgt) {
        this.klipSolgt = klipSolgt;
    }

    public int getKlipBrugt() {
        return klipBrugt;
    }

    public void setKlipBrugt(int klipBrugt) {
        this.klipBrugt = klipBrugt;
    }
}
