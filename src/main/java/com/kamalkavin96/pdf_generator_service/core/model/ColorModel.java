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
public class ColorModel {

    @Schema(description = "Red value (0–255)", example = "255", minimum = "0", maximum = "255")
    @Min(0)
    @Max(255)
    private Integer r;

    @Schema(description = "Green value (0–255)", example = "0", minimum = "0", maximum = "255")
    @Min(0)
    @Max(255)
    private Integer g;

    @Schema(description = "Blue value (0–255)", example = "0", minimum = "0", maximum = "255")
    @Min(0)
    @Max(255)
    private Integer b;
}
