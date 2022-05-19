package dat.startcode.model.entities;

import java.util.ArrayList;

public class CarportCalculator {

    public int calculatePostAmountNeeded(int carportLength) {
        int minDistanceFromStern = 45;
        int distanceBetweenPost = carportLength - minDistanceFromStern * 2;
        int post = 0;

        if (distanceBetweenPost < 310) {
            return post + 2;
        } else if (distanceBetweenPost / 2 < 310) {
            return post + 3;
        } else {
            return post + 4;
        }
    }

    public int calculateXDistance(int carportLength) {
        int minDistanceFromStern = 45;
        int distanceBetweenPost = carportLength - minDistanceFromStern * 2;
        int post1 = minDistanceFromStern;
        if (distanceBetweenPost < 310) {
            return distanceBetweenPost;
        } else if (distanceBetweenPost / 2 < 310) {
            return distanceBetweenPost / 2;

        } else if (distanceBetweenPost / 3 < 310) {
            return distanceBetweenPost / 3;
        }
        return distanceBetweenPost;
    }

    public int calculatePostDistance(int carportLength) {
        int postDistance = 0;
        int distanceFromSternBigCarport = 100;
        int distanceFromSternSmallCarport = 90;
        int restCarportLength = 0;


        if (carportLength >= 240 && carportLength < 310) {
            restCarportLength = carportLength - distanceFromSternSmallCarport;
            postDistance = restCarportLength;
        } else if (carportLength >= 310 && carportLength < 480) {
            restCarportLength = carportLength - distanceFromSternSmallCarport;
            postDistance = restCarportLength / 2;
        } else if (carportLength >= 480 && carportLength < 600) {
            restCarportLength = carportLength - distanceFromSternBigCarport;
            postDistance = restCarportLength / 2;
        } else if (carportLength >= 600) {
            restCarportLength = carportLength - distanceFromSternBigCarport;
            postDistance = restCarportLength / 3;
        }
        return postDistance;

    }

    public int calculatePostDistanceWithFullShedLength(int carportLength, int shedLength) {
        int postDistance = 0;
        int minDistanceFromStern = 50;
        int maxDistanceFromStern = 100;
        int restCarportLength = 0;
        int maxPostDistance = 310;
        int minPostDistance = 280;

        if (carportLength >= 780) {
            restCarportLength = shedLength + maxDistanceFromStern;
            restCarportLength = carportLength - restCarportLength;
            restCarportLength = restCarportLength - maxPostDistance;
            postDistance = restCarportLength - 30;
        } else if (carportLength < 780) {
            restCarportLength = shedLength + minDistanceFromStern;
            restCarportLength = carportLength - restCarportLength;
            restCarportLength = restCarportLength - minPostDistance;
            postDistance = restCarportLength;
        }
        return postDistance;
    }

    public int calculatePostDistanceWithFullShedWidth(int shedWidth) {
        int postDistance = 0;

        postDistance = shedWidth / 2;

        return postDistance;
    }

    public int calculatePerforatedTapeLength(int carportLength) {

        int perforatedTapeLength = 0;
        int maxRafterDistance = 59;

        perforatedTapeLength = carportLength - maxRafterDistance;
        return perforatedTapeLength;

    }

    public int calculatePerforatedtapeLengthWithShed(int carportLength, int shedLength) {

        int perforatedTapeLength = 0;
        int maxRafterDistance = 59;

        perforatedTapeLength = carportLength - shedLength;
        perforatedTapeLength = perforatedTapeLength - maxRafterDistance;
        return perforatedTapeLength;

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
            bomLineArrayList.add(new Bomline("tagplader monteres på spær", primaryRoofPlate, amount));
        } else {
            primaryRoofPlate = new Material(1, "tagplade", 110, "stk", 600, 109, 1, 1);
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
            bomLineArrayList.add(new Bomline("tagplader monteres på spær", primaryRoofPlate, amount));
            bomLineArrayList.add(new Bomline("tagplader monteres på spær", secondaryRoofPlate, amount));

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
        int quantity = (carportWidth * carportLength) * 13;

        return quantity;
    }


    public Bomline calculateAmountOfBoxesOfBottomScrews(Material material, int carportWidth, int carportLength) {

        int screwsNeeded = calculateBottomScrewForRoof(carportWidth, carportLength);
        int boxesNeeded = calculateQuantityOfBoxes(screwsNeeded, material);

        Bomline bomline = new Bomline("Skruer til tagplader", material, boxesNeeded);
        return bomline;
    }

    public ArrayList<Bomline> calculateFrontAndBackStern(ArrayList<Material> sternArrayList, int rafterLength) {
        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();
        Material frontAndBackStern = calculateMaterialLength(rafterLength, sternArrayList);
        if (frontAndBackStern == null) {
            ArrayList<Material> frontAndBackSternArrayList = calculateMaterialIfMoreThanOneIsNeeded(rafterLength + 5, sternArrayList);

            for (Material material : frontAndBackSternArrayList) {

                Bomline bomline = new Bomline("oversternbrædder til forenden", material, 2);
                bomlineArrayList.add(bomline);
            }
        } else {
            Bomline bomline = new Bomline("oversternbrædder til forenden", frontAndBackStern, 2);
            bomlineArrayList.add(bomline);
        }
        return bomlineArrayList;
    }

