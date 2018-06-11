package com.kaliszewski.narutowiki.api.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "jutsu")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="shinobi")
public class Shinobi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shinobi_id")
    private Long id;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "shinobi", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Jutsu> jutsu;

    private int age;

    private String photo_url;

}
