package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 */

public class Udlejning extends Ordre{
    private LocalDate StartDato;
    private LocalDate SlutDato;
    private boolean erBetalt;
    private ArrayList<OrdreLinje> brugteProdukter = new ArrayList<>(); // Bliver ikke brugt. Tiltænkt som oversigt over afleverede Produkter til beregning af pant-retur pris

    public Udlejning (LocalDate StartDato, LocalDate Slutdato, int ordreNr, Prisliste prisliste) {
        super(ordreNr, prisliste);
        this.StartDato = StartDato;
        this.SlutDato = Slutdato;
    }

    // getters og setters
    public void setErBetalt(boolean erBetalt) {
        setErBetalt(erBetalt);
    }

    public boolean isErBetalt() {
        return erBetalt;
    }

    public LocalDate getStartDato() {
        return StartDato;
    }

    public void setStartDato(LocalDate startDato) {
        StartDato = startDato;
    }

    public LocalDate getSlutDato() {
        return SlutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        SlutDato = slutDato;
    }

    //Metoder

    /**
     * Metode til aflevering af produkter
     * Bliver ikke brugt, da metoden er færdigarbejdet
     * @param antal
     * @param pris
     * @return
     */
    public OrdreLinje afleverProdukter(int antal, Pris pris) {
        OrdreLinje OL = new OrdreLinje(antal, pris);
        brugteProdukter.add(OL);
        return OL;
    }

    /**
     * beregner pant ud fra Ordrelinjernes produkters pant
     * @return
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




