package dat.startcode.model.entities;

import java.util.ArrayList;

public class CarportCalculator {


    public Material calculateMaterialLength(int dimension, ArrayList<Material> listOfMaterials) {

        for (Material material : listOfMaterials) {
            if (material.getLength() > dimension) {
                return material;
            }
        }
        return null;
    }

    public ArrayList calculateMaterialIfMoreThanOneIsNeeded(int dimension, ArrayList<Material> listOfMaterials) {

        ArrayList<Material> materialArrayList = null;
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


    public int calculateQuantityOfBoxes(int amountToBeUsed, Material material) {

        int amount = 1;

        while (amountToBeUsed < material.getQuantity() * amount) {
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

    public Bomline calculateAmountOfBoxesOfBottomScrews(int quantity, Material material, int carportWidth, int carportLength) {

        int screwsNeeded = calculateBottomScrewForRoof(carportWidth, carportLength);
        int boxesNeeded = calculateQuantityOfBoxes(screwsNeeded, material);

        Bomline bomline = new Bomline("Skruer til tagplader", material, boxesNeeded);
        return bomline;
    }

    public Bomline calculateFrontAndBackSternLength(ArrayList<Material> frontAndBackSternArrayList, int rafterLength) {
        Material backAndFrontStern = calculateMaterialLength(rafterLength + 5, frontAndBackSternArrayList);
        Bomline bomline = new Bomline("oversternbrædder til forenden", backAndFrontStern, 2);
        return bomline;
    }

    public Bomline calculateSideStern(ArrayList<Material> sideSternArrayList, int carportLength) {
        Material sideStern = calculateMaterialLength(carportLength, sideSternArrayList);
        Bomline bomline = new Bomline("oversternbrædder til siderne", sideStern, 2);
        return bomline;
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

}
