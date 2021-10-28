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
     * Initialiserer en ny prisliste for arrangement
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

    // getters og setters

    /**
     * Returnerer dato
     * @return dato for arrangement
     * Pre: arrangement objekt eksisterer
     */
    public LocalDate getDato() {
        return dato;
    }

    /**
     * Registrerer en dato for objektet arrangement
     * @param dato ny dato for arrangement
     * Pre: arrangement objekt eksisterer
     */
    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    /**
     * Returnerer antallet af pladser til arrangementet
     * @return pladser på arrangement
     * Pre: arrangement objekt eksisterer
     */
    public int getPladser() {
        return pladser;
    }

    /**
     * Registrerer et antal pladser for arrangement
     * @param pladser nyt antal pladser for arrangement
     * Pre: arrangement objekt eksisterer
     */
    public void setPladser(int pladser) {
        this.pladser = pladser;
    }

    /**
     * Returnerer antal tilmeldte for arrangement
     * @return tilmeldte på arrangement
     * Pre: arrangement objekt eksisterer
     */
    public int getTilmeldte() {
        return tilmeldte;
    }

    /**
     * Registrerer et antal tilmeldte for arrangement
     * @param tilmeldte nyt antal tilmelde på arrangement
     * Pre: arrangement objekt eksisterer
     */
    public void setTilmeldte(int tilmeldte) {
        this.tilmeldte = tilmeldte;
    }

 }
