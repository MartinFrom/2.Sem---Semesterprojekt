package test;

import controller.Controller;
import model.Pris;
import model.Prisliste;
import model.Produkt;
import model.ProduktGruppe;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestController {

    private Controller ctrl;
    private Prisliste TestPris;

    private ProduktGruppe FlaskeØl;
    private ProduktGruppe Spiritus;
    private ProduktGruppe Beklædning;

    private Produkt p1;
    private Produkt p2;
    private Produkt p3;
    private Produkt p4;
    private Produkt p5;


    void setUp() throws Exception {
        ctrl = Controller.getTestController();

        TestPris = Controller.createPrisliste("TestPris");

        FlaskeØl = Controller.createProduktGruppe("FlaskeØl");
        Spiritus = Controller.createProduktGruppe("Spiritus");
        Beklædning = Controller.createProduktGruppe("Beklædning");

        p1 = Controller.createProdukt("ImperialStout", FlaskeØl);
        p2 = Controller.createProdukt("FregattenJylland", FlaskeØl);
        p3 = Controller.createProdukt("JuleBryg", FlaskeØl);

        p4 = Controller.createProdukt("Whisky 45% 50cl rør", Spiritus);

        p5 = Controller.createProdukt("Polo", Beklædning);
    }

    @Test
    @Order(1)
    void test_tc1_TomPrisliste() {
        ArrayList<Pris> expected = new ArrayList<>();
        ArrayList<Pris> result = Controller.findPrisProduktGruppe(FlaskeØl, TestPris);
        // Test
        assertArrayEquals(result.toArray(), expected.toArray());
    }

    @Test
    @Order(2)
    void test_tc2_1FlaskeØl() {
        Pris Test1 = TestPris.createPris(p1, 20);
        ArrayList<Pris> actual = Controller.findPrisProduktGruppe(FlaskeØl, TestPris);
        ArrayList<Pris> expected = new ArrayList<>();
        expected.add(Test1);
        // Test
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    @Order(3)
    void test_tc3_3FlaskeØl() {
        Pris Test1 = TestPris.createPris(p1,20);
        Pris Test2 = TestPris.createPris(p2,40);
        Pris Test3 = TestPris.createPris(p3, 50);
        ArrayList<Pris> actual = Controller.findPrisProduktGruppe(FlaskeØl, TestPris);
        ArrayList<Pris> expected = new ArrayList<>();
        expected.add(Test1);
        expected.add(Test2);
        expected.add(Test3);
        // Test
        assertArrayEquals(actual.toArray(), expected.toArray());
    }

    @Test
    @Order(4)
    void test_tc4_FlereProduktGrupper() {
        Pris Test1 = TestPris.createPris(p3, 50);
        Pris Test2 = TestPris.createPris(p4, 500);
        ArrayList<Pris> actual = Controller.findPrisProduktGruppe(Spiritus, TestPris);
        ArrayList<Pris> expected = new ArrayList<>();
        expected.add(Test2);
        // Test
        assertArrayEquals(actual.toArray(), expected.toArray());
    }
}
