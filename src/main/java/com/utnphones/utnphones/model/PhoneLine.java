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
@Table(name = "phonelines")
public class PhoneLine {

    @Id
    @GeneratedValue
    @Column(name = "line_id")
    private Integer id;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "line_type")
    private Integer lineType;

    @Column(name = "state")
    private Integer state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

}
