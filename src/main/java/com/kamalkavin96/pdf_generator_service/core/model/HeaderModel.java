package com.kamalkavin96.pdf_generator_service.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Getter
@Setter
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
