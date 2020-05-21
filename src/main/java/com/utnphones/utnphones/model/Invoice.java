package com.utnphones.utnphones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue
    @Column(name = "invoice_id")
    private Integer id;

    @JoinColumn(name = "line_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private PhoneLine phoneLine;

    @Column(name = "invoice_total")
    private Float invoiceTotal;

    @Column(name = "price_cost")
    private Float priceCost;

    @Column(name = "price_total")
    private Float priceTotal;

    @Column(name = "nmbr_of_calls")
    private Integer numberOfCalls;

    @Column(name = "issuing_date")
    private Timestamp issuingDate;

    @Column(name = "due_date")
    private Date dueDate;

}