    public ArrayList<Bomline> calculateSideStern(ArrayList<Material> sternArrayList, int carportLength) {
        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();
        Material sideStern = calculateMaterialLength(carportLength, sternArrayList);
        if (sideStern == null) {
            ArrayList<Material> sideSternArrayList = calculateMaterialIfMoreThanOneIsNeeded(carportLength, sternArrayList);
            for (Material material : sideSternArrayList) {
                Bomline bomline = new Bomline("oversternbrædder til siderne", material, 2);
                bomlineArrayList.add(bomline);
            }
        } else {
            Bomline bomline = new Bomline("oversternbrædder til siderne", sideStern, 2);
            bomlineArrayList.add(bomline);
        }
        return bomlineArrayList;
    }

    public ArrayList<Bomline> calculateWeatherBoardForSide(ArrayList<Material> weatherBoardArrayList, int carportLength) {

        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();
        Material sideWeatherBoard = calculateMaterialLength(carportLength, weatherBoardArrayList);
        if (sideWeatherBoard == null) {

            ArrayList<Material> sideWeatherBoardList = calculateMaterialIfMoreThanOneIsNeeded(carportLength, weatherBoardArrayList);

            for (Material material : sideWeatherBoardList) {

                Bomline bomline = new Bomline("vandbrædt på stern i sider", material, 2);
                bomlineArrayList.add(bomline);

            }
        } else {
            Bomline bomline = new Bomline("vandbrædt på stern i sider", sideWeatherBoard, 2);
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

                Bomline bomline = new Bomline("vandbrædt på stern i forende", material, 2);
                bomlineArrayList.add(bomline);

            }
        } else {
            Bomline bomline = new Bomline("vandbrædt på stern i forende", frontAndSideWeatherBoard, 2);
            bomlineArrayList.add(bomline);
        }
        return bomlineArrayList;
    }

    public int calculatePostAmount(int carportLength) {

        int minDistanceBetweenPost = 250;
        int maxDistanceBetweenPost = 310;
        int minDistanceFromStern = 90;
        int maxDistanceFromStern = 100;
        int postDistance = 0;
        int post = 0;


        if (minDistanceFromStern == 90 && maxDistanceFromStern == 100) {
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

        return post * 2 + 2;

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

    public int calculateRafters(int carportLength) {

        int distance = 59;
        int rafters = 0;

        rafters = carportLength / distance + 2;

        return rafters;
    }

    public float calculateRaftersDistance(float carportLength, float rafters) {

        float newDistance = 0;
        float rafterWidth = 4.5f;

        newDistance = carportLength / rafters + rafterWidth;

        return newDistance;
    }

    public int calculateSteelBracketRight(int rafters) {

        int steelBracket = 0;

        steelBracket = rafters;

        return steelBracket;
    }

    public int calculateSteelBracketLeft(int rafters) {

        int steelBracket = 0;

        steelBracket = rafters;

        return steelBracket;
    }

    public int calculateScrewForBracket(int bracket) {

        int screws = 0;

        screws = (bracket * 2) * 9;

        return screws;
    }

    public int calculateScrewForPerforatedTape(int rafters) {

        int screws = 0;
        int perforatedTape = 2;

        screws = (rafters - 2) * perforatedTape;
        screws = screws * 2;

        return screws;

    }

    public Bomline postAmount(Material material, int carportLength) {
        int post = calculatePostAmount(carportLength);

        Bomline bomline = new Bomline("Stolper til carport", material, post);
        return bomline;
    }

    public Bomline carriageBolt(Material material, int carportLength) {
        int bolt = calculateCarriageBolt(carportLength);

        Bomline bomline = new Bomline("Breddebolte til montering af rem på stolper", material, bolt);
        return bomline;
    }

    public Bomline squareSpacer(Material material, int carriageBolt) {
        int spacer = calculateSquareSpacer(carriageBolt);

        Bomline bomline = new Bomline("Firkantskiver til montering af rem på stolper", material, spacer);
        return bomline;
    }

    public Bomline rafters(Material material, int carportLength) {
        int rafter = calculateRafters(carportLength);

        Bomline bomline = new Bomline("Spær, monteres på rem", material, rafter);
        return bomline;
    }

    public Bomline steelBracketRight(Material material, int rafters) {
        int steelBrackets = calculateSteelBracketRight(rafters);

        Bomline bomline = new Bomline("Universal beslag til montering af spær på rem", material, steelBrackets);
        return bomline;
    }

    public Bomline steelBracketLeft(Material material, int rafters) {
        int steelBrackets = calculateSteelBracketLeft(rafters);

        Bomline bomline = new Bomline("Universal beslag til montering af spær på rem", material, steelBrackets);
        return bomline;
    }

    public Bomline screwsForTapeAndBracket(Material material, int bracket, int rafters) {
        int screwsForBrackets = calculateScrewForBracket(bracket);
        int screwsForTape = calculateScrewForPerforatedTape(rafters);
        int screwBoxes = calculateQuantityOfBoxes(screwsForTape + screwsForBrackets, material);

        Bomline bomline = new Bomline("Skruer til universalbeslag & hulbånd", material, screwBoxes);
        return bomline;
    }
}
