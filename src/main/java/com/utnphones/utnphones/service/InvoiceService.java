package com.utnphones.utnphones.service;

import com.utnphones.utnphones.model.Invoice;
import com.utnphones.utnphones.repository.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final IInvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void addInvoice (Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public List <Invoice> getAll () {
        return invoiceRepository.findAll();
    }
}
