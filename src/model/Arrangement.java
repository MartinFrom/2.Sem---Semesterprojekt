package model;

import java.time.LocalDate;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 *
 * Modellerer en prisliste for arrangement
 */
public class Arrangement extends Prisliste {

    private LocalDate dato;
    private int pladser;
    private int tilmeldte;

    /**
     * Initialiserer et arrangement med navn, dato og antal pladser
     * @param navn navnet på arrangement
     * @param dato dato for arrangement
     * @param pladser antal pladser for arrangement
     */
    public Arrangement(String navn, LocalDate dato, int pladser) {
        super(navn);
        this.dato = dato;
        this.pladser = pladser;
    }

    //getters
    public LocalDate getDato() {
        return dato;
    }

    public int getPladser() {
        return pladser;
    }

    public int getTilmeldte() {
        return tilmeldte;
    }

    //setters
    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setPladser(int pladser) {
        this.pladser = pladser;
    }

    public void setTilmeldte(int tilmeldte) {
        this.tilmeldte = tilmeldte;
    }

    @Override
    public String toString() {
        return "Navn: " + getNavn() + "| Antal pladser: " + getPladser() + " | Dato: " + getDato();
    }
}
