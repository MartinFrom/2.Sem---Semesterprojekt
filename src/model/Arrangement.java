package model;

import java.time.LocalDate;

/**
 * Modellerer en prisliste for arrangement
 */
public class Arrangement extends Prisliste {

    private LocalDate dato;
    private int pladser;
    private int tilmeldte;

    /**
     * Initialiserer et arrangement med navn, dato, antal pladser og antal tilmeldte
     * @param navn navnet på arrangement
     * @param dato dato for arrangement
     * @param pladser antal pladser for arrangement
     * @param tilmeldte antal tilmeldte for arrangement
     */
    public Arrangement(String navn, LocalDate dato, int pladser, int tilmeldte) {
        super(navn);
        this.dato = dato;
        this.pladser = pladser;
        this.tilmeldte = tilmeldte;
    }

    //getters

    /**
     * Returnerer dato
     * @return dato for arrangement
     * Pre: arrangement objekt eksisterer
     */
    public LocalDate getDato() {
        return dato;
    }

    /**
     * Returnerer antallet af pladser til arrangementet
     * @return antal pladser på arrangement
     * Pre: arrangement objekt eksisterer
     */
    public int getPladser() {
        return pladser;
    }

    /**
     * Returnerer antal tilmeldte for arrangement
     * @return antal tilmeldte på arrangement
     * Pre: arrangement objekt eksisterer
     */
    public int getTilmeldte() {
        return tilmeldte;
    }

    //setters

    /**
     * Registrerer en dato for objektet arrangement
     * @param dato dato for arrangement
     * Pre: arrangement objekt eksisterer
     */
    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    /**
     * Registrerer et antal pladser for arrangement
     * @param pladser antal pladser for arrangement
     * Pre: arrangement objekt eksisterer
     */
    public void setPladser(int pladser) {
        this.pladser = pladser;
    }

    /**
     * Registrerer et antal tilmeldte for arrangement
     * @param tilmeldte antal tilmeldte på arrangement
     * Pre: arrangement objekt eksisterer
     */
    public void setTilmeldte(int tilmeldte) {
        this.tilmeldte = tilmeldte;
    }

 }
