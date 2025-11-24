package com.kamalkavin96.pdf_generator_service.core.components;

import com.kamalkavin96.pdf_generator_service.dto.PDFDataDto;
import com.kamalkavin96.pdf_generator_service.core.model.PDFConfigModel;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;

public class PDFConfigComponent {

    private static final float DEFAULT_MARGIN = 36f;

    public static Document getNewDocument(PDFDataDto root) {

        PDFConfigModel config = root.getPdfConfig();

        float left   = config != null && config.getMarginLeft()   != null ? config.getMarginLeft()   : DEFAULT_MARGIN;
        float right  = config != null && config.getMarginRight()  != null ? config.getMarginRight()  : DEFAULT_MARGIN;
        float top    = config != null && config.getMarginTop()    != null ? config.getMarginTop()    : DEFAULT_MARGIN;
        float bottom = config != null && config.getMarginBottom() != null ? config.getMarginBottom() : DEFAULT_MARGIN;

        return new Document(PageSize.A4, left, right, top, bottom);
    }
}
