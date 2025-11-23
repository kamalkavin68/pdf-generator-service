package com.kamalkavin96.pdf_generator_service.core;

import com.kamalkavin96.pdf_generator_service.core.components.HeaderComponent;
import com.kamalkavin96.pdf_generator_service.core.components.PDFConfigComponent;
import com.kamalkavin96.pdf_generator_service.core.model.HeaderModel;
import com.kamalkavin96.pdf_generator_service.dto.PDFDataDto;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import java.io.OutputStream;

public class PdfGenerator {

    public void generateSinglePDF(PDFDataDto root, OutputStream out) {

        Document document = PDFConfigComponent.getNewDocument(root);
        PdfWriter.getInstance(document, out);
        document.open();

        new HeaderComponent(document, root.getHeader()).build();

        document.close();
    }
}
