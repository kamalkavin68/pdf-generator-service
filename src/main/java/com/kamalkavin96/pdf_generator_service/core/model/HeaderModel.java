package com.kamalkavin96.pdf_generator_service.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Header element")
public class HeaderModel extends BaseElementModel {

    @Schema(
            description = "Type of element",
            allowableValues = {"header"},
            example = "header",
            required = true
    )
    private String type;

    @Schema(description = "Header text content", example = "My Document Title")
    private String header;

    @Schema(
            description = "Font family for header text",
            allowableValues = {"helvetica", "courier", "times"},
            example = "helvetica"
    )
    private String fontFamily;

    @Schema(description = "Font size of header text", example = "20")
    private Float fontSize;

    @Schema(
            description = "Font style such as bold, italic, normal",
            allowableValues = {"normal", "bold", "italic", "bold-italic"},
            example = "bold"
    )
    private String fontStyle;

    @Schema(description = "Text color in RGB (r,g,b)", implementation = ColorModel.class)
    private ColorModel color;

    @Schema(description = "Background color in RGB (r,g,b)", implementation = ColorModel.class)
    private ColorModel bgColor;

    @Schema(description = "Padding inside header block", example = "10")
    private Float padding;

    @Schema(description = "Margin outside header block", example = "10")
    private Float margin;

    @Schema(
            description = "Horizontal alignment for header text",
            allowableValues = {"left", "center", "right"},
            example = "center"
    )
    private String horizontalAlignment;

    @Schema(
            description = "Vertical alignment for header text",
            allowableValues = {"top", "middle", "bottom"},
            example = "middle"
    )
    private String verticalAlignment;

    @Schema(description = "Width percentage of the header block", example = "100")
    private Float widthPercentage;
}
