package model;

public class Produkt {
    private String navn;
    private int produktnummer;

    public Produkt (String navn, ProduktGruppe produktGruppe) {
        this.navn = navn;
        produktGruppe.addProdukt(this);
    }
}
