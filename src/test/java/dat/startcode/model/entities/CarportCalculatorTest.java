package dat.startcode.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarportCalculatorTest


{

    CarportCalculator carportCalculator = new CarportCalculator();
    Material material = new Material(1,"Tagplade", 5,"styk",600,109,1,1);


    @Test
    void calculateRoofArea() {
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void CalculateRoofPlatesTest() {

    ArrayList<Material> listOfRoofPlates = new ArrayList<>();
    listOfRoofPlates.add(material);
    listOfRoofPlates.add(new Material(2,"tagplade", 10,"styk",360,109,1,1));
    ArrayList <Bomline> newBomLineArrayList = carportCalculator.calculateRoofPlates(900,600,listOfRoofPlates);
    assertEquals(2,newBomLineArrayList.size());
    }

    @Test
    void calculateAmountOfRoofPlatesForWidthTest() {
        int amount;

        amount = carportCalculator.calculateAmountOfRoofPlatesForWidth(material, 600);
        assertEquals(6,amount);
        amount = carportCalculator.calculateAmountOfRoofPlatesForWidth(material, 1090);
        assertEquals(10,amount);
        amount = carportCalculator.calculateAmountOfRoofPlatesForWidth(material, 2);
        assertEquals(1,amount);
        amount = carportCalculator.calculateAmountOfRoofPlatesForWidth(material, 109);
        assertEquals(1,amount);

    }


    @Test
    void calculateBottomScrewForRoof() {

        int quantity;

        quantity=carportCalculator.calculateBottomScrewForRoof(6,7);
        assertEquals(546,quantity);
    }


}