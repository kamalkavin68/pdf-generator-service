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
@Schema(description = "Paragraph element")
public class ParagraphModel extends BaseElementModel {

    @Schema(
            description = "Type of PDF element",
            allowableValues = {"paragraph"},
            example = "paragraph",
            required = true
    )
    private String type;

    @Schema(description = "Paragraph text content", example = "This is a sample paragraph.")
    private String text;

    @Schema(
            description = "Font family for paragraph text",
            allowableValues = {"helvetica", "courier", "times roman", "symbol", "zapfdingbats"},
            example = "helvetica"
    )
    private String fontFamily;

    @Schema(
            description = "Font size of the paragraph text",
            example = "12"
    )
    private Float fontSize;

    @Schema(
            description = "Font style such as bold, italic, normal",
            allowableValues = {"normal", "bold", "italic", "bold-italic"},
            example = "normal"
    )
    private String fontStyle;

    @Schema(description = "Text color in RGB (r,g,b)", implementation = ColorModel.class)
    private ColorModel color;

    @Schema(description = "Line spacing for the paragraph", example = "14")
    private Float lineSpacing;

    @Schema(description = "Spacing between characters", example = "0.5")
    private Float letterSpacing;

    @Schema(description = "Indentation for the first line of paragraph", example = "10")
    private Float firstLineIndent;

    @Schema(
            description = "Horizontal alignment of text",
            allowableValues = {"left", "center", "right", "justify"},
            example = "left"
    )
    private String horizontalAlignment;

    @Schema(
            description = "Vertical alignment of text",
            allowableValues = {"top", "middle", "bottom"},
            example = "middle"
    )
    private String verticalAlignment;

    @Schema(description = "Padding inside paragraph block", example = "8")
    private Float padding;

    @Schema(description = "Margin outside paragraph block", example = "8")
    private Float margin;

    @Schema(description = "Paragraph background color in RGB (r,g,b)", implementation = ColorModel.class)
    private ColorModel bgColor;

    @Schema(
            description = "Width percentage when placed inside a table or container",
            example = "100"
    )
    private Float widthPercentage;
}
