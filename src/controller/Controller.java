package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;

public class Controller {

    // Produkt
    public static Produkt createProdukt(String navn, ProduktGruppe produktgruppe) {
        Produkt produkt = new Produkt(navn, produktgruppe);
        Storage.addProdukt(produkt);
        return produkt;
    }

    public static void deleteProdukt(Produkt produkt) {
        Storage.removeProdukt(produkt);
    }

    // Pris
    public static Pris createPris(Prisliste prisliste, Produkt produkt, double varePris) {
        Pris pris = prisliste.createPris(produkt, varePris);
        return pris;
    }

    public static void deletePris(Prisliste prisliste, Pris pris) {
        prisliste.removePris(pris);
    }

    // Prisliste
    public static Prisliste createPrisliste(String navn) {
        Prisliste prisliste = new Prisliste(navn);
        Storage.addPrisliste(prisliste);
        return prisliste;
    }

    public static void removePrisliste(Prisliste prisliste) {
        Storage.removePrisliste(prisliste);
    }

    // Ordre
    public static Ordre createOrdre(int ordreNr, Prisliste prisliste) {
        Ordre ordre = new Ordre(ordreNr, prisliste);
        Storage.addOrdre(ordre);
        return ordre;
    }

    public static void deleteOrdre(Ordre ordre) {
        Storage.removeOrdre(ordre);
    }

    // Ordrelinje
    public static OrdreLinje createOrdrelinje(int antal, Pris pris, Ordre ordre) {
        OrdreLinje ol = ordre.createOrdreLinje(antal, pris);
        return ol;
    }

    public static OrdreLinje deleteOrdreLinje(OrdreLinje ordrelinje, Ordre ordre) {
        ordre.removeOrdrelinje(ordrelinje);
        return ordrelinje;
    }

    // Udlejning
    public static Udlejning createUdlejning(LocalDate StartDato, LocalDate Slutdato, int ordreNr, Prisliste prisliste) {
        Udlejning udlejning = new Udlejning(StartDato, Slutdato, ordreNr, prisliste);
        Storage.addUdlejning(udlejning);
        return udlejning;
    }



}
