package model;

import java.time.LocalDate;

public class Udlejning extends Produkt{
    private LocalDate StartDato;
    private LocalDate SlutDato;
    private double pant;
    private boolean VarerAfleveret;
    private int afleveredeFustager;

    public Udlejning (String navn, ProduktGruppe produktGruppe, LocalDate StartDato, LocalDate Slutdato, double pant, Pris pris) {
        super(navn, produktGruppe, pris);
        this.StartDato = StartDato;
        this.SlutDato = Slutdato;
        this.pant = pant;
        this.VarerAfleveret = false;
    }

    // getters
    public LocalDate getStartDato() {
        return StartDato;
    }

    public LocalDate getSlutDato() {
        return SlutDato;
    }

    public double getPant() {
        return pant;
    }

    public int getAfleveredeFustager() {
        return afleveredeFustager;
    }

    // setters

    public void setStartDato(LocalDate startDato) {
        StartDato = startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        SlutDato = slutDato;
    }

    public void setPant(double pant) {
        this.pant = pant;
    }

    public void setAfleveredeFustager(int afleveredeFustager) {
        this.afleveredeFustager = afleveredeFustager;
    }

    public void setVarerAfleveret(boolean varerAfleveret) {
        VarerAfleveret = varerAfleveret;
    }
}
