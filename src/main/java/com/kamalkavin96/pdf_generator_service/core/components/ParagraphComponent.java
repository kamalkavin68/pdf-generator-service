package com.kamalkavin96.pdf_generator_service.core.components;

import com.kamalkavin96.pdf_generator_service.core.model.ColorModel;
import com.kamalkavin96.pdf_generator_service.core.model.ParagraphModel;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import java.awt.*;

public class ParagraphComponent extends BaseComponent {

    private final Document document;
    private final ParagraphModel model;

    private static final float DEFAULT_PADDING = 8f;
    private static final float DEFAULT_MARGIN = 8f;
    private static final float DEFAULT_FONT_SIZE = 12f;
    private static final String DEFAULT_FONT_FAMILY = "helvetica";
    private static final String DEFAULT_FONT_STYLE = "normal";
    private static final float DEFAULT_WIDTH_PERCENTAGE = 100f;

    private static final ColorModel DEFAULT_TEXT_COLOR = new ColorModel(0, 0, 0);
    private static final ColorModel DEFAULT_BG_COLOR = new ColorModel(255, 255, 255);

    public ParagraphComponent(Document document, ParagraphModel model) {
        this.document = document;
        this.model = model;
    }

    private Color toColor(ColorModel c) {
        if (c == null) c = DEFAULT_TEXT_COLOR;
        return new Color(c.getR(), c.getG(), c.getB());
    }

    private int mapHorizontal(String align) {
        if (align == null) return Element.ALIGN_LEFT;
        return switch (align.toLowerCase()) {
            case "center" -> Element.ALIGN_CENTER;
            case "right"  -> Element.ALIGN_RIGHT;
            case "justify" -> Element.ALIGN_JUSTIFIED;
            default -> Element.ALIGN_LEFT;
        };
    }

    private int mapVertical(String align) {
        if (align == null) return Element.ALIGN_MIDDLE;
        return switch (align.toLowerCase()) {
            case "top"    -> Element.ALIGN_TOP;
            case "bottom" -> Element.ALIGN_BOTTOM;
            default -> Element.ALIGN_MIDDLE;
        };
    }

    private int mapFontStyle(String style) {
        if (style == null) style = DEFAULT_FONT_STYLE;
        return switch (style.toLowerCase()) {
            case "bold" -> Font.BOLD;
            case "italic" -> Font.ITALIC;
            case "bold-italic" -> Font.BOLDITALIC;
            default -> Font.NORMAL;
        };
    }


    private Paragraph getParagraph(Color textColor) {

        int fontStyle = mapFontStyle(model.getFontStyle());
        float fontSize = model.getFontSize() != null ? model.getFontSize() : DEFAULT_FONT_SIZE;
        int family = mapFontFamily(model.getFontFamily());

        Font paraFont = new Font(family, fontSize, fontStyle, textColor);

        Paragraph para = new Paragraph(
                model.getText() != null ? model.getText() : "",
                paraFont
        );

        // alignment
        para.setAlignment(mapHorizontal(model.getHorizontalAlignment()));

        // line spacing
        if (model.getLineSpacing() != null) {
            para.setLeading(model.getLineSpacing());
        }

        return para;
    }

    public void build() {

        if (model == null) return;

        float padding = model.getPadding() != null ? model.getPadding() : DEFAULT_PADDING;
        float margin  = model.getMargin()  != null ? model.getMargin()  : DEFAULT_MARGIN;

        Color textColor = toColor(model.getColor() != null ? model.getColor() : DEFAULT_TEXT_COLOR);
        Color bgColor   = toColor(model.getBgColor() != null ? model.getBgColor() : DEFAULT_BG_COLOR);

        Paragraph para = getParagraph(textColor);

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(model.getWidthPercentage() != null ?
                model.getWidthPercentage() : DEFAULT_WIDTH_PERCENTAGE);

        PdfPCell cell = new PdfPCell(para);
        cell.setPadding(padding);
        cell.setBorderWidth(0);
        cell.setBackgroundColor(bgColor);
        cell.setHorizontalAlignment(mapHorizontal(model.getHorizontalAlignment()));
        cell.setVerticalAlignment(mapVertical(model.getVerticalAlignment()));

        table.addCell(cell);
        table.setSpacingBefore(margin);
        table.setSpacingAfter(margin);

        document.add(table);
    }
}
