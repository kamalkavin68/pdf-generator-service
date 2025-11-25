package com.kamalkavin96.pdf_generator_service.core.components;

import com.lowagie.text.Font;

public class BaseComponent {

    private static final String DEFAULT_FONT_FAMILY = "helvetica";

    protected int mapFontFamily(String family) {
        if (family == null) family = DEFAULT_FONT_FAMILY;

        return switch (family.toLowerCase()) {

            case "courier"      -> Font.COURIER;
            case "times roman"  -> Font.TIMES_ROMAN;
            case "symbol"       -> Font.SYMBOL;
            case "zapfdingbats" -> Font.ZAPFDINGBATS;

            default             -> Font.HELVETICA;
        };
    }
}
