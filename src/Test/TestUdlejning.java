package test;

import controller.Controller;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
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

    private UdlejningsProdukt p1;
    private UdlejningsProdukt p2;
    private UdlejningsProdukt p3;
    private UdlejningsProdukt p4;
    private UdlejningsProdukt p5;


    @BeforeEach
    void setUp() {
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
    @Order(1)
    void test_tc5_0Produkter() {
        double expected = 0;
        double actual = udlejning.beregnPant();
        // Test
        assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    void test_tc6_1Produkter() {
        TestPris.createUdlejningsPris(p2, 700);
        double expected = 200;
        double actual = udlejning.beregnPant();
        // Test
        assertEquals(expected,actual);
    }

    @Test
    @Order(3)
    void test_tc7_5Produkter() {
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
