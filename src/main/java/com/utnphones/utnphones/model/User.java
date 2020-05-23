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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "dni", unique = true)
    private String dni;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "user_type")
    private Integer userType;

    @Column(name = "is_active")
    private Integer isActive;

    @JoinColumn(name = "city_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private City city;

    @OneToMany(mappedBy = "user")
    private List <PhoneLine> phoneLines;

}
