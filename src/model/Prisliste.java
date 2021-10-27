package model;

import java.util.ArrayList;

public class Prisliste {
    String navn;
    ArrayList<Pris> prisliste = new ArrayList<>();

    public Prisliste(String navn) {

        this.navn = navn;
    }

    public Pris opretPris(Produkt produkt, double pris, Prisliste prisliste) {
        return null;
    }

    public void sletPris(Pris pris) {

    }
}
