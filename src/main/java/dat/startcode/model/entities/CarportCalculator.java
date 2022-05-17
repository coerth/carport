package dat.startcode.model.entities;

import java.util.ArrayList;

public class CarportCalculator {

    private ArrayList<Material> materialArrayList = new ArrayList<>();

    //private HashMap<String, ArrayList<Material>> materialHashMap = new HashMap<>();

    public CarportCalculator(ArrayList<Material> materialArrayList) {
        this.materialArrayList = materialArrayList;
        //this.materialHashMap = materialHashMap;
    }

    public CarportCalculator()
    {
    }

    public ArrayList<Bomline> shedPlanksAndScrews(int shedWidth, int shedLength, Material planks, Material shortScrews, Material longScrews)
    {
        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();

        int amountOfPlanks = calculateShed2on1(shedLength, shedWidth, planks);
        int shortScrewsNeeded = calculateShortScrewsForShed(amountOfPlanks / 2);
        int longScrewsNeeded = calculateLongScrewsForShed(amountOfPlanks / 2);

        int shortScrewBoxes = calculateQuantityOfBoxes(shortScrewsNeeded, shortScrews);
        int longScrewBoxes = calculateQuantityOfBoxes(longScrewsNeeded, longScrews);


       bomlineArrayList.add(new Bomline(12, planks, amountOfPlanks));
       bomlineArrayList.add(new Bomline(22, longScrews, longScrewBoxes));
       bomlineArrayList.add(new Bomline(23, shortScrews, shortScrewBoxes));

       return  bomlineArrayList;
    }


    public int calculateShortScrewsForShed(int amountOfPlanks)
    {
        int screwsNeeded = amountOfPlanks * 4;

        return screwsNeeded;
    }

    public int calculateLongScrewsForShed(int amountOfPlanks)
    {
        int screwsNeeded = amountOfPlanks * 8;
        return screwsNeeded;
    }

    public int calculateShed2on1(float shedLength, float shedWidth, Material material)
    {

        int plankOverlap = (2*material.getHeight()) - (2*15);

        int planksNeededForSide = calculateShedPlanksNeededForSide(shedLength, material);
        int planksNeededForFrontAndBack = calculateShedPlanksNeededForFrontAndBack(shedWidth, material) ;

        int totalPlanksNeeded = planksNeededForSide + planksNeededForFrontAndBack;

        return  totalPlanksNeeded;
    }

    public int calculateShedPlanksNeededForSide(float shedLength, Material material)
    {
        int plankOverlap = (2*material.getHeight()) - (2*15);
        float overlapsForSide = ((shedLength * 10 - material.getHeight()) / plankOverlap) * 2;
        int planksNeededForSide = (int) Math.ceil(overlapsForSide * 2) ;

        return planksNeededForSide;
    }

    public int calculateShedPlanksNeededForFrontAndBack(float shedWidth, Material material)
    {
        int plankOverlap = (2*material.getHeight()) - (2*15);
        float overlapsForFrontAndBack = ((shedWidth * 10 - material.getHeight()) / plankOverlap) * 2;
        int planksNeededForFrontAndBack = (int) Math.ceil(overlapsForFrontAndBack * 2) ;

        return planksNeededForFrontAndBack;
    }





    public Material calculateMaterialLength(int dimension, ArrayList<Material> listOfMaterials) {

        for (Material material : listOfMaterials) {
            if (material.getLength() > dimension) {
                return material;
            }
        }
        return null;
    }

    public ArrayList<Material> calculateMaterialIfMoreThanOneIsNeeded(int dimension, ArrayList<Material> listOfMaterials) {

        ArrayList<Material> materialArrayList = new ArrayList<>();
        Material material1 = null;
        Material material2 = null;

        for (int i = 0; i < listOfMaterials.size(); i++) {
            material1 = listOfMaterials.get(i);
            for (int j = 0; j < listOfMaterials.size(); j++) {
                material2 = listOfMaterials.get(j);
                if (material1.getLength() + material2.getLength() > dimension) {
                    break;
                }
            }
            if (material1.getLength() + material2.getLength() > dimension) {
                break;
            }
        }
        materialArrayList.add(material1);
        materialArrayList.add(material2);
        return materialArrayList;
    }


