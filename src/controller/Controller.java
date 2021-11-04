package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    //Betalingsform
    public static Betalingsform createBetalingsformKontant(String navn) {
        Betalingsform betalingKontant = new BetalingsformKontant(navn);
        Storage.addBetalingsform(betalingKontant);
        return betalingKontant;
    }

    public static Betalingsform createBetalingsformKort(String navn, int kortNr, int udløbsÅr, int udløbsMåned, int CVV) {
        Betalingsform betalingKort = new BetalingsformKort(navn, kortNr, udløbsÅr, udløbsMåned, CVV);
        Storage.addBetalingsform(betalingKort);
        return betalingKort;
    }

    public static Betalingsform createBetalingsformMobilepay(String navn, int mobilNr) {
        Betalingsform betalingMobilepay = new BetalingsformMobilepay(navn, mobilNr);
        Storage.addBetalingsform(betalingMobilepay);
        return betalingMobilepay;
    }

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
        int produktNr = Storage.getProdukter().size()+ Storage.getUdlejningsProdukter().size() +1;
        Produkt produkt = new Produkt(navn, produktgruppe);
        produkt.setProduktnummer(produktNr);
        Storage.addProdukt(produkt);
        return produkt;
    }

    public static void deleteProdukt(Produkt produkt) {
        Storage.removeProdukt(produkt);
    }

    public static UdlejningsProdukt createUdlejningsProdukt(double pant, String navn, ProduktGruppe produktGruppe) {
        int produktNr = Storage.getProdukter().size() + Storage.getUdlejningsProdukter().size() +1;
        UdlejningsProdukt udlejningsProdukt = new UdlejningsProdukt(pant, navn, produktGruppe);
        udlejningsProdukt.setProduktnummer(produktNr);
        Storage.addUdlejningsProdukt(udlejningsProdukt);
        return udlejningsProdukt;
    }

    public static void deleteUdlejningsProdukt(UdlejningsProdukt udlejningsProdukt) {
        Storage.removeUdlejningsProdukt(udlejningsProdukt);
    }

    // Pris
    public static Pris createPris(Prisliste prisliste, Produkt produkt, double varePris) {
        Pris pris = prisliste.createPris(produkt, varePris);
        return pris;
    }

    public static void deletePris(Prisliste prisliste, Pris pris) {
        prisliste.removePris(pris);
    }

    public static ArrayList<Pris> findPrisProduktGruppe(ProduktGruppe produktGruppe, Prisliste prisliste) {
        ArrayList<Pris> result = new ArrayList<>();
        for (int i = 0; i < prisliste.getPrisliste().size(); i++) {
            if (prisliste.getPrisliste().get(i).getProdukt().getProduktGruppe() == produktGruppe ) {
                result.add(prisliste.getPrisliste().get(i));
            }
        }
        return result;
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
    public static Ordre createOrdre(Prisliste prisliste) {
        int ordreNr = Storage.getOrdrer().size() + 1;
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
    public static Udlejning createUdlejning(LocalDate StartDato, LocalDate Slutdato, Prisliste prisliste) {
        int ordreNr = Storage.getOrdrer().size() + Storage.getUdlejninger().size() + 1;
        Udlejning udlejning = new Udlejning(StartDato, Slutdato, ordreNr, prisliste);
        Storage.addUdlejning(udlejning);
        return udlejning;
    }

    // Getters
    public static ArrayList<Betalingsform> getBetalingsformer() {
        return new ArrayList<Betalingsform>(Storage.getBetalingsformer());
    }

    public static ArrayList<Pris> getUdlejningsPris() {
        ArrayList<Pris> result = new ArrayList<>();
        for (Pris p: Storage.getPrislister().get(1).getUdlejningsPriser()) {
            result.add(p);
        }
        return result;
    }

    public static ArrayList<ProduktGruppe> getProduktGrupper () {
        return new ArrayList<ProduktGruppe>(Storage.getProduktgrupper());
    }

    public static ArrayList<Ordre> getOrdrer () {
        return new ArrayList<Ordre>(Storage.getOrdrer());
    }

    public static ArrayList<Prisliste> getPrisLister () {
        return new ArrayList<Prisliste>(Storage.getPrislister());
    }

    public static ArrayList<Udlejning> getUdlejninger() {
        return new ArrayList<Udlejning>(Storage.getUdlejninger());
    }

    public static void initStorage() {

        //Prisliste
        Prisliste butik = Controller.createPrisliste("Butik");
        Prisliste fredagsBar = Controller.createPrisliste("Fredagsbar");

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
        Produkt klosterbryg20L = Controller.createUdlejningsProdukt(200,"Klosterbryg 20 liter", fustage);
        Produkt jazzClasic25L = Controller.createUdlejningsProdukt(200,"Jazz Clasic 25 liter", fustage);
        Produkt extraPilsner25L = Controller.createUdlejningsProdukt(200,"Jazz Clasic 25 liter", fustage);
        Produkt celebration20L = Controller.createUdlejningsProdukt(200,"Celebration 20 liter", fustage);
        Produkt blondie25L = Controller.createUdlejningsProdukt(200,"Blondie 25 liter", fustage);
        Produkt forårsbryg20L = Controller.createUdlejningsProdukt(200,"Forårsbryg 20 liter", fustage);
        Produkt indiaPaleAle20L = Controller.createUdlejningsProdukt(200,"India Pale Ale 20 liter", fustage);
        Produkt julebryg20L = Controller.createUdlejningsProdukt(200,"Julebryg 20 liter", fustage);
        Produkt imperialStout20L = Controller.createUdlejningsProdukt(200,"Imperial Stout 20 liter", fustage);

        //Produkt - kulsyre
        Produkt kulsyre6kg = Controller.createUdlejningsProdukt(1000,"6 kg kulsyre", kulsyre);
        Produkt kulsyre4kg = Controller.createUdlejningsProdukt(1000,"4 kg kulsyre", kulsyre);
        Produkt kulsyre10kg = Controller.createUdlejningsProdukt(1000,"10 kg kulsyre", kulsyre);

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
        Pris fustageKlosterbrug20L = butik.createUdlejningsPris(klosterbryg20L, 775);
        Pris fustageJazzClasic25L = butik.createUdlejningsPris(jazzClasic25L, 625.0);
        Pris fustageextraPilsner = butik.createUdlejningsPris(extraPilsner25L,575.0);
        Pris fustageCelebration20L =  butik.createUdlejningsPris(celebration20L, 775);
        Pris fustageBlondie25L = butik.createUdlejningsPris(blondie25L, 700.0);
        Pris fustageForårsbryg20L = butik.createUdlejningsPris(forårsbryg20L, 775.0);
        Pris fustageIndiaPaleAle20L = butik.createUdlejningsPris(indiaPaleAle20L, 775.0);
        Pris fustageJulebryg20L = butik.createUdlejningsPris(julebryg20L, 775.0);
        Pris fustageImperialStout20L = butik.createUdlejningsPris(imperialStout20L,775.0);

        //Priser - butik - kulsyre
        Pris butik6kgKulsyre = butik.createUdlejningsPris(kulsyre6kg, 400.0);
        Pris butik4kgKulsyre = butik.createUdlejningsPris(kulsyre4kg, (400/6*4));
        Pris butik10kgKulsyre = butik.createUdlejningsPris(kulsyre10kg, (400/6*10));

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

        //Betalingsform
        Betalingsform kort = Controller.createBetalingsformKort("Kort", 12345678, 123, 1221, 1212);
        Betalingsform mobilepay = Controller.createBetalingsformMobilepay("Mobilepay", 12345678);
        Betalingsform kontant = Controller.createBetalingsformKontant("Kontant");

        //Ordrer
        Ordre ordre1 = Controller.createOrdre(butik);
        ordre1.createOrdreLinje(1, butikTshirt);
        ordre1.createOrdreLinje(1, butikWhisky45Procent);
        ordre1.createOrdreLinje(2, butikTrækasse6øl);
        ordre1.setBetalingsform(kort);

        Ordre ordre2 = Controller.createOrdre(fredagsBar);
        ordre2.createOrdreLinje(3, fredagsBarBlondieFlaske);
        ordre2.createOrdreLinje(2, fredagsBar2WhiskyGlas);
        ordre2.createOrdreLinje(1, fredagsBarPolo);
        ordre2.setBetalingsform(mobilepay);

        Ordre ordre3 = Controller.createOrdre(butik);
        ordre3.createOrdreLinje(10, butikForårsbryg);
        ordre3.setBetalingsform(kontant);

        //Udlejning
        Udlejning udlejning1 = Controller.createUdlejning(LocalDate.of(2021,11,01),
                               LocalDate.of(2021,11,10), butik);
        udlejning1.createOrdreLinje(1, fustageImperialStout20L);
        udlejning1.createOrdreLinje(5, fustageJulebryg20L);
        udlejning1.createOrdreLinje(1, butik10kgKulsyre);




    }

}
