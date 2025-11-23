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

    public HeaderComponent(Document document, HeaderModel model) {
        this.document = document;
        this.model = model;
    }

    private Color toColor(ColorModel c) {
        if (c == null) return null;
        return new Color(c.getR(), c.getG(), c.getB());
    }

    public void build() {

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);

        Color textColor = toColor(model.color());
        Color bgColor = toColor(model.bgColor());

        Font titleFont = new Font(Font.HELVETICA, 20, Font.BOLD, textColor);

        Paragraph titlePara = new Paragraph(model.header(), titleFont);
        titlePara.setAlignment(Element.ALIGN_CENTER);

        PdfPCell cell = new PdfPCell(titlePara);
        cell.setPadding(model.padding());
        cell.setBorderWidth(0);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        if (bgColor != null)
            cell.setBackgroundColor(bgColor);

        table.addCell(cell);

        table.setSpacingBefore(model.margin());
        table.setSpacingAfter(model.margin());

        document.add(table);
    }
}
