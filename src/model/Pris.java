package model;

import java.util.ArrayList;

public class Pris {
    double pris;
    private Produkt produkt;
    private UdlejningsProdukt udlejningsProdukt;
    private Prisliste prisliste;


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

    // getters og setters
    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public UdlejningsProdukt getUdlejningsProdukt() {
        return udlejningsProdukt;
    }

    public void setUdlejningsProdukt(UdlejningsProdukt udlejningsProdukt) {
        this.udlejningsProdukt = udlejningsProdukt;
    }

    public Prisliste getPrisliste() {
        return prisliste;
    }

    public void setPrisliste(Prisliste prisliste) {
        this.prisliste = prisliste;
    }
}
