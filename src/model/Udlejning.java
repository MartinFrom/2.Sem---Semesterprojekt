package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udlejning extends Ordre{
    private LocalDate StartDato;
    private LocalDate SlutDato;
    private ArrayList<OrdreLinje> Produkter = new ArrayList<>();

    public Udlejning (LocalDate StartDato, LocalDate Slutdato, int ordreNr, Prisliste prisliste) {
        super(ordreNr, prisliste);
        this.StartDato = StartDato;
        this.SlutDato = Slutdato;
    }

    // getters og setters
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
    public OrdreLinje afleverProdukter(int antal, Pris pris) {
        if (antal <= 0) {
            throw new IllegalArgumentException("Antal skal være større end 0");
        }

        OrdreLinje OL = new OrdreLinje(antal, pris);
        Produkter.add(OL);
        return OL;
    }

    public double beregnPant() {
       Produkter = super.getOrdrelinjer();
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




