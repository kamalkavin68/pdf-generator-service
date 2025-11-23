package com.kamalkavin96.pdf_generator_service.core.model;

public record HeaderModel(
    String header,
    ColorModel color,
    ColorModel bgColor,
    float padding,
    float margin
) {}
