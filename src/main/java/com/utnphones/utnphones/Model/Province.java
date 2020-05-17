package com.utnphones.utnphones.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "provinces")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id", unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "province")
    private List<City> cities;

}