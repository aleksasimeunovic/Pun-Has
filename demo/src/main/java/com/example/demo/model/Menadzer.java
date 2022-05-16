package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Menadzer extends Korisnik {

    @OneToOne()
    private Restoran restoran;
    public Menadzer(String username, String password,String name, String lastName, POLOVI pol){
        super();
        this.username = username;
        this.password = password;
        this.Ime = name;
        this.Prezime = lastName;
        this.Pol = pol;
        this.Datum_rodjenja = new java.util.Date(System.currentTimeMillis());
        this.Uloga = ULOGA.Menadzer;
    }


    public Menadzer(Korisnik k, Restoran zadRest){
        super(k);
        this.restoran = zadRest;
    }
    public Menadzer(){}

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}