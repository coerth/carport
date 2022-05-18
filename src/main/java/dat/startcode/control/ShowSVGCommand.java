package dat.startcode.control;

import dat.startcode.model.entities.CarportCalculator;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.services.CarportRequestFacade;
import dat.startcode.model.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSVGCommand extends CommandUnprotectedPage {

    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        CarportRequest carportRequest = (CarportRequest) session.getAttribute("newCarportRequest");
        CarportCalculator carportCalculator = new CarportCalculator();


/*
        SVG arrowsvg = new SVG(0, 0, "0 0 855 690", 50, 50);
*/
        SVG svg = new SVG(75, 10, "0 0 800 600", 50, 50);


        for (int x = 0; x < carportCalculator.calculateRafters(carportRequest.getLength()); x++) {
            svg.addRect((0 + carportCalculator.calculateRaftersDistance(carportRequest.getLength(), carportCalculator.calculateRafters(carportRequest.getLength())) * x), 0, carportRequest.getWidth(), 4.5f);

            /*Top og bund rem*/
            if (carportRequest.getLength()>= 780) {
                svg.addLine(0, 0, carportRequest.getLength() + 10f, 0);
                svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength() + 10f, carportRequest.getWidth());
            } else if(carportRequest.getLength()< 780 && carportRequest.getLength() >= 660) {
                svg.addLine(0, 0, carportRequest.getLength() + 7.5f, 0);
                svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength() + 7.5f, carportRequest.getWidth());
            } else if(carportRequest.getLength()<660 && carportRequest.getLength()>=540) {
                svg.addLine(0, 0, carportRequest.getLength(), 0);
                svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength(), carportRequest.getWidth());
            } else if(carportRequest.getLength()<540 && carportRequest.getLength()>=420){
                svg.addLine(0, 0, carportRequest.getLength()- 7.5f, 0);
                svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength() -7.5f , carportRequest.getWidth());
            } else if(carportRequest.getLength()<420 && carportRequest.getLength() >=300){
            svg.addLine(0, 0, carportRequest.getLength() - 10, 0);
            svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength() - 10, carportRequest.getWidth());
            } else if(carportRequest.getLength()<300){
            svg.addLine(0, 0, carportRequest.getLength() - 13, 0);
            svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength() - 13, carportRequest.getWidth());
            }





//            /*Skur væg venstre side*/
//            svg.addLine(carportRequest.getShedLength(), carportRequest.getWidth(), carportRequest.getShedLength(), carportRequest.getShedWidth());
//
//            /*Skur væg højre side*/
//            svg.addLine(carportRequest.getShedLength(), carportRequest.getShedWidth(), carportRequest.getShedLength(), carportRequest.getShedWidth());


//            /*Stolper skur i midten venstre og højre*/
//            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
//            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);

            /*Inder rem*//*
            svg.addLine(0, 70, 780, 70);
            svg.addLine(0, 65, 780, 65);

            svg.addLine(0, 530, 780, 530);
            svg.addLine(0, 535, 780, 535);

            *//*Hulbånd på kryds*//*
            svg.addLine(55, 70, 530, 530);
            svg.addLine(530, 70, 55, 530);*/

//            /*Stolper øvre*/
//            for (int i = 0; i < carportCalculator.calculatePostAmount(carportRequest.getLength()); i++) {
//
//                svg.addRect(45 + (carportCalculator.calculatePostDistance(carportRequest.getLength() * i)), 0, 10, 10);
//            }

//            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
//            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
//            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
//
//            /*Stolper nedre*/
//            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
//            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
//            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
        }


        request.setAttribute("svgdrawing", svg.toString());
        return pageToShow;
    }
}
