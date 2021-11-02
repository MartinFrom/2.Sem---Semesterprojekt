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

    public static ArrayList<Ordre> getOrdrer () {
        return new ArrayList<Ordre>(Storage.getOrdrer());
    }

    public static ArrayList<Prisliste> getPrisListe () {
        return new ArrayList<Prisliste>(Storage.getPrislister());
    }

    public static ArrayList<Udlejning> getUdlejninger() {
        return new ArrayList<Udlejning>(Storage.getUdlejninger());
    }

    public static void initStorage() {

        //Prisliste
        Prisliste fredagsBar = Controller.createPrisliste("Fredagsbar");
        Prisliste butik = Controller.createPrisliste("Butik");


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
        Produkt specialFad = Controller.createProdukt("Special", fadøl);
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
        Produkt toWhiskyGlas = Controller.createProdukt("2 gange whisky glas + brikker", spiritus);
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
        Produkt imperialStout20L = Controller.createProdukt("Imperial Stout 20 liter", fustage);
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
        Produkt trækasse6øl6glas = Controller.createProdukt("Trækasse 6 øl, 6 glas", sampakninger);
        Produkt trækasse12øl = Controller.createProdukt("Trækasse 12 øl", sampakninger);
        Produkt papkasse12øl = Controller.createProdukt("Papkasse 12 øl", sampakninger);

        //Produkt - rundvisning
        Produkt rundvisning1 = Controller.createProdukt("Rundvisning", rundvisning);

        //---------------------------- PRISER BUTIK -------------------------------------------

        //Priser - butik - flaskeøl
        Pris butikKlosterbryg = Controller.createPris(butik, klosterbrygFlaske, 36.0);
        Pris butikSWG = Controller.createPris(butik, sweetGeorgiaBrownFlaske, 36.0);
        Pris butikEP = Controller.createPris(butik, extraPilsnerFlaske, 36.0);
        Pris butikCelebration = Controller.createPris(butik, celebrationFlaske, 36.0);
        Pris butikBlondie = Controller.createPris(butik, blondieFlaske, 36.0);
        Pris butikForårsbryg = Controller.createPris(butik, forårsbrygFlaske, 36.0);
        Pris butikIPA = Controller.createPris(butik, indiaPaleAleFlaske, 36.0);
        Pris butikJulebryg = Controller.createPris(butik, julebrygFlaske, 36.0);
        Pris butikJuletønden = Controller.createPris(butik, juletøndenFlaske, 36.0);
        Pris butikOSA = Controller.createPris(butik, oldStrongAleFlaske, 36.0);
        Pris butikFregattenJylland = Controller.createPris(butik, fregattenJyllandFlaske, 36.0);
        Pris butikImperialStout = Controller.createPris(butik, imperialStoutFlaske, 36.0);
        Pris butikTribute = Controller.createPris(butik, tributeFlaske, 36.0);
        Pris butikBlackMonster = Controller.createPris(butik, blackMonsterFlaske, 36.0);

        //Priser - butik - spiritus
        Pris butikWhisky45Procent = Controller.createPris(butik, whisky45Procent50Cl, 599.0);
        Pris butikWhisky43Procent = Controller.createPris(butik, whisky43Procent50Cl, 499.0);
        Pris butikUdenEgesplint = Controller.createPris(butik, uEgesplint, 300.0);
        Pris butikMedEgesplint = Controller.createPris(butik, mEgesplint, 350.0);
        Pris butik2WhiskyGlas = Controller.createPris(butik, toWhiskyGlas, 80.0);
        Pris butikLiquorOfAarhus = Controller.createPris(butik, liquorOfAarhus, 175.0);
        Pris butikLyngGin50cl = Controller.createPris(butik, lyngGin50cl, 350.0);

        //Priser - butik - fustage
        Pris butikKlosterbrygFustage = Controller.createPris(butik, klosterbryg20L, 775.0);
        Pris butikJazzClasicFustage = Controller.createPris(butik, jazzClasic25L, 625.0);
        Pris butikExtraPilsnerFustage = Controller.createPris(butik, extraPilsner25L, 575.0);
        Pris butikCelebrationFustage = Controller.createPris(butik, celebration20L, 775.0);
        Pris butikBlondieFustage = Controller.createPris(butik, blondie25L, 700.0);
        Pris butikForårsbrygFustage = Controller.createPris(butik, forårsbryg20L, 775.0);
        Pris butikIPAFustage = Controller.createPris(butik, indiaPaleAle20L, 775.0);
        Pris butikJulebrygFustage = Controller.createPris(butik, julebryg20L, 775.0);
        Pris butikImperialStoutFustage = Controller.createPris(butik, imperialStout20L, 775.0);

        //Priser - butik - kulsyre
        Pris butik6kgKulsyre = Controller.createPris(butik, kulsyre6kg, 400.0);
        Pris butikPantKulsyre = Controller.createPris(butik, pantKulsyre, 1000.0);
        Pris butik4kgKulsyre = Controller.createPris(butik, kulsyre4kg, (400/6*4));
        Pris butik10kgKulsyre = Controller.createPris(butik, kulsyre10kg, (400/6*10));

        //Priser - butik - malt
        Pris butikMalt25kg = Controller.createPris(butik, malt25kg, 300.0);

        //Priser - butik - beklædning
        Pris butikTshirt = Controller.createPris(butik, tShirt, 70.0);
        Pris butikPolo = Controller.createPris(butik, polo, 100.0);
        Pris butikCap = Controller.createPris(butik, cap, 30.0);

        //Priser - butik - anlæg
        Pris butik1HaneAnlæg = Controller.createPris(butik, anlæg1hane, 250.0);
        Pris butik2HanerAnlæg = Controller.createPris(butik, anlæg2haner, 400.0);
        Pris butikBarFlereHaner = Controller.createPris(butik, barFlereHaner, 500.0);
        Pris butikLeveringAnlæg = Controller.createPris(butik, levering, 500.0);
        Pris butikKrusAnlæg = Controller.createPris(butik, krus, 60.0);

        //Priser - butik - glas
        Pris butikGlas = Controller.createPris(butik, glasUansetStørrelse, 15.0);

        //Priser - butik - sampakninger
        Pris butikGaveæske2øl2glasSampakning = Controller.createPris(butik, gaveæske2øl2glas, 110.0);
        Pris butikGaveæske4øl = Controller.createPris(butik, gaveæske4øl, 140.0);
        Pris butikTrækasse6øl = Controller.createPris(butik, trækasse6øl, 260.0);
        Pris butikGavekurv6øl2glas = Controller.createPris(butik, gavekurv6øl2glas, 260.0);
        Pris butikTrækasse6øl6glas = Controller.createPris(butik, trækasse6øl6glas, 350.0);
        Pris butikTrækasse12øl = Controller.createPris(butik, trækasse12øl, 410.0);
        Pris butikPapkasse12øl = Controller.createPris(butik, papkasse12øl, 370.0);

        //Priser - butik - rundvisning
        Pris butikRundvisning = Controller.createPris(butik, rundvisning1, 100.0);

        //------------------------------- PRISER FREDAGSBAR ---------------------------------------------

        //Priser - fredagsbar - flaskeøl
        Pris fredagsBarKlosterbrygFlaske = Controller.createPris(fredagsBar, klosterbrygFlaske, 70.0);
        Pris fredagsBarSWGFlaske = Controller.createPris(fredagsBar, sweetGeorgiaBrownFlaske, 70.0);
        Pris fredagsBarEPFlaske = Controller.createPris(fredagsBar, extraPilsnerFlaske, 70.0);
        Pris fredagsBarCelebrationFlaske = Controller.createPris(fredagsBar, celebrationFlaske, 70.0);
        Pris fredagsBarBlondieFlaske = Controller.createPris(fredagsBar, blondieFlaske, 70.0);
        Pris fredagsBarForårsbrygFlaske = Controller.createPris(fredagsBar, forårsbrygFlaske, 70.0);
        Pris fredagsBarIPAFlaske = Controller.createPris(fredagsBar, indiaPaleAleFlaske, 70.0);
        Pris fredagsBarJulebrygFlaske = Controller.createPris(fredagsBar, julebrygFlaske, 70.0);
        Pris fredagsBarJuletøndenFlaske = Controller.createPris(fredagsBar, juletøndenFlaske, 70.0);
        Pris fredagsBarOSAFlaske = Controller.createPris(fredagsBar, oldStrongAleFlaske, 70.0);
        Pris fredagsBarFregattenJyllandFlaske = Controller.createPris(fredagsBar, fregattenJyllandFlaske, 70.0);
        Pris fredagsBarImperialStoutFlaske = Controller.createPris(fredagsBar, imperialStoutFlaske, 70.0);
        Pris fredagsBarTributeFlaske = Controller.createPris(fredagsBar, tributeFlaske, 70.0);
        Pris fredagsBarBlackMonsterFlaske = Controller.createPris(fredagsBar, blackMonsterFlaske, 100.0);

        //Priser - fredagsbar - fadøl
        Pris fredagsBarKlosterbrygFad = Controller.createPris(fredagsBar, klosterbrygFad, 38.0);
        Pris fredagsBarJazzClasicFad = Controller.createPris(fredagsBar, jazzClasicFad, 38.0);
        Pris fredagsBarEPFad = Controller.createPris(fredagsBar, extraPilsnerFad, 38.0);
        Pris fredagsBarCelebrationFad = Controller.createPris(fredagsBar, celebrationFad, 38.0);
        Pris fredagsBarBlondieFad = Controller.createPris(fredagsBar, blondieFad, 38.0);
        Pris fredagsBarForårsbrygFad = Controller.createPris(fredagsBar, forårsbrygFad, 38.0);
        Pris fredagsBarIPAFad = Controller.createPris(fredagsBar, indiaPaleAleFad, 38.0);
        Pris fredagsBarJulebrygFad = Controller.createPris(fredagsBar, julebrygFad, 38.0);
        Pris fredagsBarImperialStoutFad = Controller.createPris(fredagsBar, imperialStoutFad, 38.0);
        Pris fredagsBarSpecial = Controller.createPris(fredagsBar, specialFad, 38.0);
        Pris fredagsBarÆblebrus = Controller.createPris(fredagsBar, æblebrusFad, 15.0);
        Pris fredagsBarChips = Controller.createPris(fredagsBar, chipsFad, 10.0);
        Pris fredagsBarPeanuts = Controller.createPris(fredagsBar, peanutsFad, 15.0);
        Pris fredagsBarCola = Controller.createPris(fredagsBar, colaFad, 15.0);
        Pris fredagsBarNikoline = Controller.createPris(fredagsBar, nikolineFad, 15.0);
        Pris fredagsBar7Up = Controller.createPris(fredagsBar, sevenUpFad, 15.0);
        Pris fredagsBarVand = Controller.createPris(fredagsBar, vandFad, 10.0);
        Pris fredagsBarØlpølser = Controller.createPris(fredagsBar, ølpølserFad, 30.0);

        //Priser - fredagsbar - spiritus
        Pris fredagsBarWhisky45Procent = Controller.createPris(fredagsBar, whisky45Procent50Cl, 599.0);
        Pris fredagsBarWhisky4cl = Controller.createPris(fredagsBar, whisky4cl, 50.0);
        Pris fredagsBarWhisky43Procent = Controller.createPris(fredagsBar, whisky43Procent50Cl, 499.0);
        Pris fredagsBarUdenEgesplint = Controller.createPris(fredagsBar, uEgesplint, 300.0);
        Pris fredagsBarMedEgesplint = Controller.createPris(fredagsBar, mEgesplint, 350.0);
        Pris fredagsBar2WhiskyGlas = Controller.createPris(fredagsBar, toWhiskyGlas, 80.0);
        Pris fredagsBarLiquorOfAarhus = Controller.createPris(fredagsBar, liquorOfAarhus, 175.0);
        Pris fredagsBarLyngGin50cl = Controller.createPris(fredagsBar, lyngGin50cl, 350.0);
        Pris fredagsBarLyngGin4cl = Controller.createPris(fredagsBar, lyngGin4cl, 40.0);

        //Priser - fredagsbar - kulsyre
        Pris fredagsBar6kgKulsyre = Controller.createPris(fredagsBar, kulsyre6kg, 400.0);
        Pris fredagsBarPantKulsyre = Controller.createPris(fredagsBar, pantKulsyre, 1000.0);
        Pris fredagsBar4kgKulsyre = Controller.createPris(fredagsBar, kulsyre4kg, (400/6*4));
        Pris fredagsBar10kgKulsyre = Controller.createPris(fredagsBar, kulsyre10kg, (400/6*10));

        //Priser - fredagsbar - beklædning
        Pris fredagsBarTshirt = Controller.createPris(fredagsBar, tShirt, 70.0);
        Pris fredagsBarPolo = Controller.createPris(fredagsBar, polo, 100.0);
        Pris fredagsBarCap = Controller.createPris(fredagsBar, cap, 30.0);

        //Priser - fredagsbar - sampakninger
        Pris fredagsBarGaveæske2øl2glasSampakning = Controller.createPris(fredagsBar, gaveæske2øl2glas, 110.0);
        Pris fredagsBarGaveæske4øl = Controller.createPris(fredagsBar, gaveæske4øl, 140.0);
        Pris fredagsBarTrækasse6øl = Controller.createPris(fredagsBar, trækasse6øl, 260.0);
        Pris fredagsBarGavekurv6øl2glas = Controller.createPris(fredagsBar, gavekurv6øl2glas, 260.0);
        Pris fredagsBarTrækasse6øl6glas = Controller.createPris(fredagsBar, trækasse6øl6glas, 350.0);
        Pris fredagsBarTrækasse12øl = Controller.createPris(fredagsBar, trækasse12øl, 410.0);
        Pris fredagsBarPapkasse12øl = Controller.createPris(fredagsBar, papkasse12øl, 370.0);


    }

}
