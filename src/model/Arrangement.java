package model;

import java.time.LocalDate;

public class Arrangement extends Produkt {

    private LocalDate dato;
    private int pladser;
    private int tilmeldte;

    public Arrangement(String navn, ProduktGruppe produktGruppe, LocalDate dato, int pladser) {
        super(navn, produktGruppe);
        this.dato = dato;
        this.pladser = pladser;
    }

    // getters
    public LocalDate getDato() {
        return dato;
    }

    public int getPladser() {
        return pladser;
    }

    public int getTilmeldte() {
        return tilmeldte;
    }

    // setters
    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setPladser(int pladser) {
        this.pladser = pladser;
    }

    public void setTilmeldte(int tilmeldte) {
        this.tilmeldte = tilmeldte;
    }

 }
