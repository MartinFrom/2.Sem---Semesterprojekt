package model;

import java.time.LocalDate;

public class Udlejning extends Produkt{
    private LocalDate StartDato;
    private LocalDate SlutDato;
    private double pant;
    private boolean VarerAfleveret;

    public Udlejning (LocalDate StartDato, LocalDate Slutdato, double pant, String navn, ProduktGruppe produktGruppe) {
        super(navn, produktGruppe);
        this.StartDato = StartDato;
        this.SlutDato = Slutdato;
        this.pant = pant;
        this.VarerAfleveret = false;
    }
}
