package com.kamalkavin96.pdf_generator_service.core.components;

import com.kamalkavin96.pdf_generator_service.dto.PDFDataDto;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;

public class PDFConfigComponent {

    public static Document getNewDocument(PDFDataDto root){
        return new Document(PageSize.A4,
                root.getPdfConfig().marginLeft(),
                root.getPdfConfig().marginRight(),
                root.getPdfConfig().marginTop(),
                root.getPdfConfig().marginBottom()
        );
    }

}
