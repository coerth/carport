package dat.startcode.model.entities;

import java.util.ArrayList;

public class CarportCalculator
{



    public ArrayList<BomLine> calculateRoofPlates(int carportLength, int carportWidth, ArrayList<Material> listOfRoofPlates)
    {
        ArrayList<BomLine> bomLineArrayList = new ArrayList<BomLine>();
        //ArrayList<Material> listOfRoofPlates = new ArrayList<>();
        Material primaryRoofPlate = null;

        for(Material m : listOfRoofPlates)
        {
            if(m.getLength() > carportLength)
            {

                primaryRoofPlate = m;

            }
        }


        if(primaryRoofPlate != null)
        {
          int amount = calculateAmountOfRoofPlatesForWidth(primaryRoofPlate, carportWidth);
          bomLineArrayList.add(new BomLine(primaryRoofPlate, amount));
        }
        else
        {
            primaryRoofPlate = new Material(1,"tagplade",110, "stk", 600, 109, 1, 1);
            Material secondaryRoofPlate = null;
            for(Material m : listOfRoofPlates)
            {
                if(primaryRoofPlate.getLength() + m.getLength() > carportLength)
                {
                    secondaryRoofPlate = m;
                    break;
                }
            }
            if(secondaryRoofPlate == null)
            {
                throw new ArithmeticException("Kunne ikke lave en lang nok tagplade");
            }
            int amount = calculateAmountOfRoofPlatesForWidth(primaryRoofPlate, carportWidth);
            bomLineArrayList.add(new BomLine(primaryRoofPlate, amount));
            bomLineArrayList.add(new BomLine(secondaryRoofPlate, amount));


        }



       int carportArea = carportLength * carportWidth;

       if(carportLength > primaryRoofPlate.getLength())
       {
           for(Material m : listOfRoofPlates)
           {
               if(primaryRoofPlate.getLength() + m.getLength() > carportLength)
               {

               }
           }
       }
        return bomLineArrayList;
    }


    public int calculateAmountOfRoofPlatesForWidth(Material material, int carportWidth)
    {
        if(material.getWidth() > carportWidth)
        {
            return 1;
        }

        else
        {
            int amount = 1;
            while(material.getWidth() * amount < carportWidth )
            {
                amount++;
            }
            return amount;
        }
    }
}
