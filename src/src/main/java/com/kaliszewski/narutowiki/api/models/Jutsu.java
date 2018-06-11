package com.kaliszewski.narutowiki.api.models;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Jutsu {
    private String name;

}