    public int calculateQuantityOfBoxes(int amountNeeded, Material material) {

        int amount = 1;

        while (amountNeeded > material.getQuantity() * amount) {

            amount++;
        }
        return amount;
    }


    public ArrayList<Bomline> calculateRoofPlates(int carportLength, int carportWidth, ArrayList<Material> listOfRoofPlates) {
        ArrayList<Bomline> bomLineArrayList = new ArrayList<Bomline>();
        Material primaryRoofPlate = calculateMaterialLength(carportLength, listOfRoofPlates);

        if (primaryRoofPlate != null) {
            int amount = calculateAmountOfRoofPlatesForWidth(primaryRoofPlate, carportWidth);
            bomLineArrayList.add(new Bomline(15, primaryRoofPlate, amount));
        } else {
            primaryRoofPlate = listOfRoofPlates.get(0);
            Material secondaryRoofPlate = null;
            for (Material m : listOfRoofPlates) {
                if (primaryRoofPlate.getLength() + m.getLength() > carportLength) {
                    secondaryRoofPlate = m;
                    break;
                }
            }
            if (secondaryRoofPlate == null) {
                throw new ArithmeticException("Kunne ikke lave en lang nok tagplade");
            }
            int amount = calculateAmountOfRoofPlatesForWidth(primaryRoofPlate, carportWidth);
            bomLineArrayList.add(new Bomline(15, primaryRoofPlate, amount));
            bomLineArrayList.add(new Bomline(15, secondaryRoofPlate, amount));

        }

        if (carportLength > primaryRoofPlate.getLength()) {
            for (Material m : listOfRoofPlates) {
                if (primaryRoofPlate.getLength() + m.getLength() > carportLength) {

                }
            }
        }
        return bomLineArrayList;
    }


    public int calculateAmountOfRoofPlatesForWidth(Material material, int carportWidth) {
        if (material.getWidth() > carportWidth) {
            return 1;
        } else {
            int amount = 1;
            while (material.getWidth() * amount < carportWidth) {
                amount++;
            }
            return amount;
        }
    }

    public int calculateBottomScrewForRoof(int carportWidth, int carportLength) {
        int quantity = ((carportWidth / 100) * (carportLength / 100)) * 13;

        return quantity;
    }

    public Bomline calculateAmountOfBoxesOfBottomScrews(Material material, int carportWidth, int carportLength) {

        int screwsNeeded = calculateBottomScrewForRoof(carportWidth, carportLength);
        int boxesNeeded = calculateQuantityOfBoxes(screwsNeeded, material);

        Bomline bomline = new Bomline(16, material, boxesNeeded);
        return bomline;
    }



    public ArrayList<Bomline> calculateFrontAndBackStern (ArrayList<Material> sternArrayList, int rafterLength) {
        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();
        Material frontAndBackStern = calculateMaterialLength(rafterLength, sternArrayList);
        if(frontAndBackStern == null) {
            ArrayList<Material> frontAndBackSternArrayList = calculateMaterialIfMoreThanOneIsNeeded(rafterLength +5, sternArrayList);

            for (Material material : frontAndBackSternArrayList) {

                Bomline bomline = new Bomline(3,material,2);
                bomlineArrayList.add(bomline);
            }
        } else {
            Bomline bomline = new Bomline(3, frontAndBackStern,2);
            bomlineArrayList.add(bomline);
        } return bomlineArrayList;
    }

