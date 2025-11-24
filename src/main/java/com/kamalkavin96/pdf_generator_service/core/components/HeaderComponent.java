package com.kamalkavin96.pdf_generator_service.core.components;

import com.kamalkavin96.pdf_generator_service.core.model.ColorModel;
import com.kamalkavin96.pdf_generator_service.core.model.HeaderModel;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import java.awt.*;

public class HeaderComponent {

    private final Document document;
    private final HeaderModel model;

    private static final float DEFAULT_PADDING = 10f;
    private static final float DEFAULT_MARGIN = 10f;
    private static final float DEFAULT_FONT_SIZE = 20f;
    private static final String DEFAULT_FONT_FAMILY = "helvetica";
    private static final String DEFAULT_FONT_STYLE = "bold";
    private static final float DEFAULT_WIDTH_PERCENTAGE = 100f;

    private static final ColorModel DEFAULT_TEXT_COLOR = new ColorModel(0, 0, 0);
    private static final ColorModel DEFAULT_BG_COLOR = new ColorModel(255, 255, 255);


    public HeaderComponent(Document document, HeaderModel model) {
        this.document = document;
        this.model = model;
    }

    private Color toColor(ColorModel c) {
        if (c == null) c = DEFAULT_TEXT_COLOR;
        return new Color(c.getR(), c.getG(), c.getB());
    }

    private int mapHorizontal(String align) {
        if (align == null) return Element.ALIGN_CENTER;
        return switch (align.toLowerCase()) {
            case "left"   -> Element.ALIGN_LEFT;
            case "right"  -> Element.ALIGN_RIGHT;
            default -> Element.ALIGN_CENTER;
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

    private int mapFontFamily(String family) {
        if (family == null) family = DEFAULT_FONT_FAMILY;

        return switch (family.toLowerCase()) {
            case "courier" -> Font.COURIER;
            case "times", "times-roman", "timesroman" -> Font.TIMES_ROMAN;
            default -> Font.HELVETICA;
        };
    }

    private Paragraph getTitlePara(Color textColor) {

        int fontStyle = mapFontStyle(model.getFontStyle());
        float fontSize = model.getFontSize() != null ? model.getFontSize() : DEFAULT_FONT_SIZE;
        int family = mapFontFamily(model.getFontFamily());

        Font titleFont = new Font(family, fontSize, fontStyle, textColor);

        Paragraph titlePara = new Paragraph(
                model.getHeader() != null ? model.getHeader() : "",
                titleFont
        );
        titlePara.setAlignment(mapHorizontal(model.getHorizontalAlignment()));
        return titlePara;
    }

    public void build() {

        if (model == null) return;

        float padding = model.getPadding() != null ? model.getPadding() : DEFAULT_PADDING;
        float margin  = model.getMargin()  != null ? model.getMargin()  : DEFAULT_MARGIN;

        Color textColor = toColor(model.getColor() != null ? model.getColor() : DEFAULT_TEXT_COLOR);
        Color bgColor   = toColor(model.getBgColor() != null ? model.getBgColor() : DEFAULT_BG_COLOR);

        Paragraph titlePara = getTitlePara(textColor);

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(model.getWidthPercentage() != null ? model.getWidthPercentage() : DEFAULT_WIDTH_PERCENTAGE);

        PdfPCell cell = new PdfPCell(titlePara);
        cell.setPadding(padding);
        cell.setBorderWidth(0);
        cell.setHorizontalAlignment(mapHorizontal(model.getHorizontalAlignment()));
        cell.setVerticalAlignment(mapVertical(model.getVerticalAlignment()));
        cell.setBackgroundColor(bgColor);

        table.addCell(cell);
        table.setSpacingBefore(margin);
        table.setSpacingAfter(margin);

        document.add(table);

    }
}
