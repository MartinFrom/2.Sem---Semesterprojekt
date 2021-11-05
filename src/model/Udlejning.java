package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 *
 * Modellerer en udlejning
 */

public class Udlejning extends Ordre{
    private LocalDate StartDato;
    private LocalDate SlutDato;
    private boolean erBetalt;
    private ArrayList<OrdreLinje> brugteProdukter = new ArrayList<>(); // Bliver ikke brugt. Tiltænkt som oversigt over afleverede Produkter til beregning af pant-retur pris

    /**
     * Initialiserer en udlejning med startdato, slutdato, ordreNr og en prisliste
     * @param StartDato
     * @param Slutdato
     * @param ordreNr
     * @param prisliste
     */
    public Udlejning (LocalDate StartDato, LocalDate Slutdato, int ordreNr, Prisliste prisliste) {
        super(ordreNr, prisliste);
        this.StartDato = StartDato;
        this.SlutDato = Slutdato;
    }

    //getters
    public LocalDate getStartDato() {
        return StartDato;
    }

    public LocalDate getSlutDato() {
        return SlutDato;
    }

    public boolean isErBetalt() {
        return erBetalt;
    }

    //setters
    public void setStartDato(LocalDate startDato) {
        StartDato = startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        SlutDato = slutDato;
    }

    public void setErBetalt(boolean erBetalt) {
        setErBetalt(erBetalt);
    }

    /**
     * Metode til aflevering af produkter
     * Bliver ikke brugt, da metoden ikke er færdigarbejdet
     * @param antal
     * @param pris
     */
    public OrdreLinje afleverProdukter(int antal, Pris pris) {
        if (antal <= 0) {
            throw new IllegalArgumentException("Antal skal være større end 0");
        }

        OrdreLinje OL = new OrdreLinje(antal, pris);
        brugteProdukter.add(OL);
        return OL;
    }

    /**
     * beregner pant ud fra Ordrelinjernes produkters pant
     */
    public double beregnPant() {
       ArrayList<OrdreLinje> Produkter = super.getOrdrelinjer();
        double samletPant = 0;
        for (OrdreLinje OL:
              Produkter) {
            samletPant += OL.getPris().getUdlejningsProdukt().getPant();
            }
        return samletPant;
    }

    @Override
    public String toString() {
        return "Nr:" + super.getOrdreNr() + " | Type: Udlejning" + " | Pris: " + super.getSamletPris() + " | Betalt: " + isErBetalt() + " | Betalingsform: " + super.getBetalingsform();
    }
}




