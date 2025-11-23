package com.kamalkavin96.pdf_generator_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kamalkavin96.pdf_generator_service.core.model.HeaderModel;
import com.kamalkavin96.pdf_generator_service.core.model.PDFConfigModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PDFDataDto {
    private PDFConfigModel pdfConfig;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private HeaderModel header;
}
