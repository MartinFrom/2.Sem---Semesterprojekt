package model;

import java.util.ArrayList;

public class Prisliste {
    String navn;
    ArrayList<Pris> prisliste = new ArrayList<>();
    private Pris pris;

    public Prisliste(String navn) {

        this.navn = navn;
    }
}
