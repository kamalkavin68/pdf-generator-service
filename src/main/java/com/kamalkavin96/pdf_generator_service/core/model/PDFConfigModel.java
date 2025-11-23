package com.kamalkavin96.pdf_generator_service.core.model;

import com.lowagie.text.Rectangle;

public record PDFConfigModel(
        float marginLeft,
        float marginRight,
        float marginTop,
        float marginBottom
) {}
