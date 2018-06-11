package com.kaliszewski.narutowiki.api.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Entity
@Data
public class Character {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    @ElementCollection(targetClass=String.class)
    private List<String> jutsu;
    private int age;

}
