package model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Udlejning extends Ordre{
    private LocalDate StartDato;
    private LocalDate SlutDato;
    private boolean erBetalt;
    private ArrayList<OrdreLinje> brugteProdukter = new ArrayList<>();

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

    public boolean isErBetalt() {
        return erBetalt;
    }

    public void setErBetalt(boolean erBetalt) {
        this.erBetalt = erBetalt;
    }

    //Metoder
    public OrdreLinje afleverProdukter(int antal, Pris pris) {
        OrdreLinje OL = new OrdreLinje(antal, pris);
        brugteProdukter.add(OL);
        return OL;
    }

    public double beregnUdlejningsPris() {
        double vareReturPris = 0;
        for (OrdreLinje OL:
             brugteProdukter) {
             vareReturPris += OL.samletPris();
        }
        return super.beregnPris() - vareReturPris;
    }


    public double beregnPant() {
        ArrayList<OrdreLinje> ordreLinjer = getOrdrelinjer();
        double samletPant = 0;
        for (OrdreLinje OL:
             ordreLinjer) {
            samletPant += OL.getPris().getUdlejningsProdukt().getPant();
            }
        return samletPant;
    }


}




