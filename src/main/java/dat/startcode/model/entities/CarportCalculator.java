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



    public int calculateScrewForBracket(int steelBracket){

         int screws = 0;

         screws = steelBracket * 9;

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

        Bomline bomline = new Bomline("Stolper til carport", material, post);
        return bomline;
    }

    public Bomline carriageBolt(Material material, int carportLength){
        int bolt = calculateCarriageBolt(carportLength);

        Bomline bomline = new Bomline("Breddebolte til montering af rem på stolper", material, bolt);
        return bomline;
    }

    public Bomline squareSpacer(Material material, int carriageBolt){
        int spacer = calculateSquareSpacer(carriageBolt);

        Bomline bomline = new Bomline("Firkantskiver til montering af rem på stolper", material, spacer);
        return bomline;
    }

    public Bomline rafters(Material material, int carportLength){
        int rafter = calculateRafters(carportLength);

        Bomline bomline = new Bomline("Spær, monteres på rem", material, rafter);
        return bomline;
    }

    public Bomline steelBracketRight(Material material, int rafters){
        int steelBrackets = calculateSteelBracketRight(rafters);

        Bomline bomline = new Bomline("Universal beslag til montering af spær på rem", material, steelBrackets);
        return bomline;
    }

    public Bomline steelBracketLeft(Material material, int rafters){
        int steelBrackets = calculateSteelBracketLeft(rafters);

        Bomline bomline = new Bomline("Universal beslag til montering af spær på rem", material, steelBrackets);
        return bomline;
    }

    public Bomline screwsForBrackets(Material material, int steelBracket){
        int screws = calculateScrewForBracket(steelBracket);

        Bomline bomline = new Bomline("Skruer til montering af universalbeslag", material, screws);
        return bomline;
    }

    public Bomline screwsForPerforatedTape(Material material, int rafters){
        int screws = calculateScrewForPerforatedTape(rafters);

        Bomline bomline = new Bomline("Skruer til hulbånd", material, screws);
        return bomline;
    }
}
