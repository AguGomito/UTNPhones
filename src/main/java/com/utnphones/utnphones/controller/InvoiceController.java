package com.utnphones.utnphones.controller;

import com.utnphones.utnphones.model.Invoice;
import com.utnphones.utnphones.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController (InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/")
    public void addInvoice (@RequestBody Invoice invoice) {
        invoiceService.addInvoice(invoice);
    }

    @GetMapping("/")
    public List <Invoice> getAll () {
        return invoiceService.getAll();
    }
}