   public ArrayList<Bomline> calculateSideStern(ArrayList<Material> sternArrayList, int carportLength) {
       ArrayList<Bomline> bomlineArrayList = new ArrayList<>();
       Material sideStern = calculateMaterialLength(carportLength, sternArrayList);
       if(sideStern == null) {
           ArrayList<Material> sideSternArrayList = calculateMaterialIfMoreThanOneIsNeeded(carportLength,sternArrayList);
           for(Material material : sideSternArrayList) {
               Bomline bomline = new Bomline(4, material,2);
               bomlineArrayList.add(bomline);
           }
       }else {
           Bomline bomline = new Bomline(4, sideStern,2);
           bomlineArrayList.add(bomline);
       }return bomlineArrayList;
   }

    public ArrayList<Bomline> calculateWeatherBoardForSide(ArrayList<Material> weatherBoardArrayList, int carportLength) {

        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();
        Material sideWeatherBoard = calculateMaterialLength(carportLength, weatherBoardArrayList);
        if (sideWeatherBoard == null) {

            ArrayList<Material> sideWeatherBoardList = calculateMaterialIfMoreThanOneIsNeeded(carportLength, weatherBoardArrayList);

            for (Material material : sideWeatherBoardList) {

                Bomline bomline = new Bomline(13, material, 2);
                bomlineArrayList.add(bomline);

            }
        } else {
            Bomline bomline = new Bomline(13, sideWeatherBoard, 2);
            bomlineArrayList.add(bomline);
        }
        return bomlineArrayList;
    }

    public ArrayList<Bomline> calculateWeatherBoardForFrontAndBack(ArrayList<Material> weatherBoardArrayList, int rafterLength) {

        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();
        Material frontAndSideWeatherBoard = calculateMaterialLength(rafterLength + 5, weatherBoardArrayList);
        if (frontAndSideWeatherBoard == null) {

            ArrayList<Material> frontAndBackWeatherBoardList = calculateMaterialIfMoreThanOneIsNeeded(rafterLength, weatherBoardArrayList);

            for (Material material : frontAndBackWeatherBoardList) {

                Bomline bomline = new Bomline(14, material, 2);
                bomlineArrayList.add(bomline);

            }
        } else {
            Bomline bomline = new Bomline(14, frontAndSideWeatherBoard, 2);
            bomlineArrayList.add(bomline);
        }
        return bomlineArrayList;
    }

    public int calculatePostAmountWithShed(int carportLength, int shedLength)
    {
        int posts = 0;
        int sidePosts = 2;
        int shedPosts = 4;
        int sparePost = 1;
        int minDistanceBetweenPost = 250;
        int maxDistanceBetweenPost = 310;

        if (carportLength - shedLength < maxDistanceBetweenPost)
        {
            posts = 2;
        }

        else
        {
            posts = 4 ;
        }

        int totalPosts = posts + shedPosts + sidePosts + sparePost;

        return  totalPosts;

    }

    public int calculatePostAmount(int carportLength) {

        int minDistanceBetweenPost = 250;
        int maxDistanceBetweenPost = 310;
        int minDistanceFromStern = 45;
        int maxDistanceFromStern = 100;
        int postDistance = 0;
        int post = 0;


        if (minDistanceFromStern == 45 && maxDistanceFromStern == 100) {
            postDistance = carportLength - minDistanceFromStern;
            postDistance = postDistance / 2;

            if (postDistance < minDistanceBetweenPost) {
                post = 0;
            } else if (postDistance > minDistanceBetweenPost && postDistance < maxDistanceBetweenPost) {
                post = 1;
            } else if (postDistance > maxDistanceBetweenPost) {
                post = 2;
            }

        }

        return post * 2 + 4;

    }

    public int calculateCarriageBolt(int carportLength) {

        int carriageBolt = 2;

        carriageBolt = carriageBolt * calculatePostAmount(carportLength);

        return carriageBolt;
    }

    public int calculateSquareSpacer(int carriageBolt) {

        int squareSpacer;

        squareSpacer = carriageBolt * 2;

        return squareSpacer;
    }

    public int calculateRafters(int carportLength){

        int distance = 59;
        int rafters = 0;

        rafters = carportLength / distance + 2;

        return rafters;
    }

