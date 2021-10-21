package model;

public class Produkt {
    private String navn;
    private int produktnummer;
    private Pris pris;

    public Produkt (String navn, ProduktGruppe produktGruppe, Pris pris) {
        this.navn = navn;
        produktGruppe.addProdukt(this);
        this.pris = pris;
        pris.addProdukt(this);
    }

    // getters
    public String getNavn() {
        return navn;
    }

    public int getProduktnummer() {
        return produktnummer;
    }

    // setters
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setProduktnummer(int produktnummer) {
        this.produktnummer = produktnummer;
    }

}
