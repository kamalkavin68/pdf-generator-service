package com.kamalkavin96.pdf_generator_service.core;

import com.kamalkavin96.pdf_generator_service.core.components.HeaderComponent;
import com.kamalkavin96.pdf_generator_service.core.components.PDFConfigComponent;
import com.kamalkavin96.pdf_generator_service.core.components.ParagraphComponent;
import com.kamalkavin96.pdf_generator_service.core.model.BaseElementModel;
import com.kamalkavin96.pdf_generator_service.core.model.HeaderModel;
import com.kamalkavin96.pdf_generator_service.core.model.ParagraphModel;
import com.kamalkavin96.pdf_generator_service.dto.PDFDataDto;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import java.io.OutputStream;

public class PdfGenerator {

    public void generateSinglePDF(PDFDataDto root, OutputStream out) {

        Document document = PDFConfigComponent.getNewDocument(root);
        PdfWriter.getInstance(document, out);
        document.open();

        if (root.getElements() != null) {
            for (BaseElementModel el : root.getElements()) {

                // ---------- HEADER ----------
                if ("header".equalsIgnoreCase(el.getType())) {
                    HeaderModel header = (HeaderModel) el;
                    new HeaderComponent(document, header).build();
                    continue;
                }

                // ---------- PARAGRAPH ----------
                if ("paragraph".equalsIgnoreCase(el.getType())) {
                    ParagraphModel para = (ParagraphModel) el;
                    new ParagraphComponent(document, para).build();
                    continue;
                }

                // ADD MORE TYPES HERE
                // if ("image".equals(el.getType())) ...
                // if ("table".equals(el.getType())) ...
            }

        }

        document.close();
    }
}