    public float calculateRaftersDistance(float carportLength, float rafters){

        float newDistance = 0;
        float rafterWidth = 4.5f;

        newDistance = carportLength / rafters + rafterWidth;

        return  newDistance;
    }

    public int calculateSteelBracketRight(int rafters){

        int steelBracket = 0;

        steelBracket = rafters;

        return steelBracket;
    }

    public int calculateSteelBracketLeft(int rafters){

        int steelBracket = 0;

        steelBracket = rafters;

        return steelBracket;
    }

    public int calculateScrewForBracket(int bracket){

         int screws = 0;

         screws = (bracket*2) * 9;

         return screws;
    }

    public int calculateScrewForPerforatedTape(int rafters){

        int screws = 0;
        int perforatedTape = 2;

        screws = (rafters - 2) * perforatedTape;
        screws = screws * 2;

        return screws;

    }

    public Bomline postAmount(Material material, int carportLength){
        int post = calculatePostAmount(carportLength);

        Bomline bomline = new Bomline(11, material, post);
        return bomline;
    }

    public Bomline carriageBolt(Material material, int carportLength){
        int bolt = calculateCarriageBolt(carportLength);

        Bomline bomline = new Bomline(21, material, bolt);
        return bomline;
    }

    public Bomline squareSpacer(Material material, int carriageBolt){
        int spacer = calculateSquareSpacer(carriageBolt);

        Bomline bomline = new Bomline(21, material, spacer);
        return bomline;
    }

    public Bomline rafters(Material material, int carportLength){
        int rafter = calculateRafters(carportLength);

        Bomline bomline = new Bomline(10, material, rafter);
        return bomline;
    }

    public Bomline steelBracketRight(Material material, int rafters){
        int steelBrackets = calculateSteelBracketRight(rafters);

        Bomline bomline = new Bomline(18, material, steelBrackets);
        return bomline;
    }

    public Bomline steelBracketLeft(Material material, int rafters){
        int steelBrackets = calculateSteelBracketLeft(rafters);

        Bomline bomline = new Bomline(18, material, steelBrackets);
        return bomline;
    }

    public Bomline screwsForTapeAndBracket(Material material, int bracket, int rafters){
        int screwsForBrackets = calculateScrewForBracket(bracket);
        int screwsForTape = calculateScrewForPerforatedTape(rafters);
        int screwBoxes = calculateQuantityOfBoxes(screwsForTape + screwsForBrackets, material);

        Bomline bomline = new Bomline(20, material, screwBoxes);
        return bomline;
    }


    public ArrayList <Bomline> calculateHead (int carportLength, ArrayList<Material> headArrayList, int shedLength) {
        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();
        Material head1 = calculateMaterialLength(carportLength - shedLength, headArrayList);

            Material headForShed = null;

            for (Material m : headArrayList) {
                if (m.getLength() > shedLength) {
                    headForShed = m;
                    break;
                }
            }
            if (headForShed == null) {
                throw new ArithmeticException("Kunne ikke finde en rem som passer til dit skur");
            }

            bomlineArrayList.add(new Bomline(8,head1,2));
            bomlineArrayList.add(new Bomline(9,headForShed,1));


        return bomlineArrayList;
    }


    public Bomline calculateAngleBracket (int noggingAmount) {

        Bomline bomline = new Bomline(26,materialArrayList.get(29),noggingAmount*2);
        return bomline;
    }


    public ArrayList<Bomline> calculateNoggingAndBracket(int shedLength, ArrayList<Material> noggingArrayList)
    {
        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();

        Material noggingTheShortOne = calculateMaterialLength(shedLength, noggingArrayList);
        Material noggingTheLongOne = calculateMaterialLength(250, noggingArrayList);
        bomlineArrayList.add(new Bomline(6,noggingTheShortOne,4));
        bomlineArrayList.add(new Bomline(7, noggingTheLongOne,12));

        bomlineArrayList.add(calculateAngleBracket(16));



        return bomlineArrayList;
    }

