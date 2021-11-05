package model;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 *
 * Modellerer et klippekort
 */
public class Klippekort extends Produkt{
    private int klipSolgt;
    private int klipBrugt;

    /**
     * Initialiserer et klippekort med antal solgte klip, navn og produktgruppe
     * @param klipSolgt
     * @param navn
     * @param produktGruppe
     */
    public Klippekort (int klipSolgt, String navn, ProduktGruppe produktGruppe) {
        super(navn, produktGruppe);
        this.klipSolgt = klipSolgt;
    }

    //getters
    public int getKlipSolgt() {
        return klipSolgt;
    }

    public int getKlipBrugt() {
        return klipBrugt;
    }

    //setters
    public void setKlipSolgt(int klipSolgt) {
        this.klipSolgt = klipSolgt;
    }

    public void setKlipBrugt(int klipBrugt) {
        this.klipBrugt = klipBrugt;
    }
}
