package dat.startcode.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarportCalculatorTest {
    CarportCalculator carportCalculator = new CarportCalculator();

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculatePostAmountTest() {
        int post = carportCalculator.calculatePostAmount(780);
        assertEquals(8, post);
    }

    @Test
    void calculateCarriageBolt() {
        int carriageBolt = carportCalculator.calculateCarriageBolt(600);
        assertEquals(12, carriageBolt);
    }

    @Test
    void calculateSquareSpace() {
        int squareSpace = carportCalculator.calculateSquareSpacer(12);
        assertEquals(24, squareSpace);
    }

    @Test
    void calculateRafters() {
        int rafters = carportCalculator.calculateRafters(600);
        assertEquals(12, rafters);
    }

    @Test
    void calculateRaftersDistance() {
        float distance = carportCalculator.calculateRaftersDistance(600, 12);
        assertEquals(54.5, distance);
    }


    @Test
    void calculateSteelBracketRight() {
        int steelBracket = carportCalculator.calculateSteelBracketRight(12);
        assertEquals(12, steelBracket);
    }

    @Test
    void calculateSteelBracketLeft() {
        int steelBracket = carportCalculator.calculateSteelBracketLeft(12);
        assertEquals(12, steelBracket);
    }

    @Test
    void calculateScrewForBracket() {
        int screws = carportCalculator.calculateScrewForBracket(30);
        assertEquals(270, screws);
    }

    @Test
    void calculateScrewForPerforatedTape() {
        int screws = carportCalculator.calculateScrewForPerforatedTape(15);
        assertEquals(52, screws);
    }

    @Test
    void postAmount() {
        Material material = new Material(1, "Stolper", 5, "stk", 1);

        Bomline bomline = carportCalculator.postAmount(material, 780);
        assertEquals(8, bomline.getQuantity());
    }

    @Test
    void carriageBolt() {
        Material material = new Material(1, "Breddebolte", 5, "stk", 2);

        Bomline bomline = carportCalculator.carriageBolt(material, 780);
        assertEquals(16, bomline.getQuantity());
    }

    @Test
    void squareSpacer() {
        Material material = new Material(1, "Firkantskiver", 5, "stk", 2);

        Bomline bomline = carportCalculator.squareSpacer(material, 16);
        assertEquals(32, bomline.getQuantity());
    }

    @Test
    void rafters() {
        Material material = new Material(1, "Spær", 5, "stk", 1);

        Bomline bomline = carportCalculator.rafters(material, 780);
        assertEquals(15, bomline.getQuantity());
    }

    @Test
    void steelBracketRight(){
        Material material = new Material(1, "Universalbeslag højre", 5, "stk", 1);

        Bomline bomline = carportCalculator.steelBracketRight(material, 15);
        assertEquals(15, bomline.getQuantity());
    }

    @Test
    void steelBracketLeft(){
        Material material = new Material(1, "Universalbeslag venstre", 5, "stk", 1);

        Bomline bomline = carportCalculator.steelBracketLeft(material, 15);
        assertEquals(15, bomline.getQuantity());
    }

    @Test
    void screwsForBrackets(){
        Material material = new Material(1, "Skruer til universalbeslag", 5, "stk", 2);

        Bomline bomline = carportCalculator.screwsForBrackets(material, 30);
        assertEquals(270, bomline.getQuantity());
    }

    @Test
    void screwsForPerforatedTape(){
        Material material = new Material(1, "Skruer til universalbeslag", 5, "stk", 2);

        Bomline bomline = carportCalculator.screwsForPerforatedTape(material, 15);
        assertEquals(52, bomline.getQuantity());
    }
}
