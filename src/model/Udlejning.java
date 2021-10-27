package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udlejning {
    private LocalDate StartDato;
    private LocalDate SlutDato;
    private boolean erBetalt;
    private int afleveredeFustager;
    private int brugteFustager;
    private ArrayList<UdlejningsProdukt> produkter = new ArrayList<>();

    public Udlejning (LocalDate StartDato, LocalDate Slutdato) {
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

    public int getAfleveredeFustager() {
        return afleveredeFustager;
    }

    public void setAfleveredeFustager(int afleveredeFustager) {
        this.afleveredeFustager = afleveredeFustager;
    }

    public int getBrugteFustager() {
        return brugteFustager;
    }

    public void setBrugteFustager(int brugteFustager) {
        this.brugteFustager = brugteFustager;
    }

    public ArrayList<UdlejningsProdukt> getProdukter() {
        return produkter;
    }

    public void setProdukter(ArrayList<UdlejningsProdukt> produkter) {
        this.produkter = produkter;
    }

    //Add/remove ArrayList Produkter
    public void addProdukt(UdlejningsProdukt produkt){
        if (!produkter.contains(produkt)) {
            produkter.add(produkt);
        }
    }

    public void removeProdukt(UdlejningsProdukt produkt) {
        if (produkter.contains(produkt)) {
            produkter.remove(produkt);
        }
    }

    //Metoder
    public double beregnPris() {
        return 0;
    }

    public double beregnPant() {
        return 0;
    }

    public void afleverProdukt (OrdreLinje ordreLinje, int antalBrugteProdukter) {

    }

}




