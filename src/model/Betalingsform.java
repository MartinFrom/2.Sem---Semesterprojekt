package model;

public class Betalingsform {
    int kontant;
    int kort;
    int mobilepay;

    public Betalingsform(int kontant, int kort, int mobilepay, Ordre ordre) {
        this.kontant = kontant;
        this.kort = kort;
        this.mobilepay = mobilepay;
    }
}
