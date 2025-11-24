package com.kamalkavin96.pdf_generator_service.core.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PDFConfigModel {

    Float marginLeft;
    Float marginRight;
    Float marginTop;
    Float marginBottom;
}
