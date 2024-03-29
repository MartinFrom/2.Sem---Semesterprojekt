package storage;

import model.*;
import java.util.ArrayList;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 */

public class Storage {

    private static ArrayList<Ordre> ordrer = new ArrayList<>();
    private static ArrayList<Prisliste> prislister = new ArrayList<>();
    private static ArrayList<Produkt> produkter = new ArrayList<>();
    private static ArrayList<UdlejningsProdukt> udlejningsProdukter = new ArrayList<>();
    private static ArrayList<Udlejning> udlejninger = new ArrayList<>();
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private static ArrayList<ProduktGruppe> produktgrupper = new ArrayList<>();
    private static ArrayList<Pris> priser = new ArrayList<>();
    private static ArrayList<Betalingsform> betalingsformer = new ArrayList<>();

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

    //
    public static void addUdlejningsProdukt(UdlejningsProdukt produkt) {
        udlejningsProdukter.add(produkt);
    }

    public static void removeUdlejningsProdukt (UdlejningsProdukt produkt) {
        udlejningsProdukter.remove(produkt);
    }

    public static ArrayList<UdlejningsProdukt> getUdlejningsProdukter () {
        return new ArrayList<>(udlejningsProdukter);
    }

    //---------------------------------------------------------------------

    public static void addProduktGruppe(ProduktGruppe produktGruppe) {
        produktgrupper.add(produktGruppe);
    }

    public static void removeProduktGruppe(ProduktGruppe produktGruppe) {
        produktgrupper.remove(produktGruppe);
    }

    public static ArrayList<ProduktGruppe> getProduktgrupper() {
        return new ArrayList<>(produktgrupper);
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

    //------------------------------------------------------------------------

    public static void addPris(Pris pris) {
        priser.add(pris);
    }

    public static void deletePris(Pris pris) {
        priser.remove(pris);
    }

    public static ArrayList<Pris> getPriser() {
        return new ArrayList<>(priser);
    }

    //-------------------------------------------------------------------------

    public static void addBetalingsform(Betalingsform betalingsform) {
        betalingsformer.add(betalingsform);
    }

    public static ArrayList<Betalingsform> getBetalingsformer() {
        return new ArrayList<>(betalingsformer);
    }
}
