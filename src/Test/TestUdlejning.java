package Test;

import controller.Controller;
import model.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alexander V Steen, Tobias Thomsen og Martin From
 */

public class TestUdlejning {

    private Udlejning udlejning;
    private Controller con;
    private Prisliste TestPris;
    private ProduktGruppe produktGruppeTest;

    private Produkt p1;
    private Produkt p2;
    private Produkt p3;
    private Produkt p4;
    private Produkt p5;



    void setUp() throws Exception {
        con = Controller.getTestController();

        TestPris = Controller.createPrisliste("TestPris");

        produktGruppeTest = Controller.createProduktGruppe("TestGruppe");

        p1 = Controller.createUdlejningsProdukt(200,"ExtraPils", produktGruppeTest);
        p2 = Controller.createUdlejningsProdukt(200,"Blondie", produktGruppeTest);
        p3 = Controller.createUdlejningsProdukt(200,"KlosterBryg", produktGruppeTest);
        p4 = Controller.createUdlejningsProdukt(200,"10 kg kulsyre", produktGruppeTest);
        p5 = Controller.createUdlejningsProdukt(200,"6 kg kulsyre", produktGruppeTest);

        udlejning = Controller.createUdlejning(LocalDate.of(2021,11,04), LocalDate.of(2021,11,04), TestPris);
    }

    @Test
    void test_tc1_0Produkter() {
        double expected = 0;
        double actual = udlejning.beregnPant();
        // Test
        assertEquals(expected, actual);
    }

    @Test
    void test_tc2_1Produkter() {
        TestPris.createUdlejningsPris(p2, 700);
        double expected = 200;
        double actual = udlejning.beregnPant();
        // Test
        assertEquals(expected,actual);
    }

    @Test
    void test_tc3_5Produkter() {
        TestPris.createUdlejningsPris(p1, 575);
        TestPris.createUdlejningsPris(p2, 700);
        TestPris.createUdlejningsPris(p3, 775);
        TestPris.createUdlejningsPris(p4, 500);
        TestPris.createUdlejningsPris(p5, 400);
        double expected = 1800;
        double actual = udlejning.beregnPant();
        // Test
        assertEquals(expected,actual);
    }
}
