package dat.startcode.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarportCalculatorTest

{

    CarportCalculator carportCalculator = new CarportCalculator();
    Material material = new Material(1,"Tagplade", 5,"styk",600,109,1,1);
    ArrayList<Material> materialArrayList = new ArrayList<>();


    @BeforeEach
    void setUp()
    {
        ArrayList<Material> roofPlateArrayList = new ArrayList<>();
        materialArrayList.clear();
        roofPlateArrayList.add(material);
        roofPlateArrayList.add(new Material(1,"Tagplade", 5,"styk",360,109,1,1));
        roofPlateArrayList.add(new Material(1,"Tagplade", 5,"styk",240,109,1,1));

    }

    @Test
    void CalculateRoofPlatesTest()
    {
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
        assertEquals(6, amount);
        amount = carportCalculator.calculateAmountOfRoofPlatesForWidth(material, 1090);
        assertEquals(10, amount);
        amount = carportCalculator.calculateAmountOfRoofPlatesForWidth(material, 2);
        assertEquals(1, amount);
        amount = carportCalculator.calculateAmountOfRoofPlatesForWidth(material, 109);
        assertEquals(1, amount);

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
    void calculateBottomScrewForRoofTest() {

        int quantity;

        quantity=carportCalculator.calculateBottomScrewForRoof(6,7);
        assertEquals(546,quantity);
        assertEquals(13, carportCalculator.calculateBottomScrewForRoof(1,1));
        assertEquals(1300, carportCalculator.calculateBottomScrewForRoof(20,5));
    }

    @Test
    void calculateMaterialLengthTest()
    {

        materialArrayList.add(new Material(1,"Tagplade", 5,"styk",240,109,1,1));
        materialArrayList.add(new Material(1,"Tagplade", 5,"styk",360,109,1,1));
        materialArrayList.add(material);


        Material returnedMaterial = carportCalculator.calculateMaterialLength(370, materialArrayList);
        assertEquals(material, returnedMaterial);

        returnedMaterial = carportCalculator.calculateMaterialLength(360, materialArrayList);
        assertEquals(material, returnedMaterial);

        returnedMaterial = carportCalculator.calculateMaterialLength(120, materialArrayList);
        assertEquals(materialArrayList.get(0), returnedMaterial);
    }

    @Test
    void calculateQuantityOfBoxesTest()
    {
        Material material = new Material(1, "Bundskrue", 5, "Pakke", 2, 200);

        int result;

        result = carportCalculator.calculateQuantityOfBoxes(350, material);
        assertEquals(2, result);

        result = carportCalculator.calculateQuantityOfBoxes(200, material);
        assertEquals(1, result);

        result = carportCalculator.calculateQuantityOfBoxes(1, material);
        assertEquals(1, result);
    }

    @Test
    void calculateAmountOfBoxesOfBottomScrewsTest()
    {
        Material material = new Material(1, "Bundskrue", 5, "Pakke", 2, 200);

        Bomline bomline =   carportCalculator.calculateAmountOfBoxesOfBottomScrews(material, 5,5);
        assertEquals(2, bomline.getQuantity());

        bomline = carportCalculator.calculateAmountOfBoxesOfBottomScrews(material, 1,2);
        assertEquals(1, bomline.getQuantity());

    }

    @Test
    void calculateFrontAndBackSternTest()
    {
        ArrayList<Material> sternArrayList = new ArrayList<>();
        sternArrayList.add(new Material(1,"25x125mm. trykimp. Brædt ", 50, "stk", 360, 25, 125, 1));
        sternArrayList.add(new Material(2,"25x125mm. trykimp. Brædt ", 50, "stk", 560, 25, 125, 1));

        ArrayList<Bomline> bomlineArrayList = carportCalculator.calculateFrontAndBackStern(sternArrayList, 900);
        assertEquals(2, bomlineArrayList.size());
        assertEquals(920, bomlineArrayList.get(0).getMaterial().getLength()+bomlineArrayList.get(1).getMaterial().getLength());

        bomlineArrayList = carportCalculator.calculateFrontAndBackStern(sternArrayList, 360);
        assertEquals(1, bomlineArrayList.size());
        assertEquals(sternArrayList.get(1).getLength(), bomlineArrayList.get(0).getMaterial().getLength());

    }

    @Test
    void  calculateSideSternTest()
    {
        ArrayList<Material> sternArrayList = new ArrayList<>();
        sternArrayList.add(new Material(1,"25x125mm. trykimp. Brædt ", 50, "stk", 360, 25, 125, 1));
        sternArrayList.add(new Material(2,"25x125mm. trykimp. Brædt ", 50, "stk", 560, 25, 125, 1));

        ArrayList<Bomline> bomlineArrayList = carportCalculator.calculateSideStern(sternArrayList, 900);
        assertEquals(2, bomlineArrayList.size());
        assertEquals(920, bomlineArrayList.get(0).getMaterial().getLength()+bomlineArrayList.get(1).getMaterial().getLength());

        bomlineArrayList = carportCalculator.calculateSideStern(sternArrayList, 360);
        assertEquals(1, bomlineArrayList.size());
        assertEquals(sternArrayList.get(1).getLength(), bomlineArrayList.get(0).getMaterial().getLength());
    }

    @Test
    void calculateWeatherBoardForFrontAndBackTest()
    {
        ArrayList<Material> weatherboardArrayList = new ArrayList<>();
        weatherboardArrayList.add(new Material(1,"25x125mm. trykimp. Brædt ", 50, "stk", 360, 25, 125, 1));
        weatherboardArrayList.add(new Material(2,"25x125mm. trykimp. Brædt ", 50, "stk", 560, 25, 125, 1));

        ArrayList<Bomline> bomlineArrayList = carportCalculator.calculateWeatherBoardForFrontAndBack(weatherboardArrayList, 900);
        assertEquals(2, bomlineArrayList.size());
        assertEquals(920, bomlineArrayList.get(0).getMaterial().getLength()+bomlineArrayList.get(1).getMaterial().getLength());

        bomlineArrayList = carportCalculator.calculateWeatherBoardForFrontAndBack(weatherboardArrayList, 360);
        assertEquals(1, bomlineArrayList.size());
        assertEquals(weatherboardArrayList.get(1).getLength(), bomlineArrayList.get(0).getMaterial().getLength());


    }

    @Test
    void  calculateWeatherBoardForSideTest()
    {
        ArrayList<Material> sternArrayList = new ArrayList<>();
        sternArrayList.add(new Material(1,"25x125mm. trykimp. Brædt ", 50, "stk", 360, 25, 125, 1));
        sternArrayList.add(new Material(2,"25x125mm. trykimp. Brædt ", 50, "stk", 560, 25, 125, 1));

        ArrayList<Bomline> bomlineArrayList = carportCalculator.calculateWeatherBoardForSide(sternArrayList, 900);
        assertEquals(2, bomlineArrayList.size());
        assertEquals(920, bomlineArrayList.get(0).getMaterial().getLength()+bomlineArrayList.get(1).getMaterial().getLength());

        bomlineArrayList = carportCalculator.calculateWeatherBoardForSide(sternArrayList, 360);
        assertEquals(1, bomlineArrayList.size());
        assertEquals(sternArrayList.get(1).getLength(), bomlineArrayList.get(0).getMaterial().getLength());
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
        int screws = carportCalculator.calculateScrewForBracket(15, 15);
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

        Bomline bomline = carportCalculator.screwsForBrackets(material, 15, 15);
        assertEquals(270, bomline.getQuantity());
    }

    @Test
    void screwsForPerforatedTape(){
        Material material = new Material(1, "Skruer til universalbeslag", 5, "stk", 2);

        Bomline bomline = carportCalculator.screwsForPerforatedTape(material, 15);
        assertEquals(52, bomline.getQuantity());
    }

    @Test
    void calculateScrewAmount(){
        int screws = carportCalculator.calculateScrewAmount(270, 52);
        assertEquals(322, screws);
    }
}
