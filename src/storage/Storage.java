package storage;

import model.*;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Ordre> ordrer = new ArrayList<>();
    private ArrayList<Prisliste> prislister = new ArrayList<>();
    private ArrayList<Produkt> produkter = new ArrayList<>();
    private ArrayList<Udlejning> udlejninger = new ArrayList<>();
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();

    //---------------------------------------------------------------

    public void addOrdre(Ordre ordre) {
        ordrer.add(ordre);
    }

    public void removeOrdre(Ordre ordre) {
        ordrer.remove(ordre);
    }

    public ArrayList<Ordre> getOrdrer() {
        return new ArrayList<>(ordrer);
    }

    //------------------------------------------------------------------

    public void addPrisliste(Prisliste prisliste) {
        prislister.add(prisliste);
    }

    public void removePrisliste(Prisliste prisliste) {
        prislister.remove(prisliste);
    }

    public ArrayList<Prisliste> getPrislister() {
        return new ArrayList<>(prislister);
    }

    //----------------------------------------------------------------------

    public void addProdukt(Produkt produkt) {
        produkter.add(produkt);
    }

    public void removeProdukt(Produkt produkt) {
        produkter.remove(produkt);
    }

    public ArrayList<Produkt> getProdukter() {
        return new ArrayList<>(produkter);
    }

    //---------------------------------------------------------------------

    public void addUdlejning(Udlejning udlejning) {
        udlejninger.add(udlejning);
    }

    public void removeUdlejning(Udlejning udlejning) {
        udlejninger.remove(udlejning);
    }

    public ArrayList<Udlejning> getUdlejninger() {
        return new ArrayList<>(udlejninger);
    }

    //-----------------------------------------------------------------------

    public void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    public void removeArrangement(Arrangement arrangement) {
        arrangementer.remove(arrangement);
    }

    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

}
