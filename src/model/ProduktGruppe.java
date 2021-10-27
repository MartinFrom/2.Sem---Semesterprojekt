package model;

import java.util.ArrayList;

public class ProduktGruppe {
    private String navn;

    private ArrayList<Produkt> produkter = new ArrayList<>();

    public ProduktGruppe(String navn) {
        this.navn = navn;
    }

    //-----------------------------Associering til "Produkt"----------------------------------------
    public Produkt createProdukt(String navn, int produktnummer) {
        Produkt produkt = new Produkt(navn, this);
        produkter.add(produkt);
        return produkt;
    }

    public void addProdukt(Produkt produkt) {
        if (!produkter.contains(produkt)) {
            produkter.add(produkt);
        }
    }

    public void removeProdukt(Produkt produkt) {
        if (produkter.contains(produkt)) {
            produkter.remove(produkt);
        }
    }
    //---------------------------------------------------------------------
    //getters og setters

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Produkt> getProdukter() {
        return produkter;
    }

    public void setProdukter(ArrayList<Produkt> produkter) {
        this.produkter = produkter;
    }
}
