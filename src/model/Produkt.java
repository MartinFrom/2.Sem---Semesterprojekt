package model;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 */

public class Produkt {
    private String navn;
    private int produktnummer;
    private ProduktGruppe produktGruppe;

    public Produkt (String navn, ProduktGruppe produktGruppe) {
        this.navn = navn;
        this.produktGruppe = produktGruppe;
        produktGruppe.addProdukt(this);
    }

    //getters

    public String getNavn() {
        return navn;
    }

    public int getProduktnummer() {
        return produktnummer;
    }

    public ProduktGruppe getProduktGruppe() {
        return produktGruppe;
    }

    //setters

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setProduktnummer(int produktnummer) {
        this.produktnummer = produktnummer;
    }

    @Override
    public String toString() {
        return "ProduktNr: " + getProduktnummer() + " | " + getNavn();
    }
}
