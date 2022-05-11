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
        int post = carportCalculator.calculatePostAmount(600);
        assertEquals(6,post);
    }

    @Test
    void calculateCarriageBolt(){
        int carriageBolt = carportCalculator.calculateCarriageBolt(600);
        assertEquals(12, carriageBolt);
    }

    @Test
    void calculateSquareSpace(){
        int squareSpace = carportCalculator.calculateSquareSpacer(12);
        assertEquals(24, squareSpace);
    }

}