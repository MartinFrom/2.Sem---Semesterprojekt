package model;

public class Klippekort extends Produkt{
    private int klipSolgt;
    private int klipBrugt;

    public Klippekort (int klipSolgt, String navn, ProduktGruppe produktGruppe) {
        super(navn, produktGruppe);
        this.klipSolgt = klipSolgt;
    }


}
