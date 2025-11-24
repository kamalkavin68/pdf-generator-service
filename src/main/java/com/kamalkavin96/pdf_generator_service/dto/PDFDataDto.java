package com.kamalkavin96.pdf_generator_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kamalkavin96.pdf_generator_service.core.model.HeaderModel;
import com.kamalkavin96.pdf_generator_service.core.model.PDFConfigModel;
import com.kamalkavin96.pdf_generator_service.core.model.PDFElementModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PDFDataDto {
    private PDFConfigModel pdfConfig;
    private List<PDFElementModel> elements;
}
