package com.kamalkavin96.pdf_generator_service.service;

import com.kamalkavin96.pdf_generator_service.core.PdfGenerator;
import com.kamalkavin96.pdf_generator_service.dto.PDFDataDto;
import com.kamalkavin96.pdf_generator_service.dto.PdfPageSizeResponse;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class PDFService {

    public byte[] generate(PDFDataDto json){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfGenerator pdfGenerator = new PdfGenerator();
        pdfGenerator.generateSinglePDF(json, out);
        return out.toByteArray();
    }

    public List<PdfPageSizeResponse> getAvailablePageSizes(){
        List<PdfPageSizeResponse> sizes = new ArrayList<>();
        for (Field field : PageSize.class.getDeclaredFields()) {
            try {
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers())
                        && field.getType().equals(Rectangle.class)) {

                    Rectangle rect = (Rectangle) field.get(null);
                    sizes.add(new PdfPageSizeResponse(
                            field.getName(),
                            rect.getWidth(),
                            rect.getHeight()
                    ));
                }
            } catch (Exception ignored) {}
        }

        return sizes;
    }

}
