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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer id;

    @Column(name = "city_name", unique = true)
    private String name;

    @Column(name = "prefix")
    private String prefix;

    @JoinColumn(name = "province_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Province province;

    @OneToMany(mappedBy = "city")
    @JsonBackReference
    private List <User> userList;

}
