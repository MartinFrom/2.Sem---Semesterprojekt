package model;

import java.util.ArrayList;

public class Pris {
    double pris;
    private Produkt produkt;
    private Prisliste prisliste;
    private UdlejningsProdukt udlejningsProdukt;


    public Pris(double pris, Produkt produkt, Prisliste prisliste) {
        this.pris = pris;
        this.produkt = produkt;
        this.prisliste = prisliste;
    }

    public Pris(double pris, UdlejningsProdukt udlejningsProdukt, Prisliste prisliste) {
        this.pris = pris;
        this.udlejningsProdukt = udlejningsProdukt;
        this.prisliste = prisliste;
    }

    //getters

    public double getPris() {
        return pris;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public Prisliste getPrisliste() {
        return prisliste;
    }

    public UdlejningsProdukt getUdlejningsProdukt() {
        return udlejningsProdukt;
    }

    //setters

    public void setPris(double pris) {
        this.pris = pris;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public void setPrisliste(Prisliste prisliste) {
        this.prisliste = prisliste;
    }

    public void setUdlejningsProdukt(UdlejningsProdukt udlejningsProdukt) {
        this.udlejningsProdukt = udlejningsProdukt;
    }
}
