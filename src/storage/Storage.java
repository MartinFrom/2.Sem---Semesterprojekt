package storage;

import model.*;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Ordre> ordrer = new ArrayList<>();
    private static ArrayList<Prisliste> prislister = new ArrayList<>();
    private static ArrayList<Produkt> produkter = new ArrayList<>();
    private static ArrayList<Udlejning> udlejninger = new ArrayList<>();
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();

    //---------------------------------------------------------------

    public static void addOrdre(Ordre ordre) {
        ordrer.add(ordre);
    }

    public static void removeOrdre(Ordre ordre) {
        ordrer.remove(ordre);
    }

    public static ArrayList<Ordre> getOrdrer() {
        return new ArrayList<>(ordrer);
    }

    //------------------------------------------------------------------

    public static void addPrisliste(Prisliste prisliste) {
        prislister.add(prisliste);
    }

    public static void removePrisliste(Prisliste prisliste) {
        prislister.remove(prisliste);
    }

    public static ArrayList<Prisliste> getPrislister() {
        return new ArrayList<>(prislister);
    }

    //----------------------------------------------------------------------

    public static void addProdukt(Produkt produkt) {
        produkter.add(produkt);
    }

    public static void removeProdukt(Produkt produkt) {
        produkter.remove(produkt);
    }

    public static ArrayList<Produkt> getProdukter() {
        return new ArrayList<>(produkter);
    }

    //---------------------------------------------------------------------

    public static void addUdlejning(Udlejning udlejning) {
        udlejninger.add(udlejning);
    }

    public static void removeUdlejning(Udlejning udlejning) {
        udlejninger.remove(udlejning);
    }

    public static ArrayList<Udlejning> getUdlejninger() {
        return new ArrayList<>(udlejninger);
    }

    //-----------------------------------------------------------------------

    public static void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    public static void removeArrangement(Arrangement arrangement) {
        arrangementer.remove(arrangement);
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

}
