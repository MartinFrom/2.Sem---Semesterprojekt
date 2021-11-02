package model;

import java.util.ArrayList;

public class Prisliste {
    private String navn;
    private static ArrayList<Pris> priser = new ArrayList<>();

    public Prisliste(String navn) {
        this.navn = navn;
    }

    //getters

    public String getNavn() {
        return navn;
    }

    public ArrayList<Pris> getPrisliste() {
        return new ArrayList<>(priser);
    }

    //setters

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setPrisliste(ArrayList<Pris> prisliste) {
        this.priser = prisliste;
    }

    //-----------------------------------------------------------------------------

    /**
     * Initialiserer pris med produkt og prisen på produktet
     * @param produkt
     * @param varePris
     * @return
     */
    public Pris createPris(Produkt produkt, double varePris) {
        Pris pris = new Pris(varePris, produkt, this);
        priser.add(pris);
        return pris;
    }

    public void removePris(Pris pris) {
        priser.remove(pris);
    }

    @Override
    public String toString() {
        return "Navn: " + getNavn();
    }
}
