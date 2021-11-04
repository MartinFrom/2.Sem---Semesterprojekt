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
     * @param klipSolgt antal solgte klip
     * @param navn klippekort
     * @param produktGruppe navn på produktgruppe
     */
    public Klippekort (int klipSolgt, String navn, ProduktGruppe produktGruppe) {
        super(navn, produktGruppe);
        this.klipSolgt = klipSolgt;
    }

    //getters

    /**
     * Returnerer antal solgte klip for klippekort
     * @return antal solgte klip på klippekort
     * Pre: klippekort objekt eksisterer
     */
    public int getKlipSolgt() {
        return klipSolgt;
    }

    /**
     * Returnerer antal brugte klip for klippekort
     * @return antal brugte klip på klippekort
     * Pre: klippekort objekt eksisterer
     */
    public int getKlipBrugt() {
        return klipBrugt;
    }

    //setters

    /**
     * Registrerer antal solgte klip for klippekort
     * @param klipSolgt anatal solgte klip på klippekort
     * Pre: klippekort objekt eksisterer
     */
    public void setKlipSolgt(int klipSolgt) {
        this.klipSolgt = klipSolgt;
    }

    /**
     * Registrerer antal brugte klip for klippekort
     * @param klipBrugt antal brugte klip på klippekort
     * Pre: klippekort objekt eksisterer
     */
    public void setKlipBrugt(int klipBrugt) {
        this.klipBrugt = klipBrugt;
    }
}
