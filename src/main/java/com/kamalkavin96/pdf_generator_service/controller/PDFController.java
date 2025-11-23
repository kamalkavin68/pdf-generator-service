package com.kamalkavin96.pdf_generator_service.controller;

import com.kamalkavin96.pdf_generator_service.dto.PdfPageSizeResponse;
import com.kamalkavin96.pdf_generator_service.service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.JsonNode;

import java.util.List;

@RestController
@RequestMapping("api/pdf")
public class PDFController {

    @Autowired
    PDFService pdfService;

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generatePDF(@RequestBody JsonNode JsonData){

        byte[] pdf = pdfService.generate(JsonData);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

    @GetMapping("/sizes")
    public List<PdfPageSizeResponse> getPageSizes() {
        return pdfService.getAvailablePageSizes();
    }
}
