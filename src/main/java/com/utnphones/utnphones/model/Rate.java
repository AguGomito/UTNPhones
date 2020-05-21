package com.utnphones.utnphones.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rates")
public class Rate {

    @Id
    @GeneratedValue
    @Column(name = "rate_id")
    private Integer id;

    @JoinColumn(name = "issuer_city_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private City issuerCity;

    @JoinColumn(name = "receiver_city_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private City receiverCity;

    @Column(name = "cost_minute")
    private Float minuteCost;
}
