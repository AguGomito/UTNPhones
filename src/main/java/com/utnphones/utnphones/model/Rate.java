package com.utnphones.utnphones.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JoinColumn(name = "city_id", nullable = false, insertable = false, updatable = false)
    @OneToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private City issuerCity;

    @JoinColumn(name = "city_id", nullable = false, insertable = false, updatable = false)
    @OneToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private City receiverCity;

    private Float minuteCost;
}
