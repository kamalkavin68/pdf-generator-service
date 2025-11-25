package com.kamalkavin96.pdf_generator_service.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PDFConfigModel {

    @Schema(description = "Left margin of the PDF in points (0–200)", example = "20", minimum = "0", maximum = "200")
    @Min(0)
    @Max(200)
    private Float marginLeft;

    @Schema(description = "Right margin of the PDF in points (0–200)", example = "20", minimum = "0", maximum = "200")
    @Min(0)
    @Max(200)
    private Float marginRight;

    @Schema(description = "Top margin of the PDF in points (0–200)", example = "20", minimum = "0", maximum = "200")
    @Min(0)
    @Max(200)
    private Float marginTop;

    @Schema(description = "Bottom margin of the PDF in points (0–200)", example = "20", minimum = "0", maximum = "200")
    @Min(0)
    @Max(200)
    private Float marginBottom;
}
