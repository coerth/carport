package dat.startcode.model.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.stream.Stream;

public class PdfCreator {

    public Document createPdf() throws DocumentException, FileNotFoundException {

        /*String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ArrayList<BomDTO> bomDTOArrayList =  request.getParameter("bomDTOArrayList");*/


    var doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("Oversigt.pdf"));
        doc.open();
    var bold = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    var paragraph = new Paragraph("Ordrebekræftelse:");

    var table = new PdfPTable(2);
        Stream.of("Materiale", "Beskrivelse").forEach(table::addCell);


        Arrays.stream(ChronoUnit.values())
                .forEach(val-> {
        table.addCell(val.toString());
        table.addCell(val.getDuration().toString());
    });

        paragraph.add(table);
        doc.add(paragraph);
        doc.close();

        return doc;
    }





}
