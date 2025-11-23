package com.kamalkavin96.pdf_generator_service.core;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import tools.jackson.databind.JsonNode;

import java.io.OutputStream;

public class PdfGenerator {

    public void generateSinglePDF(JsonNode root, OutputStream out){

        Document document = new Document(PageSize.A4, 36, 36, 36, 36);
        PdfWriter.getInstance(document, out);
        document.open();

        com.lowagie.text.Font titleFont =
                new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 22, com.lowagie.text.Font.BOLD);

        Paragraph title = new Paragraph("SBIN FULL STOCK REPORT", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.close();
    }

}
