package model;

import java.time.LocalDate;

public class Arrangement extends Prisliste {

    private LocalDate dato;
    private int pladser;
    private int tilmeldte;

    public Arrangement(String navn, LocalDate dato, int pladser, int tilmeldte) {
        super(navn);
        this.dato = dato;
        this.pladser = pladser;
        this.tilmeldte = tilmeldte;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public int getPladser() {
        return pladser;
    }

    public void setPladser(int pladser) {
        this.pladser = pladser;
    }

    public int getTilmeldte() {
        return tilmeldte;
    }

    public void setTilmeldte(int tilmeldte) {
        this.tilmeldte = tilmeldte;
    }

 }
