package model;

public class Produkt {
    private String navn;
    private int produktnummer;

    public Produkt (String navn, ProduktGruppe produktGruppe) {
        this.navn = navn;
        produktGruppe.addProdukt(this);
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
