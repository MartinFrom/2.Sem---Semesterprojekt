package model;

public class Betalingsform {
    private int kontant;
    private int kort;
    private int mobilepay;

    public Betalingsform(int kontant, int kort, int mobilepay, Ordre ordre) {
        this.kontant = kontant;
        this.kort = kort;
        this.mobilepay = mobilepay;
    }
}
