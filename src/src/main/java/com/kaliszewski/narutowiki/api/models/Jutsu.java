package com.kaliszewski.narutowiki.api.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "shinobi")
@ToString(exclude = "shinobi")

public class Jutsu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shinobi_id")
    @Getter(AccessLevel.NONE)
    private Shinobi shinobi;

    private String name;


}
