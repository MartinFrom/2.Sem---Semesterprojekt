package model;

import java.util.ArrayList;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 *
 * Modellerer en produktgruppe
 */

public class ProduktGruppe {
    private String navn;

    private ArrayList<Produkt> produkter = new ArrayList<>();

    /**
     * Initialiserer en produktgruppe med et navn
     * @param navn
     */
    public ProduktGruppe(String navn) {
        this.navn = navn;
    }

    //-----------------------------Associering til "Produkt"----------------------------------------

    /**
     * Initialiserer et produkt med et navn og sammensætter det oprettet produkt med den dertilhørende
     * produktgruppe. Tilføjer også produktet til en arrayliste af produkter
     * @param navn
     * @return
     */
    public Produkt createProdukt(String navn) {
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

    //getters
    public String getNavn() {
        return navn;
    }

    public ArrayList<Produkt> getProdukter() {
        return new ArrayList<>(produkter);
    }

    // setters
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setProdukter(ArrayList<Produkt> produkter) {
        this.produkter = produkter;
    }

    @Override
    public String toString() {
        return "" + getNavn();
    }
}
