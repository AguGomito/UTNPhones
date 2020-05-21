package com.utnphones.utnphones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "calls")
public class Call {

    @Id
    @GeneratedValue
    @Column(name = "call_id")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_issuer_id")
    private PhoneLine phoneLineIssuer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_receiver_id")
    private PhoneLine phoneLineReceiver;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rate_id")
    private Rate rate;

    @Column(name = "call_price")
    private Float callPrice;

    @Column(name = "duration")
    private Float duration;

    @Column(name = "date")
    private Timestamp date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

}
