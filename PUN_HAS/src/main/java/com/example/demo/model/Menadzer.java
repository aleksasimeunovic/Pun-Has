package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Menadzer extends Korisnik {

    @OneToOne(mappedBy = "Menadzer")
    private Restoran restoran;

    public Menadzer(Korisnik k, Restoran zadRest ){
        super(k);
        this.restoran = zadRest;
    }

    public Menadzer() {

    }


    public Restoran getZadRest() {
        return restoran;
    }

    public void setZadRest(Restoran zadRest) {
        this.restoran = zadRest;
    }
}
