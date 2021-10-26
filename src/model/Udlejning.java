package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udlejning {
    private LocalDate StartDato;
    private LocalDate SlutDato;
    private boolean VarerAfleveret;
    private int afleveredeFustager;
    private int brugteFustager;
    private ArrayList<UdlejningsProdukt> produkter = new ArrayList<>();

    public Udlejning (LocalDate StartDato, LocalDate Slutdato) {
        this.StartDato = StartDato;
        this.SlutDato = Slutdato;
    }

    // getters
    public LocalDate getStartDato() {
        return StartDato;
    }

    public LocalDate getSlutDato() {
        return SlutDato;
    }

    public int getAfleveredeFustager() {
        return afleveredeFustager;
    }

    public boolean isVarerAfleveret() {
        return VarerAfleveret;
    }

    public int getBrugteFustager() {
        return brugteFustager;
    }

    public ArrayList<UdlejningsProdukt> getProdukter() {
        return produkter;
    }

    // setters

    public void setStartDato(LocalDate startDato) {
        StartDato = startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        SlutDato = slutDato;
    }

    public void setAfleveredeFustager(int afleveredeFustager) {
        this.afleveredeFustager = afleveredeFustager;
    }

    public void setVarerAfleveret(boolean varerAfleveret) {
        VarerAfleveret = varerAfleveret;
    }

    public void setBrugteFustager(int brugteFustager) {
        this.brugteFustager = brugteFustager;
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

}




