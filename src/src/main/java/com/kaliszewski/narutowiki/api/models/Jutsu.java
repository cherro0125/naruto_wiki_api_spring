package com.kaliszewski.narutowiki.api.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Jutsu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shinobi_id")
    private Shinobi shinobi;


    private String name;


}
