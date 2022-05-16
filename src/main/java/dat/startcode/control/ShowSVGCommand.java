package dat.startcode.control;

import dat.startcode.model.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSVGCommand extends CommandUnprotectedPage {

    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CarportRequest carportRequest = request.getAttribute("CarportObject");


        SVG arrowsvg = new SVG(0, 0, "0 0 855 690", 50, 50);
        SVG svg = new SVG(75, 10, "0 0 780 600", 50, 50);


        for (int x = 0; x < 14; x++) {
            svg.addRect(0 + 55 * x, 0, 600.0, 4.5);
            svg.addLine(0, 0, 780, 0);
            svg.addLine(0, 600, 780, 600);

            svg.addLine(780, 0, 780, 600);
            svg.addLine(775, 0, 775, 600);

            svg.addLine(0, 0, 0, 600);
            svg.addLine(5, 0, 5, 600);

            svg.addLine(535, 65, 535, 535);
            svg.addLine(545, 65, 545, 535);

            svg.addLine(752, 65, 752, 535);
            svg.addLine(763, 65, 763, 535);

            svg.addRect(535, 265, 10, 10);
            svg.addRect(752, 265, 10, 10);

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
