package com.utnphones.utnphones.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue
    @Column(name = "city_id")
    private Integer id;

    @Column(name = "city_name", unique = true)
    private String city;

    @Column(name = "prefix")
    private String prefix;

    @JoinColumn(name = "province_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Province province;

    @OneToMany(mappedBy = "city")
    private List <User> userList;

}
