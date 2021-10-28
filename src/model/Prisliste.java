package model;

import java.util.ArrayList;

public class Prisliste {
    String navn;
    ArrayList<Pris> priser = new ArrayList<>();

    public Prisliste(String navn) {
        this.navn = navn;
    }

    // getters og setters
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Pris> getPrisliste() {
        return new ArrayList<>(priser);
    }

    public void setPrisliste(ArrayList<Pris> prisliste) {
        this.priser = prisliste;
    }

    public Pris opretPris(Produkt produkt, double varePris) {
        Pris pris = new Pris(varePris, produkt, this);
        priser.add(pris);
        return pris;

    }

    public void sletPris(Pris pris) {
        priser.remove(pris);
    }
}
