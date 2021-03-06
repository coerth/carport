/*package dat.startcode.control;

import dat.startcode.model.entities.calculator.CarportCalculator;
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



        SVG svg = new SVG(75, 10, "0 0 800 600", 500, 500);


        for (int x = 0; x < carportCalculator.calculateRafters(carportRequest.getLength()); x++) {
            svg.addRect((int) (0 + carportCalculator.calculateRaftersDistance(carportRequest.getLength(), carportCalculator.calculateRafters(carportRequest.getLength())) * x), 0, carportRequest.getWidth(), 4.5f);

            *//*Top rem*//*
            svg.addLine(0, 0, carportRequest.getLength(), 0);

            *//*Bund rem*//*
            svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength(), carportRequest.getWidth());

            *//*Hulbånd*//*
            svg.addLineWithDash(55, 0, carportCalculator.calculatePerforatedTapeLength(carportRequest.getLength()), carportRequest.getWidth());
            svg.addLineWithDash(carportCalculator.calculatePerforatedTapeLength(carportRequest.getLength()), 0, 55, carportRequest.getWidth());

            *//*Stolper fast*//*
            svg.addRect(45, 0, 15, 15);
            svg.addRect(45, carportRequest.getWidth() - 15, 15, 15);
            svg.addRect(carportRequest.getLength() - 45, 0, 15, 15);
            svg.addRect(carportRequest.getLength() - 45, carportRequest.getWidth() - 15, 15, 15);

            *//*Midter stolper*//*
            if (carportCalculator.calculatePostAmountNeeded(carportRequest.getLength()) == 3) {
                svg.addRect(45 + carportCalculator.calculateXDistance(carportRequest.getLength()), 0, 15, 15);
                svg.addRect(45 + carportCalculator.calculateXDistance(carportRequest.getLength()), carportRequest.getWidth() - 15, 15, 15);
            } else if (carportCalculator.calculatePostAmountNeeded(carportRequest.getLength()) == 4) {
                svg.addRect(45 + carportCalculator.calculateXDistance(carportRequest.getLength()), 0, 15, 15);
                svg.addRect(45 + carportCalculator.calculateXDistance(carportRequest.getLength()) + carportCalculator.calculatePostDistance(carportRequest.getLength()), 0, 15, 15);
                svg.addRect(45 + carportCalculator.calculateXDistance(carportRequest.getLength()), carportRequest.getWidth() - 15, 15, 15);
                svg.addRect(45 + carportCalculator.calculateXDistance(carportRequest.getLength()) + carportCalculator.calculatePostDistance(carportRequest.getLength()), carportRequest.getWidth() - 15, 15, 15);
            }

            *//*Top og bund rem*//*

            svg.addLine(0, 0, carportRequest.getLength(), 0);
            svg.addLine(0, carportRequest.getWidth(), carportRequest.getLength(), carportRequest.getWidth());

            *//*if (carportRequest.getLength()>= 780) {
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
            }*//*

        }

        request.setAttribute("svgdrawing", svg.toString());
        return pageToShow;
    }
}*/
