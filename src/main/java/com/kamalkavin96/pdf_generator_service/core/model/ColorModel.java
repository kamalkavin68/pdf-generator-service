package com.kamalkavin96.pdf_generator_service.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColorModel {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    int r;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    int b;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    int g;
}


