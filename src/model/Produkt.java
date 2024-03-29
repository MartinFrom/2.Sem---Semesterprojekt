package model;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 *
 * Modellerer et produkt
 */

public class Produkt {
    private String navn;
    private int produktnummer;
    private ProduktGruppe produktGruppe;

    /**
     * Initialiserer et produkt med et navn og en produktgruppe
     * @param navn
     * @param produktGruppe
     */
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
