package com.utnphones.utnphones.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @JoinColumn(foreignKey = @ForeignKey(name = "province_id"), name = "province_id", referencedColumnName = "province_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Province province;

}
