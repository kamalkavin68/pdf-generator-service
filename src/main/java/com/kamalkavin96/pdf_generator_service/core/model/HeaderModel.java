package com.kamalkavin96.pdf_generator_service.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeaderModel extends PDFElementModel{


    String header;
    String fontFamily;
    Float fontSize;
    String fontStyle;
    ColorModel color;
    ColorModel bgColor;
    Float padding;
    Float margin;
    String horizontalAlignment;
    String verticalAlignment;
    Float widthPercentage;
}
