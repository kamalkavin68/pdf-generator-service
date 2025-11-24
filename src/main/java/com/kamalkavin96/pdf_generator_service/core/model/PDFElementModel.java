package com.kamalkavin96.pdf_generator_service.core.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.DEDUCTION
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = HeaderModel.class, name = "header")
})
public class PDFElementModel {
    private String type;
}
