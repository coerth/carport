package dat.startcode.model.entities;

public class CarportCalculator {


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
    public int calculateSteelBracket(int rafters){

        int steelBracket = 0;

        steelBracket = rafters * 2;

        return steelBracket;
    }
}
