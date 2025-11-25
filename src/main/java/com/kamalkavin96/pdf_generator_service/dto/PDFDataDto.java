package com.kamalkavin96.pdf_generator_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kamalkavin96.pdf_generator_service.core.model.BaseElementModel;
import com.kamalkavin96.pdf_generator_service.core.model.HeaderModel;
import com.kamalkavin96.pdf_generator_service.core.model.PDFConfigModel;
import com.kamalkavin96.pdf_generator_service.core.model.ParagraphModel;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(
            description = "List of elements inside the PDF"
    )
    private List<BaseElementModel> elements;
}
