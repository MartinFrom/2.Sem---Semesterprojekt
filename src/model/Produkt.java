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

    //getters og setters
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getProduktnummer() {
        return produktnummer;
    }

    public void setProduktnummer(int produktnummer) {
        this.produktnummer = produktnummer;
    }

    public Pris getPris() {
        return pris;
    }

    public void setPris(Pris pris) {
        this.pris = pris;
    }
}
