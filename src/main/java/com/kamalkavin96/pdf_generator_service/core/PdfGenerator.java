package com.kamalkavin96.pdf_generator_service.core;

import com.kamalkavin96.pdf_generator_service.core.components.HeaderComponent;
import com.kamalkavin96.pdf_generator_service.core.components.PDFConfigComponent;
import com.kamalkavin96.pdf_generator_service.core.model.HeaderModel;
import com.kamalkavin96.pdf_generator_service.core.model.PDFElementModel;
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
            for (PDFElementModel el : root.getElements()) {

                if (el.getType().equals("header")) {
                    HeaderModel header = (HeaderModel) el;
                    new HeaderComponent(document, header).build();
                    continue;
                }

                // ░░░ FUTURE:
                // if (el instanceof ParagraphModel p) new ParagraphComponent(...).build();
                // if (el instanceof ImageModel img) new ImageComponent(...).build();

            }
        }

        document.close();
    }
}
