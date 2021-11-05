package model;

import java.util.ArrayList;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 *
 * Modellerer en prisliste
 */

public class Prisliste {
    private String navn;
    private ArrayList<Pris> priser = new ArrayList<>();

    /* UdlejningsPriser ArrayList: Static da Udlejning ikke er afhængig
     af prisliste og har sit eget Window i GUI´en. */
    private static ArrayList<Pris> udlejningsPriser = new ArrayList<>();

    /**
     * Initialiserer en prisliste med navn
     * @param navn
     */
    public Prisliste(String navn) {
        this.navn = navn;
    }

    //getters
    public String getNavn() {
        return navn;
    }

    public ArrayList<Pris> getPrisliste() {
        return priser;
    }

    public ArrayList<Pris> getUdlejningsPriser () {
        return new ArrayList<>(udlejningsPriser);
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
     */
    public Pris createPris(Produkt produkt, double varePris) {
        Pris pris = new Pris(varePris, produkt, this);
        priser.add(pris);
        return pris;
    }

    /**
     * Initialiserer udlejningspris med udlejningsprodukt og prisen på udlejningsproduktet
     * @param udlejningsProdukt
     * @param varePris
     */
    public Pris createUdlejningsPris(UdlejningsProdukt udlejningsProdukt, double varePris) {
        Pris pris = new Pris(varePris, udlejningsProdukt, this);
        udlejningsPriser.add(pris);
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
