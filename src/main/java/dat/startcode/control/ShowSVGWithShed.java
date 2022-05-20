package dat.startcode.control;

import dat.startcode.model.entities.CarportCalculator;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSVGWithShed extends CommandUnprotectedPage {

    public ShowSVGWithShed(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        CarportRequest carportRequest = (CarportRequest) session.getAttribute("newCarportRequest");
        CarportCalculator carportCalculator = new CarportCalculator();

        SVG svg = new SVG(75, 10, "0 0 800 600", 500, 500);

        for (int x = 0; x < carportCalculator.calculateRafters(carportRequest.getLength()); x++) {
            svg.addRect((int) (0 + carportCalculator.calculateRaftersDistance(carportRequest.getLength(), carportCalculator.calculateRafters(carportRequest.getLength())) * x), 0, carportRequest.getWidth(), 4.5f);

        }
        /*Top rem*/
        svg.addLine(0, 0, carportRequest.getLength(), 0);

        /*Bund rem*/
        svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength(), carportRequest.getWidth());

        /*Hulbånd*/
        svg.addLineWithDash(55, 0, carportCalculator.calculatePerforatedTapeLength(carportRequest.getLength()) - carportRequest.getShedLength() + 50, carportRequest.getWidth());
        svg.addLineWithDash(carportCalculator.calculatePerforatedTapeLength(carportRequest.getLength()) - carportRequest.getShedLength() + 50, 0, 55, carportRequest.getWidth());

        /*Stolper fast*/
        svg.addRect(45, 0, 15, 15);
        svg.addRect(45, carportRequest.getWidth() - 15, 15, 15);
        svg.addRect(carportRequest.getLength() - 45, 0, 15, 15);
        svg.addRect(carportRequest.getLength() - 45, carportRequest.getWidth() - 15, 15, 15);

        /*Skur væg*/
        int shedStart = carportRequest.getLength() - carportRequest.getShedLength();
        svg.addLine(shedStart, 0, shedStart, carportRequest.getWidth());

        /*Stolper på skur / midten*/
        int yPosShed = carportRequest.getWidth() / 2;
        svg.addRect(shedStart, yPosShed, 15, 15);

        int xPosShed = carportRequest.getLength() - 10;
        svg.addRect(xPosShed, carportRequest.getWidth() / 2, 15, 15);

        /*Stolper på skur*/
        int xPos = carportRequest.getLength()-carportRequest.getShedLength();
        svg.addRect(xPos,0,15,15);

        svg.addRect(xPos,carportRequest.getWidth()-15,15,15);

        request.setAttribute("svgdrawing", svg.toString());
        return pageToShow;
    }
}