    public ArrayList<Bomline> createCarportNoShed(int carportLength, int carportWidth)
    {
        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();
        int rafters = calculateRafters(carportLength);
        int brackets = calculateSteelBracketLeft(rafters) * 2;

        ArrayList<Material> noggingArrayList = new ArrayList<>();
        noggingArrayList.add(materialArrayList.get(6));
        noggingArrayList.add(materialArrayList.get(5));

        ArrayList<Material> headArrayList = new ArrayList<>();
        headArrayList.add(materialArrayList.get(8));
        headArrayList.add(materialArrayList.get(7));

        ArrayList<Material> roofPlatesArraylist = new ArrayList<>();
        roofPlatesArraylist.add(materialArrayList.get(13));
        roofPlatesArraylist.add(materialArrayList.get(14));

        ArrayList<Material> overSternArrayList = new ArrayList<>();
        overSternArrayList.add(materialArrayList.get(2));
        overSternArrayList.add(materialArrayList.get(3));

        ArrayList<Material> underSternArrayList = new ArrayList<>();
        underSternArrayList.add(materialArrayList.get(0));
        underSternArrayList.add(materialArrayList.get(1));

        ArrayList<Material> weatherboardArrayList = new ArrayList<>();
        weatherboardArrayList.add(materialArrayList.get(11));
        weatherboardArrayList.add(materialArrayList.get(12));

        // tilføj stolper til arraylist
        bomlineArrayList.add(postAmount(materialArrayList.get(9), carportLength));

        // tilføj bræddebolte til arraylist
        bomlineArrayList.add(carriageBolt(materialArrayList.get(22), carportLength));

        // tilføj firkantskiver til arraylist
        bomlineArrayList.add(squareSpacer(materialArrayList.get(23), calculateCarriageBolt(carportLength)));

        // tilføj spær til arraylist
        bomlineArrayList.add(rafters(materialArrayList.get(7), carportLength));

        // tilføj venstre beslag til arraylist
        bomlineArrayList.add(steelBracketLeft(materialArrayList.get(18), rafters));

        // tilføj højre beslag til arraylist
        bomlineArrayList.add(steelBracketRight(materialArrayList.get(17), rafters));

        // tilføj skruer til beslag og hulbånd til arraylist
        bomlineArrayList.add(screwsForTapeAndBracket(materialArrayList.get(21), brackets, rafters));

        // tilføj tagplader og skruer til arraylist
        bomlineArrayList.addAll(calculateRoofPlates(carportLength, carportWidth, roofPlatesArraylist ));
        bomlineArrayList.add(calculateAmountOfBoxesOfBottomScrews(materialArrayList.get(15), carportWidth, carportLength));

        // tilføj overstern til arraylist
        bomlineArrayList.addAll(calculateFrontAndBackStern(overSternArrayList, carportWidth));
        bomlineArrayList.addAll(calculateSideStern(overSternArrayList, carportLength));

        // tilføj understern til arraylist
        //TODO Lav understern funktion så beskrivelse bliver rigtig.
        bomlineArrayList.addAll(calculateFrontAndBackStern(underSternArrayList, carportWidth));
        bomlineArrayList.addAll(calculateSideStern(underSternArrayList, carportLength));

        // tilføj vandbræt til arraylist
        bomlineArrayList.addAll(calculateWeatherBoardForFrontAndBack(weatherboardArrayList, carportWidth));
        bomlineArrayList.addAll(calculateWeatherBoardForSide(weatherboardArrayList, carportLength));


        //tilføj rem til arraylist
        bomlineArrayList.addAll(calculateHead(carportLength,headArrayList, 210));

        //tilføj løsholt og vinkelbeslag til arraylist
        bomlineArrayList.addAll(calculateNoggingAndBracket(210,noggingArrayList));






        return bomlineArrayList;
    }
}
