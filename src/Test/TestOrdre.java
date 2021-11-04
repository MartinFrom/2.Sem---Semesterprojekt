package Test;

import controller.Controller;
import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 */

public class TestOrdre {

    private Ordre ordre;

    private Prisliste TestPris;

    private ProduktGruppe FlaskeØl;
    private ProduktGruppe Spiritus;
    private ProduktGruppe Beklædning;

    private Produkt p1;
    private Produkt p2;
    private Produkt p3;
    private Produkt p4;
    private Produkt p5;

    private Pris pris1;
    private Pris pris2;
    private Pris pris3;
    private Pris pris4;
    private Pris pris5;

    void setUp() throws Exception {
        TestPris = Controller.createPrisliste("TestPris");

        FlaskeØl = Controller.createProduktGruppe("FlaskeØl");
        Spiritus = Controller.createProduktGruppe("Spiritus");
        Beklædning = Controller.createProduktGruppe("Beklædning");

        p1 = Controller.createProdukt("ImperialStout", FlaskeØl);
        p2 = Controller.createProdukt("FregattenJylland", FlaskeØl);
        p3 = Controller.createProdukt("JuleBryg", FlaskeØl);

        p4 = Controller.createProdukt("Whisky 45% 50cl rør", Spiritus);

        p5 = Controller.createProdukt("Polo", Beklædning);

        ordre = Controller.createOrdre(TestPris);

        pris1 = TestPris.createPris(p1, 36);
        pris2 = TestPris.createPris(p2, 36);
        pris3 = TestPris.createPris(p3, 36);
        pris4 = TestPris.createPris(p4, 599);
        pris5 = TestPris.createPris(p5, 100);
    }

    @Test
    void test_tc1_0Produkter() {
        double expected = 0;
        double actual = ordre.beregnPris();
        // Test
        assertEquals(expected, actual);
    }

    @Test
    void test_tc2_1Produkter() {
        ordre.createOrdreLinje(1, pris1);
        double expected = 36;
        double actual = ordre.beregnPris();
        // Test
        assertEquals(expected,actual);
    }

    @Test
    void test_tc3_5Produkter() {
        ordre.createOrdreLinje(1, pris1);
        ordre.createOrdreLinje(1, pris2);
        ordre.createOrdreLinje(1, pris3);
        ordre.createOrdreLinje(1, pris4);
        ordre.createOrdreLinje(1, pris5);
        double expected = 807;
        double actual = ordre.beregnPris();
        // Test
        assertEquals(expected,actual);
    }
}
