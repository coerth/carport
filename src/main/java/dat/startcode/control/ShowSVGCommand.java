package dat.startcode.control;

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


        SVG arrowsvg = new SVG(0, 0, "0 0 855 690", 50, 50);
        SVG svg = new SVG(75, 10, "0 0 780 600", 50, 50);


        for (int x = 0; x < 14; x++) {
            svg.addRect(0 + 55 * x, 0, 600.0, 4.5);

            /*Top og bund rem*/
            svg.addLine(0, 0, carportRequest.getLength(), 0);
            svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength(), carportRequest.getWidth());

            /*Højre side af rammen*/
            svg.addLine(carportRequest.getLength(), 0, carportRequest.getLength(), carportRequest.getWidth());

            /*Venstre side af rammen*/
            svg.addLine(0, 0, 0, carportRequest.getWidth());
            System.out.println(svg);
            /*Skur væg venstre side*/
            svg.addLine(carportRequest.getLength(), carportRequest.getWidth(), carportRequest.getLength(), carportRequest.getWidth());
            svg.addLine(545, 65, 545, 535);

            svg.addLine(752, 65, 752, 535);
            svg.addLine(763, 65, 763, 535);

            /*Stolper skur i midten venstre og højre*/
            svg.addRect(535, 265, 10, 10);
            svg.addRect(752, 265, 10, 10);

            /*Inder rem*/
            svg.addLine(0, 70, 780, 70);
            svg.addLine(0, 65, 780, 65);

            svg.addLine(0, 530, 780, 530);
            svg.addLine(0, 535, 780, 535);

            svg.addLine(55, 70, 530, 530);
            svg.addLine(530, 70, 55, 530);

            svg.addRect(110, 63, 10, 10);
            svg.addRect(412, 63, 10, 10);
            svg.addRect(752, 63, 10, 10);

            svg.addRect(110, 527, 10, 10);
            svg.addRect(412, 527, 10, 10);
            svg.addRect(752, 527, 10, 10);
        }


        arrowsvg.addSvg(svg);
        request.setAttribute("svgdrawing", svg.toString());
        return pageToShow;
    }
}
