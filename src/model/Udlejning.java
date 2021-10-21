package model;

import java.time.LocalDate;

public class Udlejning extends Produkt{
    private LocalDate StartDato;
    private LocalDate SlutDato;
    private double pant;
    private boolean VarerAfleveret;
    private int afleveredeFustager;

    public Udlejning (String navn, ProduktGruppe produktGruppe, LocalDate StartDato, LocalDate Slutdato, double pant) {
        super(navn, produktGruppe);
        this.StartDato = StartDato;
        this.SlutDato = Slutdato;
        this.pant = pant;
        this.VarerAfleveret = false;
    }


}
