package model;

import java.util.ArrayList;

public class Prisliste {
    String navn;
    ArrayList<Pris> prisliste = new ArrayList<>();

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
        return prisliste;
    }

    public void setPrisliste(ArrayList<Pris> prisliste) {
        this.prisliste = prisliste;
    }

    public Pris opretPris(Produkt produkt, double pris, Prisliste prisliste) {
        return null;
    }

    public void sletPris(Pris pris) {

    }
}
