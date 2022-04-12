package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dostavljac extends Korisnik implements Serializable {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Porudzbina> porudzbine = new HashSet<>();


    public Dostavljac(Korisnik k,Set<Porudzbina>porudzbine) {
        super(k);
        this.porudzbine = porudzbine;
    }

    public Dostavljac() {


    }

}