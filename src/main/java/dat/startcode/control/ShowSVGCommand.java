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
        SVG svg = new SVG(75, 10, "0 0 780 600", 50, 50);


        for (int x = 0; x < carportCalculator.calculatePostAmount(carportRequest.getLength()); x++) {
            svg.addRect((int) (0 + carportCalculator.calculateRaftersDistance(carportRequest.getLength(),carportCalculator.calculateRafters(carportRequest.getLength())) * x), 0, carportRequest.getWidth(), 4);

            /*Top og bund rem*/
            svg.addLine(0, 0, carportRequest.getLength(), 0);
            svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength(), carportRequest.getWidth());

            /*Højre side af rammen*/
            svg.addLine(carportRequest.getLength(), 0, carportRequest.getLength(), carportRequest.getWidth());

            /*Venstre side af rammen*/
            svg.addLine(0, 0, 0, carportRequest.getWidth());


            /*Skur væg venstre side*/
            svg.addLine(carportRequest.getShedLength(), carportRequest.getWidth(), carportRequest.getShedLength(), carportRequest.getShedWidth());

            /*Skur væg højre side*/
            svg.addLine(carportRequest.getShedLength(), carportRequest.getShedWidth(), carportRequest.getShedLength(), carportRequest.getShedWidth());


            /*Stolper skur i midten venstre og højre*/
            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);

            /*Inder rem*//*
            svg.addLine(0, 70, 780, 70);
            svg.addLine(0, 65, 780, 65);

            svg.addLine(0, 530, 780, 530);
            svg.addLine(0, 535, 780, 535);

            *//*Hulbånd på kryds*//*
            svg.addLine(55, 70, 530, 530);
            svg.addLine(530, 70, 55, 530);*/

            /*Stolper øvre*/
            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);

            /*Stolper nedre*/
            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
            svg.addRect(carportRequest.getLength(), carportRequest.getWidth(), 10, 10);
        }


        request.setAttribute("svgdrawing", svg.toString());
        return pageToShow;
    }
}
