package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    //ProduktGruppe
    public static ProduktGruppe createProduktGruppe(String navn) {
        ProduktGruppe produktGruppe = new ProduktGruppe(navn);
        Storage.addProduktGruppe(produktGruppe);
        return produktGruppe;
    }

    public static void deleteProduktGruppe(ProduktGruppe produktGruppe) {
        Storage.removeProduktGruppe(produktGruppe);
    }

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

    public static Arrangement createArrangement(String navn, LocalDate dato, int pladser) {
        Arrangement arrangement = new Arrangement(navn, dato, pladser);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static void removeArrangement(Arrangement arrangement) {
        Storage.removeArrangement(arrangement);
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

    // Getters
    public static ArrayList<ProduktGruppe> getProduktGrupper () {
        return new ArrayList<ProduktGruppe>(Storage.getProduktgrupper());
    }

    public static ArrayList<Prisliste> getPrisLister () {
        return new ArrayList<Prisliste>(Storage.getPrislister());
    }

    public static ArrayList<Ordre> getOrdrer() {
        return new ArrayList<Ordre>(Storage.getOrdrer());
    }

    public static void initStorage() {

        // ProduktGruppe
        ProduktGruppe flaskeøl = Controller.createProduktGruppe("Flaskeøl");
        ProduktGruppe fadøl = Controller.createProduktGruppe("Fadøl");
        ProduktGruppe spiritus = Controller.createProduktGruppe("Spiritus");
        ProduktGruppe fustage = Controller.createProduktGruppe("Fustage");
        ProduktGruppe kulsyre = Controller.createProduktGruppe("Kulsyre");
        ProduktGruppe malt = Controller.createProduktGruppe("Malt");
        ProduktGruppe beklædning = Controller.createProduktGruppe("Beklædning");
        ProduktGruppe anlæg = Controller.createProduktGruppe("Anlæg");
        ProduktGruppe glas = Controller.createProduktGruppe("Glas");
        ProduktGruppe sampakninger = Controller.createProduktGruppe("Sampakninger");
        ProduktGruppe rundvisning = Controller.createProduktGruppe("Rundvisning");

        //Produkt - flaskeøl
        Produkt klosterbrygFlaske = Controller.createProdukt("Klosterbryg", flaskeøl);
        Produkt sweetGeorgiaBrownFlaske = Controller.createProdukt("Sweet Georgia Brown", flaskeøl);
        Produkt extraPilsnerFlaske = Controller.createProdukt("Extra Pilsner", flaskeøl);
        Produkt celebrationFlaske = Controller.createProdukt("Celebration", flaskeøl);
        Produkt blondieFlaske = Controller.createProdukt("Blondie", flaskeøl);
        Produkt forårsbrygFlaske = Controller.createProdukt("Forårsbryg", flaskeøl);
        Produkt indiaPaleAleFlaske = Controller.createProdukt("India Pale Ale", flaskeøl);
        Produkt julebrygFlaske = Controller.createProdukt("Julebryg", flaskeøl);
        Produkt juletøndenFlaske = Controller.createProdukt("Juletønden", flaskeøl);
        Produkt oldStrongAleFlaske = Controller.createProdukt("Old Strong Ale", flaskeøl);
        Produkt fregattenJyllandFlaske = Controller.createProdukt("Fregatten Jylland", flaskeøl);
        Produkt imperialStoutFlaske = Controller.createProdukt("Imperial Stout", flaskeøl);
        Produkt tributeFlaske = Controller.createProdukt("Tribute", flaskeøl);
        Produkt blackMonsterFlaske = Controller.createProdukt("Black Monster", flaskeøl);

        //Produkt - fadøl
        Produkt klosterbrygFad = Controller.createProdukt("Klosterbryg", fadøl);
        Produkt jazzClasicFad = Controller.createProdukt("Jazz Classic", fadøl);
        Produkt extraPilsnerFad = Controller.createProdukt("Extra Pilsner", fadøl);
        Produkt celebrationFad = Controller.createProdukt("Celebration", fadøl);
        Produkt blondieFad = Controller.createProdukt("Blondie", fadøl);
        Produkt forårsbrygFad = Controller.createProdukt("Forårsbryg", fadøl);
        Produkt indiaPaleAleFad = Controller.createProdukt("India Pale Ale", fadøl);
        Produkt julebrygFad = Controller.createProdukt("Julebryg", fadøl);
        Produkt imperialStoutFad = Controller.createProdukt("Imperial Stout", fadøl);
        Produkt SpecialFad = Controller.createProdukt("Special", fadøl);
        Produkt æblebrusFad = Controller.createProdukt("Æblebrus", fadøl);
        Produkt chipsFad = Controller.createProdukt("Chips", fadøl);
        Produkt peanutsFad = Controller.createProdukt("Peanuts", fadøl);
        Produkt colaFad = Controller.createProdukt("Cola", fadøl);
        Produkt nikolineFad = Controller.createProdukt("Nikoline", fadøl);
        Produkt sevenUpFad = Controller.createProdukt("7-Up", fadøl);
        Produkt vandFad = Controller.createProdukt("Vand", fadøl);
        Produkt ølpølserFad = Controller.createProdukt("Ølpølser", fadøl);


        //Produkt - spiritus
        Produkt whisky45Procent50Cl = Controller.createProdukt("Whisky 45% - 50cl rør", spiritus);
        Produkt whisky4cl = Controller.createProdukt("Whisky 4 cl.", spiritus);
        Produkt whisky43Procent50Cl = Controller.createProdukt("Whisky 43% - 50cl rør", spiritus);
        Produkt uEgesplint = Controller.createProdukt("Uden egesplint", spiritus);
        Produkt mEgesplint = Controller.createProdukt("Med egesplint", spiritus);
        Produkt ToGangeWhiskyGlas = Controller.createProdukt("2 gange whisky glas + brikker", spiritus);
        Produkt liquorOfAarhus = Controller.createProdukt("Liquor of Aarhus", spiritus);
        Produkt lyngGin50cl = Controller.createProdukt("Lyng gin 50 cl", spiritus);
        Produkt lyngGin4cl = Controller.createProdukt("Lyng gin 4 cl", spiritus);

        //Produkt - fustage
        Produkt klosterbryg20L = Controller.createProdukt("Klosterbryg 20 liter", fustage);
        Produkt jazzClasic25L = Controller.createProdukt("Jazz Clasic 25 liter", fustage);
        Produkt extraPilsner25L = Controller.createProdukt("Jazz Clasic 25 liter", fustage);
        Produkt celebration20L = Controller.createProdukt("Celebration 20 liter", fustage);
        Produkt blondie25L = Controller.createProdukt("Blondie 25 liter", fustage);
        Produkt forårsbryg20L = Controller.createProdukt("Forårsbryg 20 liter", fustage);
        Produkt indiaPaleAle20L = Controller.createProdukt("India Pale Ale 20 liter", fustage);
        Produkt julebryg20L = Controller.createProdukt("Julebryg 20 liter", fustage);
        Produkt imperialStout = Controller.createProdukt("Imperial Stout 20 liter", fustage);
        Produkt pantFustage = Controller.createProdukt("Pant fustage", fustage);

        //Produkt - kulsyre
        Produkt kulsyre6kg = Controller.createProdukt("6 kg kulsyre", kulsyre);
        Produkt pantKulsyre = Controller.createProdukt("Pant kulsyre", kulsyre);
        Produkt kulsyre4kg = Controller.createProdukt("4 kg kulsyre", kulsyre);
        Produkt kulsyre10kg = Controller.createProdukt("10 kg kulsyre", kulsyre);

        //Produkt - malt
        Produkt malt25kg = Controller.createProdukt("25 kg sæk", malt);

        //Produkt - beklædning
        Produkt tShirt = Controller.createProdukt("T-shirt", beklædning);
        Produkt polo = Controller.createProdukt("Polo", beklædning);
        Produkt cap = Controller.createProdukt("Cap", beklædning);

        //Produkt - anlæg
        Produkt anlæg1hane = Controller.createProdukt("Anlæg 1-hane", anlæg);
        Produkt anlæg2haner = Controller.createProdukt("Anlæg 2-haner", anlæg);
        Produkt barFlereHaner = Controller.createProdukt("Bar med flere haner", anlæg);
        Produkt levering = Controller.createProdukt("Levering", anlæg);
        Produkt krus = Controller.createProdukt("Krus", anlæg);

        //Produkt - glas
        Produkt glasUansetStørrelse = Controller.createProdukt("Glas uanset størrelse", glas);

        //Produkt - sampakninger
        Produkt gaveæske2øl2glas = Controller.createProdukt("Gaveæske 2 øl, 2 glas", sampakninger);
        Produkt gaveæske4øl = Controller.createProdukt("Gaveæske 4 øl", sampakninger);
        Produkt trækasse6øl = Controller.createProdukt("Trækasse 6 øl", sampakninger);
        Produkt gavekurv6øl2glas = Controller.createProdukt("Gavekurv 6 øl, 2 glas", sampakninger);
        Produkt trækasse6øl2glas = Controller.createProdukt("Trækasse 6 øl, 2 glas", sampakninger);
        Produkt trækasse12øl = Controller.createProdukt("Trækasse 12 øl", sampakninger);
        Produkt papkasse12øl = Controller.createProdukt("Papkasse 12 øl", sampakninger);

        //Produkt - rundvisning
        Produkt rundvisning1 = Controller.createProdukt("Rundvisning", rundvisning);
    }

}
